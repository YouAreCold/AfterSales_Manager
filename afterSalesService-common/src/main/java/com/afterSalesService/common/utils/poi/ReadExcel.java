package com.afterSalesService.common.utils.poi;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import com.afterSalesService.common.utils.IDUtils;


/**
 * Excel导入工具类
 * @author wjx
 *
 */
public class ReadExcel {
     // 总行数
     private int totalRows = 0;
     // 总条数
     private int totalCells = 0;
     // 错误信息接收器
     private String errorMsg;
 
     // 构造方法
     public ReadExcel() {
     }
 
     // 获取总行数
     public int getTotalRows() {
         return totalRows;
     }
 
     // 获取总列数
     public int getTotalCells() {
         return totalCells;
     }
 
     // 获取错误信息
     public String getErrorInfo() {
         return errorMsg;
     }
 
     /**
      * 读EXCEL文件，获取信息集合
      * 
      * @param fielName
      * @return
      */
     public List<String> getExcelInfo(MultipartFile mFile) {
         String fileName = mFile.getOriginalFilename();// 获取文件名
 //        List<Map<String, Object>> userList = new LinkedList<Map<String, Object>>();
         try {
             if (!validateExcel(fileName)) {// 验证文件名是否合格
                 return null;
             }
             boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
             if (isExcel2007(fileName)) {
                 isExcel2003 = false;
             }
             return createExcel(mFile.getInputStream(), isExcel2003);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }
 
     /**
      * 根据excel里面的内容读取客户信息
      * 
      * @param is      输入流
      * @param isExcel2003   excel是2003还是2007版本
      * @return
      * @throws IOException
      */
     public List<String> createExcel(InputStream is, boolean isExcel2003) {
         try {
             Workbook wb = null;
             if (isExcel2003) {// 当excel是2003时,创建excel2003
                 wb = new HSSFWorkbook(is);
             } /*else {// 当excel是2007时,创建excel2007
                 wb = new XSSFWorkbook(is);
             }*/
             return readExcelValue(wb);// 读取Excel里面客户的信息
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }
 
     /**
      * 读取Excel里面客户的信息
      * 
      * @param wb
      * @return
      */
     @SuppressWarnings("deprecation")
	private List<String> readExcelValue(Workbook wb) {
         // 得到第一个shell
         Sheet sheet = wb.getSheetAt(0);
         // 得到Excel的行数
         this.totalRows = sheet.getPhysicalNumberOfRows();
         // 表名
         String tableName = wb.getSheetName(0);
         // 得到Excel的列数(前提是有行数)
         if (totalRows > 1 && sheet.getRow(0) != null) {
             this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();;
         }
         List<Map<String, Object>> tablesList = new ArrayList<Map<String, Object>>();
         // 字段列表
         List<String> healtList = new ArrayList<String>();
         // excel列表
         List<List<Object>> tableLists = new ArrayList<List<Object>>();
         // SQL列表
         List<String> sqlList = new ArrayList<String>();
         // 循环Excel行数
         for (int r = 1; r < totalRows; r++) {
        	 List<Object> tableList = new ArrayList<Object>();
             Row row = sheet.getRow(r);
             if (row == null) {
                 continue;
             }
             for (int c = 0; c < this.totalCells; c++) {
                 Cell cell = row.getCell(c);
                 if (null != cell) {
                	 cell.setCellType(Cell.CELL_TYPE_STRING);
                	 if(r==1) 
                		 healtList.add(cell.getStringCellValue());
                	 else
                		 tableList.add(cell.getStringCellValue());
                 }
             }
             tableLists.add(tableList);
            
         }
         // 封装需要导入的SQL
         for (List<Object> list : tableLists) {
        	 if(null!=list && list.size() > 0){
                 // 公共字段
        		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        		 String date = df.format(new Date());
        		 // 拼接SQL
        		 StringBuffer insertSql = new StringBuffer();
            	 insertSql.append("insert into "+tableName);
            	 // 字段名
            	 String keyData = "created,updated,";
            	 // 字段值
            	 String valueData = "'"+date+"','"+date+"',";
            	 for (int i = 0; i < healtList.size(); i++) {
            		 keyData+=healtList.get(i)+",";
            		 valueData+="'"+list.get(i)+"',";
                  }
            	 insertSql.append(" (id,"+keyData.substring(0,keyData.length()-1)+") values ("+IDUtils.genItemId()+","+valueData.substring(0,valueData.length()-1)+");");
            	 sqlList.add(insertSql.toString());
        	 }
		}
         return sqlList;
     }
 
     /**
      * 验证EXCEL文件
      * 
      * @param filePath
      * @return
      */
     public boolean validateExcel(String filePath) {
         if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
             errorMsg = "文件名不是excel格式";
             return false;
         }
         return true;
     }
 
     // @描述：是否是2003的excel，返回true是2003
     public static boolean isExcel2003(String filePath) {
         return filePath.matches("^.+\\.(?i)(xls)$");
     }
 
     // @描述：是否是2007的excel，返回true是2007
     public static boolean isExcel2007(String filePath) {
         return filePath.matches("^.+\\.(?i)(xlsx)$");
     }
     
 }