package com.afterSalesService.common.base.service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.afterSalesService.common.base.pojo.BaseModel;
import com.afterSalesService.common.utils.IDUtils;
import com.afterSalesService.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * Service父类  
 * @author wjx
 *
 * @param <T>
 */
public class BaseService<T> extends BaseModel {

	@Autowired
	public BaseMapper<T> mapper;
	
	// 输入日志
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据ID查询   单条 对象形式
	 * @param itemId
	 * @return
	 */
	public Object queryById(Long itemId) {
		Object item = mapper.selectById(itemId);
		return item;
	}
	

	/**
	 * 删除
	 * @param itemId
	 */
	public void delete(Long itemId) {
		mapper.deleteById(itemId);
	}

	/**
	 * 根据全部查询数据
	 * @param param
	 * @return
	 */
	public List queryList(Map<String, Object> param) {
		EntityWrapper<T> entityWrapper = new EntityWrapper<T>();
		Object obj = mapToBean(param);
		entityWrapper.setEntity((T) obj);
		return mapper.selectList(entityWrapper);
	}
	
	/**
	 * 根据条件查询数据
	 * @param whereParam map的key为数据库字段名    String[] 数组 为   1.逻辑符   2.值   3.相等符
	 * 			例1:  key:name   String[] : ["AND","张三","="]
	 * 			例2:  key:name   String[] : ["OR","'张%'","LIKE"]
	 *          注意：有 "%"  一定要加单引号括起来  例: "'%关键字%'"
	 * @return
	 */
	public List queryListToData(Object obj,Map<String, String[]> whereParam){
		EntityWrapper<T> ew = new EntityWrapper<T>();
		ew.where(whereToString(whereParam));
		try {
			obj = ((Class<?>) obj).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		ew.setEntity((T)obj);
		
		List<T> list = mapper.selectList(ew);
		return list;
	}

	/**
	 * 分页查询数据
	 * @param param
	 * @return
	 */
	public Page queryPage(Map<String, Object> param) {
		Page<T> page = new Page<>();
		if (param.containsKey("limit") && !"".equals((param.get("limit") + ""))
				&& Integer.valueOf(param.get("limit") + "") > 0) {
			page.setSize((Integer.valueOf(param.get("limit") + "")));
		} else {
			page.setSize(10);
		}
		if (param.containsKey("page") && !"".equals((param.get("page") + ""))
				&& Integer.valueOf(param.get("page") + "") > 0) {
			page.setCurrent((Integer.valueOf(param.get("page") + "")));
		} else {
			page.setCurrent(1);
		}
		EntityWrapper<T> entityWrapper = new EntityWrapper<>();
		//Object obj = mapToBean(param);
		// 追加查询条件  start
		Map<String, String[]> whereParam = new HashMap<String, String[]>();
		
		// 循环获取所有查询条件
		for (Map.Entry<String, Object> entry : param.entrySet()) {
			if("page".equals(entry.getKey()) || "class".equals(entry.getKey()) || "limit".equals(entry.getKey())|| "orderby".equals(entry.getKey())) continue;
			String valueString = entry.getValue().toString().replace("***", ",");
			String[] vArrayStrings = valueString.split(",");
	        whereParam.put(entry.getKey(), vArrayStrings);
	    }
		entityWrapper.where(whereToString(whereParam));
		// 追加查询条件  end
		//entityWrapper.setEntity((T) obj);
		
//		if (param.containsKey("orderby") && !"".equals((param.get("orderby") + ""))) {
//			Object orderbyObj = param.get("orderby");
//			logger.info("产生排序==>"+orderbyObj);
//			Object[] orderArray = (Object[])orderbyObj;
//			/*for (int i = 0; i < orderStrings.length; i++) {
//				logger.info(orderStrings[0].toString()+" "+(boolean)orderStrings[1]);
//			}
//			entityWrapper.orderBy(orderStrings[0].toString(), (boolean)orderStrings[1]);*/
//		}
		page.setRecords(mapper.selectPage(page, entityWrapper));
		return page;
	}

	/**
	 * 增加与更新数据
	 * @param param
	 * @return
	 */
	public Object update(Map<String, Object> param) {
		Object obj = mapToBean(param);
		if (param.containsKey("id") && param.get("id") != null && !"".equals(param.get("id"))) {
			mapper.updateById((T) obj);
			obj = mapper.selectById((Serializable) param.get("id"));
		} else {
			param.put("id", IDUtils.genItemId());// 生成ID
			obj = mapToBean(param);
			mapper.insert((T) obj);
			obj = mapper.selectById((Serializable) param.get("id"));
		}
		return obj;
	}

	/**
	 * 转换class
	 * @param param
	 * @return
	 */
	private Object mapToBean(Map<String, Object> param) {
		Object obj = null;
		try {
			obj = ((Class<?>) param.get("class")).newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		ConvertUtils.register(new Converter() {
			@SuppressWarnings("rawtypes")
			public Object convert(Class arg0, Object arg1) {
				if (arg1 == null) {
					return null;
				}
				if (!(arg1 instanceof String)||!(arg1 instanceof Date)) {
					throw new ConversionException("只支持字符串转换 !");
				}
				String str = (String) arg1;
				if (str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					return sd.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}

		}, java.util.Date.class);
		try {
			BeanUtils.populate(obj, param);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * 取where值
	 */
	private String whereToString(Map<String, String[]> param){
		// 拼接where参数
 		Set<Entry<String, String[] >> entrySet=param.entrySet();
 		// 返回拼接字符串
 		StringBuffer sqlWhere = new StringBuffer();
        for(Iterator<Entry<String, String[]>> iterator= entrySet.iterator();iterator.hasNext();){
            Entry<String, String[]> entry=iterator.next();
            // 字段
            String name = entry.getKey();
            // 逻辑符 1.AND   2.OR
            String condition = (entry.getValue()[0].equals("1"))?("AND"):("OR");
            // 相等符  1.LIKE  2.=   3.>=  4.<=   5.>   6.<
            String eq = "LIKE";
            if(entry.getValue()[2].equals("1")){
            	eq = "LIKE";
            }else if(entry.getValue()[2].equals("2")){
            	eq = "=";
            }else if(entry.getValue()[2].equals("3")){
            	eq = ">=";
            }else if(entry.getValue()[2].equals("4")){
            	eq = "<=";
            }else if(entry.getValue()[2].equals("5")){
            	eq = ">";
            }else if(entry.getValue()[2].equals("6")){
            	eq = "<";
            }
            // 值
            String value = entry.getValue()[1];
            try {
            	String encoding = StringUtil.getEncoding(value);
            	logger.info("字符类型==>"+encoding+":"+value);
            	if(encoding.equals("ISO-8859-1")||value.indexOf("687") != -1)
            		value = new String(value.getBytes("ISO8859-1"),"utf-8");
            	if(value.indexOf("687") != -1) 	// 模糊查询时使用
            		value = "'"+value.replace("687", "%")+"'"; 
            	else if(value.indexOf("999") != -1)	// 跳过该查询条件
            		continue;
            	else
            		if(value.indexOf("'")==-1) value = "'" + value + "'";
            	
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // 第一个参数前面拼接true
            if(sqlWhere.indexOf("1=1") == -1){
            	sqlWhere.append(MessageFormat.format("1=1 {0} {1} {2} {3} ", condition , name, eq, value));
            }else{
                sqlWhere.append(MessageFormat.format(" {0} {1} {2} {3}", condition , name, eq, value));
            }
        }
		return sqlWhere.toString();
	}
}
