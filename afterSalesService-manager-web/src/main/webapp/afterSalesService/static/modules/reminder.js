/** afterSalesService.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
	var t = layui.$,
		i = layui.table,
		r = (layui.form, layui.element);
	i.render({
		elem: "#LAY-app-system-order",
		url: "http://127.0.0.1:8081/organization/read/listPageAndReminder",
		method: "POST",
		toolbar: true,
		cols: [
			[{
				type: "numbers",
				title: "序号",
				align: "center",
				fixed: "left"
			}, {
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
		done: function() {
			r.render("progress")
		}
	}), i.on("tool(LAY-app-system-order)", function(t) {
		var i = t.data;
		// 预约
		if("reservationBtn" === t.event) {
			var jsonData = {
				"id" : i.id,
				"fStatus" : 1
			};
			layer.confirm('是否预约？', {
			  btn: ['预约','取消'] //按钮
			}, function(){
			  $.ajax({
                url: "http://127.0.0.1:8081/organization",
                type: "POST",
                data: JSON.stringify(jsonData),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function(data){
                    if(data.code=="0"){
                    	t.del();
                        layer.msg("预约成功", {icon: 6});
                    }else{
                        layer.msg("预约失败", {icon: 5});
                    }
                },
                error: function() {
                	layer.msg("接口调用异常", {icon: 5});
            	}
              });
			}, function(){
			  layer.msg('取消预约操作', {time: 1000});
			});
		}else if("ignoreBtn" === t.event) {
			var jsonData = {
				"id": i.id,
				"fStatus" : 2
			};
			layer.confirm('是否忽略？', {
			  btn: ['忽略','取消'] //按钮
			}, function(){
			  $.ajax({
                url: "http://127.0.0.1:8081/organization",
                type: "POST",
                data: JSON.stringify(jsonData),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function(data){
                    if(data.code=="0"){
                    	t.del();
                        layer.msg("已忽略", {icon: 6});
                    }else{
                        layer.msg("忽略失败", {icon: 5});
                    }
                },
                error: function() {
                	layer.msg("接口调用异常", {icon: 5});
            	}
              });
			}, function(){
			  layer.msg('取消忽略操作', {time: 1000});
			});
		}else if("putOffBtn" === t.event) {
			var jsonData = {
				"id": i.id ,
				"fStatus" : 3
			};
			layer.confirm('是否推迟？', {
			  btn: ['推迟','取消'] //按钮
			}, function(){
			  $.ajax({
                url: "http://127.0.0.1:8081/organization",
                type: "POST",
                data: JSON.stringify(jsonData),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function(data){
                    if(data.code=="0"){
                    	t.del();
                        layer.msg("推迟成功", {icon: 6});
                    }else{
                        layer.msg("推迟失败", {icon: 5});
                    }
                },
                error: function() {
                	layer.msg("接口调用异常", {icon: 5});
            	}
              });
			}, function(){
			  layer.msg('取消推迟操作', {time: 1000});
			});
		}
		
	}), e("reminder", {})
});
// 获取当前时间
function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if(month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if(strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate +
		" " + date.getHours() + seperator2 + date.getMinutes() +
		seperator2 + date.getSeconds();
	return currentdate;
}
