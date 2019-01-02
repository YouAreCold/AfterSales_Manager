/** afterSalesService.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
	var t = layui.$,
		i = layui.table,
		r = (layui.form, layui.element);
	i.render({
		elem: "#LAY-app-system-order",
		//url: layui.setter.base + "json/ad/demo.js",
		url:"http://127.0.0.1:8081/organization/read/listPageAndDept",
		method:"POST",
		toolbar: true,
		cols: [
			[{
				type: "numbers",
				title: "序号",
				align: "center",
				fixed: "left"
			},{
				type: "checkbox",
				align: "center",
				fixed: "left"
			}, {
				field: "fNumber",
				title: "代码",
				align: "center",
				width: 80
			}, {
				field: "fName",
				title: "客户名称",
				align: "center",
				width: 100
			}, {
				field: "fAddress",
				title: "地址",
				align: "center",
				width: 150,
			}, {
				field: "fEmail",
				title: "电子邮件",
				align: "center",
				width: 120
			}, {
				field: "fBank",
				title: "开户银行",
				align: "center",
				width: 90
			}, {
				field: "fAccount",
				title: "银行账号",
				align: "center",
				width: 240
			}, {
				field: "fDeptName",
				title: "分管部门",
				align: "center",
				width: 90
			}, {
				field: "fSex",
				title: "性别",
				templet: "#buttonSexType",
				width: 65,
				align: "center"
			}, {
				field: "fDeleted",
				title: "是否禁用",
				templet: "#buttonFDeleted",
				width: 88,
				align: "center"
			}, {
				field: "created",
				title: "创建时间",
				align: "center",
				width: 120
			}, {
				field: "updated",
				title: "近期修改时间",
				align: "center",
				width: 120
			}, {
				title: "操作",
				align: "center",
				fixed: "right",
				toolbar: "#table-system-order"
			}]
		],
		page: !0,
		limit: 10,
		limits: [10, 15, 20, 25, 30],
		text: "对不起，加载出现异常！",
		done: function(res) {
			var tableArray = new Array();
			tableArray = res.data;
			var dateTime = new Date(getNowFormatDate().replace(/-/,"/"));// 当前时间
			for(var i = 0;i<tableArray.length;i++)
			{
				// 创建时间超过30天的用户 设为提醒
				var createdTime = new Date(tableArray[i].created.replace(/-/,"/"));// 创建时间
				//计算出相差天数
				var days=Math.floor((dateTime.getTime()-createdTime.getTime())/(24*3600*1000));
				// 大于30天时进行提醒
				if(days >= 30 && tableArray[i].fStatus==0)
				{
					m=i+1;
					$("tr").eq(m).css("background-color","#FFF6F3");
				}
			}
			r.render("progress");
		}
	}), i.on("tool(LAY-app-system-order)", function(t) {
		var i = t.data;
		if("del" === t.event) layer.confirm("确定删除此客户管理？", function(e) {
			var jsonData = { "id" : i.id };
			 $.ajax({
                url: "http://127.0.0.1:8081/organization/read/delete?dels=-1",
                type: "POST",
                data: JSON.stringify(jsonData),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function(data){
                    if(data.code=="0"){
                        t.del();
                        layer.close(e);
                        layer.msg("删除成功", {icon: 6});
                    }else{
                        layer.msg("删除失败", {icon: 5});
                    }
                },
                error: function() {
                	layer.msg("接口调用异常", {icon: 5});
            	}
            });
		});
		// 详情
		else if("details" === t.event) {
			// 菜单入参
			var jsonParent = {
				"page":1,
				"limit":1,
				"id":i.id
			};
			//1.创建ajax对象
			if(window.XMLHttpRequest) //如果有XMLHttpRequest，那就是非IE6浏览器。()里面加window的原因下面会有描述。
			{
				var oAjax = new XMLHttpRequest(); //创建ajax对象
			} else //如果没有XMLHttpRequest，那就是IE6浏览器
			{
				var oAjax = new ActiveXObject("Microsoft.XMLHTTP"); //IE6浏览器创建ajax对象
			}
			//2.连接服务器并且设置请求头
			oAjax.open("GET", "http://127.0.0.1:8081/organization/read/listPageAndDept?page=1&limit=1&id="+i.id, true);
			oAjax.setRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
			oAjax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
			
			//3.发送请求
			oAjax.send(null);
		
			//4.接收返回 客户端和服务器端有交互的时候会调用onreadystatechange
			oAjax.onreadystatechange = function() {
				if(oAjax.readyState == 4) //oAjax.readyState  //浏览器和服务器，进行到哪一步了。
				{
					if(oAjax.status == 200) //判断是否成功,如果是200，就代表成功
					{
						var jsonData = JSON.parse(oAjax.responseText);
		
						var orgData = jsonData.data[0];// 单条查询数据
						var fDeleted = (orgData.fDeleted=='0')?('禁用'):('启用');// 是否禁用
						var fSex='';// 性别
						if(orgData.fSex=="0") fSex = "未知";
						else if(orgData.fSex=="1") fSex = "男";
						else fSex = "女";
						var fStatus='';// 当前状态
						if(orgData.fStatus=="0") fStatus = "正常";
						else if(orgData.fStatus=="1") fStatus = "预约";
						else if(orgData.fStatus=="2") fStatus = "忽略";
						else fStatus = "推迟";
						var htmlString ='<style>'+
							'.table-wrapper{'+
							'    margin: 10px 20px 20px;'+
							'}'+
							'.fl-table {'+
							'    border-radius: 5px;'+
							'    font-size: 12px;'+
							'    font-weight: normal;'+
							'    border: none;'+
							'    border-collapse: collapse;'+
							'    width: 100%;'+
							'    max-width: 100%;'+
							'    white-space: nowrap;'+
							'    background-color: white;'+
							'}'+
							'.fl-table td, .fl-table th {'+
							'    text-align: center;'+
							'    padding: 8px;'+
							'}'+
							'.fl-table td {'+
							'    border-right: 1px solid #f8f8f8;'+
							'    font-size: 12px;'+
							'}'+
							'.fl-table thead th {'+
							'    color: #ffffff;'+
							'    background: #4FC3A1;'+
							'}'+
							'.fl-table thead th:nth-child(odd) {'+
							'    color: #ffffff;'+
							'    background: #324960;'+
							'}'+
							'.fl-table tr:nth-child(even) {'+
							'    background: #F8F8F8;'+
							'}'+
							'/* Responsive */'+
							'@media (max-width: 767px) {'+
							'    .fl-table {'+
							'        display: block;'+
							'        width: 100%;'+
							'    }'+
							'    .table-wrapper:before{'+
							'        content: "Scroll horizontally >";'+
							'        display: block;'+
							'        text-align: right;'+
							'        font-size: 11px;'+
							'        color: white;'+
							'        padding: 0 0 10px;'+
							'    }'+
							'    .fl-table thead, .fl-table tbody, .fl-table thead th {'+
							'        display: block;'+
							'    }'+
							'    .fl-table thead th:last-child{'+
							'        border-bottom: none;'+
							'    }'+
							'    .fl-table thead {'+
							'        float: left;'+
							'    }'+
							'    .fl-table tbody {'+
							'        width: auto;'+
							'        position: relative;'+
							'        overflow-x: auto;'+
							'    }'+
							'    .fl-table td, .fl-table th {'+
							'        padding: 20px .625em .625em .625em;'+
							'        height: 60px;'+
							'        vertical-align: middle;'+
							'        box-sizing: border-box;'+
							'        overflow-x: hidden;'+
							'        overflow-y: auto;'+
							'        width: 120px;'+
							'        font-size: 13px;'+
							'        text-overflow: ellipsis;'+
							'    }'+
							'    .fl-table thead th {'+
							'        text-align: left;'+
							'        border-bottom: 1px solid #f7f7f9;'+
							'    }'+
							'    .fl-table tbody tr {'+
							'        display: table-cell;'+
							'    }'+
							'    .fl-table tbody tr:nth-child(odd) {'+
							'        background: none;'+
							'    }'+
							'    .fl-table tr:nth-child(even) {'+
							'        background: transparent;'+
							'    }'+
							'    .fl-table tbody td {'+
							'        display: block;'+
							'        text-align: center;'+
							'    }'+
							'}'+
							'</style>'+ 
							'<div class="table-wrapper">'+
							'    <table class="fl-table">'+
							'        <thead>'+
							'        <tr>'+
							'            <th>字段</th>'+
							'            <th>数据</th>'+
							'        </tr>'+
							'        </thead>'+
							'        <tbody>'+
							'        <tr>'+
							'            <td>代码</td>'+
							'            <td>'+orgData.fNumber+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>客户名称</td>'+
							'            <td>'+orgData.fName+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>专营业务员名称</td>'+
							'            <td>'+orgData.fEmployeeName+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>地址</td>'+
							'            <td>'+orgData.fAddress+'</td>'+
							'        </tr>'+	
							'        <tr>'+
							'            <td>电子邮件</td>'+
							'            <td>'+orgData.fEmail+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>开户银行</td>'+
							'            <td>'+orgData.fBank+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>银行账号</td>'+
							'            <td>'+orgData.fAccount+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>部门名称</td>'+
							'            <td>'+orgData.fDeptName+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>区域</td>'+
							'            <td>'+orgData.fArea+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>简称</td>'+
							'            <td>'+orgData.fShortName+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>是否禁用</td>'+
							'            <td>'+fDeleted+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>性别</td>'+
							'            <td>'+fSex+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>电话</td>'+
							'            <td>'+orgData.fPhone+'</td>'+
							'        </tr>'+
							'        <tr>'+
							'            <td>当前状态</td>'+
							'            <td>'+fStatus+'</td>'+
							'        </tr>'+
							'        <tbody>'+
							'    </table>'+
							'</div>';
							layer.open({
						        type: 1
						        ,title: false //不显示标题栏
						        ,closeBtn: true
						        ,area: '600px;'
						        ,shade: 0.8
						        ,shadeClose : true
						        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
						        ,btnAlign: 'c'
						        ,moveType: 1 //拖拽模式，0或者1
						        ,content: htmlString
						        ,success: function(layero){
						          var btn = layero.find('.layui-layer-btn');
				//		          btn.find('.layui-layer-btn0').attr({
				//		            href: 'http://www.layui.com/'
				//		            ,target: '_blank'
				//		          });
						var $ = layui.$, active = {
						    parseTable: function(){
						      table.init('parse-table-demo', { //转化静态表格
						        //height: 'full-500'
						      }); 
						    }
						  };
					  
					  
					    var type = $(this).data('type');
					    active[type] ? active[type].call(this) : '';
					  
							        }
							    });
									}
								}
							};	
		}
		else if("edit" === t.event) {
			e(t.tr);
			layer.open({
				type: 2,
				title: "编辑客户管理",
				content: "../../../views/basicInformation/organization/listform.html",
				area: ["550px", "550px"],
				btn: ["确定", "取消"],
        		btn2: function(index, layero){
        			layer.msg('取消操作', {
				      time: 1000
				    });
        		},
				yes: function(e, i) {
					var n = i.find("iframe").contents().find("#afterSalesService-form-order");
					var jsonData = { 
							"id" :  n.find('input[name="organization_id"]').val(),
							"fNumber" :  n.find('input[name="fNumber"]').val(),
							"fEmployeeName" :  n.find('input[name="fEmployeeName"]').val(),
							"fAddress" :  n.find('input[name="fAddress"]').val(),
							"fEmail" :  n.find('input[name="fEmail"]').val(),
							"fBank" :  n.find('input[name="fBank"]').val(),
							"fAccount" :  n.find('input[name="fAccount"]').val(),
							"fDeptId" :  n.find('select[name="fDeptId"]').val(),
							"fPhone" :  n.find('input[name="fPhone"]').val(),
							"fArea" :  n.find('input[name="fArea"]').val(),
							"fShortName" :  n.find('input[name="fShortName"]').val(),
							"fName" :  n.find('input[name="fName"]').val(),
							"fSex" :  n.find('select[name="fSex"]').val(),
							"fDeleted" :  n.find('select[name="fDeleted"]').val()
						};
					$.ajax({
		               	url: 'http://127.0.0.1:8081/organization',
		               	type: 'POST',
		               	data: JSON.stringify(jsonData),
		               	dataType: 'json',
		               	contentType: 'application/json;charset=UTF-8',
		               	success: function(data){
		                   if(data.code=='0'){
		                   		t.update({
									id :  n.find('input[name="organization_id"]').val(),
									fNumber :  n.find('input[name="fNumber"]').val(),
									fEmployeeName :  n.find('input[name="fEmployeeName"]').val(),
									fAddress :  n.find('input[name="fAddress"]').val(),
									fEmail :  n.find('input[name="fEmail"]').val(),
									fBank :  n.find('input[name="fBank"]').val(),
									fAccount :  n.find('input[name="fAccount"]').val(),
									fDeptName:  n.find('select[name="fDeptId"] option:selected').text(),
									fPhone :  n.find('input[name="fPhone"]').val(),
									fArea :  n.find('input[name="fArea"]').val(),
									fShortName :  n.find('input[name="fShortName"]').val(),
									fName :  n.find('input[name="fName"]').val(),
									fSex :  n.find('select[name="fSex"]').val(),
									fDeleted :  n.find('select[name="fDeleted"]').val(),
									updated : getNowFormatDate()
								})
		                   		layer.close(e);
		                       	layer.msg('修改成功', {icon: 6});
		                   }else{
		                       	layer.msg('修改失败', {icon: 5});
		                   }
		               	},
		               	error: function() {
		               		layer.msg('接口调用异常', {icon: 5});
		            	}
		            });
				},
				success: function(t, e) {
					var n = t.find('iframe').contents().find('#afterSalesService-form-order').click();
					n.find('input[name="fNumber"]').val(i.fNumber);
					n.find('input[name="fEmployeeName"]').val(i.fEmployeeName);
					n.find('input[name="fAddress"]').val(i.fAddress);
					n.find('input[name="organization_id"]').val(i.id);
					n.find('input[name="fEmail"]').val(i.fEmail);
					n.find('input[name="fBank"]').val(i.fBank);
					n.find('input[name="fAccount"]').val(i.fAccount);
					n.find('input[name="fDeptId_hidden"]').val(i.fDeptId);
					n.find('input[name="fPhone"]').val(i.fPhone);
					n.find('input[name="fArea"]').val(i.fArea);
					n.find('input[name="fShortName"]').val(i.fShortName);
					n.find('input[name="fName"]').val(i.fName);
					n.find('input[name="fSex"]').val(i.fSex);
					n.find('input[name="fDeleted"]').val(i.fDeleted);
					n.find('select[name="fDeleted"]').empty();
					if(i.fDeleted=='1'){
						n.find('select[name="fDeleted"]').append("<option value='1'>启用</option>").append("<option value='0'>禁用</option>");
					}else if(i.fDeleted=="0"){
						n.find('select[name="fDeleted"]').append("<option value='0'>禁用</option>").append("<option value='1'>启用</option>");
					}
					n.find('select[name="fSex"]').empty();
					if(i.fSex=='1'){
						n.find('select[name="fSex"]').append("<option value='1'>男</option>").append("<option value='2'>女</option>").append("<option value='0'>未知</option>");
					}else if(i.fSex=='2'){
						n.find('select[name="fSex"]').append("<option value='2'>女</option>").append("<option value='1'>男</option>").append("<option value='0'>未知</option>");
					}else if(i.fSex=='0'){
						n.find('select[name="fSex"]').append("<option value='0'>未知</option>").append("<option value='1'>男</option>").append("<option value='2'>女</option>");
					}
				}
			})
		}
	}), e("organization", {})
});
// 获取当前时间
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}
