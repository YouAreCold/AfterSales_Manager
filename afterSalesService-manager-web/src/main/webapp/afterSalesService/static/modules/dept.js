/** afterSalesService.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
	var t = layui.$,
		i = layui.table,
		r = (layui.form, layui.element);
	i.render({
		elem: "#LAY-app-system-order",
		//url: layui.setter.base + "json/ad/demo.js",
		url:"http://127.0.0.1:8081/dept/read/listPage",
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
				fixed: "left"
			}, {
				field: "id",
				width: 150,
				title: "内码",
				align: "center",
				sort: !0
			}, {
				field: "fNumber",
				title: "代码",
				align: "center",
				width: 150
			}, {
				field: "fName",
				title: "部门名称",
				align: "center",
				width: 150
			}, {
				field: "fManagerName",
				title: "主管",
				align: "center",
				width: 130
			}, {
				field: "fRemarks",
				title: "备注",
				align: "center",
				width: 240
			}, {
				field: "fDeleted",
				title: "是否禁用",
				templet: "#buttonFDeleted",
				width: 120,
				align: "center"
			}, {
				field: "fSortId",
				title: "排序",
				width: 70,
				align: "center"
			}, {
				field: "created",
				title: "创建时间",
				align: "center",
				width: 160
			}, {
				field: "updated",
				title: "近期修改时间",
				align: "center",
				width: 160
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
			r.render("progress");
		}
	}), i.on("tool(LAY-app-system-order)", function(t) {
		var i = t.data;
		if("del" === t.event) layer.confirm("确定删除此部门管理？", function(e) {
			var jsonData = { "id" : i.id };
			 $.ajax({
                url: "http://127.0.0.1:8081/dept/read/delete?dels=-1",
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
		else if("edit" === t.event) {
			e(t.tr);
			layer.open({
				type: 2,
				title: "编辑部门管理",
				content: "../../../views/basicInformation/dept/listform.html",
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
							"id" :  n.find('input[name="dept_id"]').val(),
							"fNumber" : n.find('input[name="fNumber"]').val(),
							"fManagerName" :  n.find('input[name="fManagerName"]').val(),
							"fRemarks" :  n.find('input[name="fRemarks"]').val(),
							"fName" :  n.find('input[name="fName"]').val(),
							"fDeleted" :  n.find('select[name="fDeleted"]').val(),
							"updated" : getNowFormatDate()
						};
					$.ajax({
		               	url: "http://127.0.0.1:8081/dept",
		               	type: "POST",
		               	data: JSON.stringify(jsonData),
		               	dataType: 'json',
		               	contentType: "application/json;charset=UTF-8",
		               	success: function(data){
		                   if(data.code=="0"){
		                   		t.update({
									id :  n.find('input[name="dept_id"]').val(),
									fNumber :  n.find('input[name="fNumber"]').val(),
									fManagerName :  n.find('input[name="fManagerName"]').val(),
									fRemarks :  n.find('input[name="fRemarks"]').val(),
									fName :  n.find('input[name="fName"]').val(),
									fDeleted :  n.find('select[name="fDeleted"]').val(),
									updated : getNowFormatDate()
								})
		                   		layer.close(e);
		                       	layer.msg("修改成功", {icon: 6});
		                   }else{
		                       	layer.msg("修改失败", {icon: 5});
		                   }
		               	},
		               	error: function() {
		               		layer.msg("接口调用异常", {icon: 5});
		            	}
		            });
				},
				success: function(t, e) {
					var n = t.find("iframe").contents().find("#afterSalesService-form-order").click();
					n.find('input[name="fNumber"]').val(i.fNumber);
					n.find('input[name="fManagerName"]').val(i.fManagerName);
					n.find('input[name="fRemarks"]').val(i.fRemarks);
					n.find('input[name="dept_id"]').val(i.id);
					n.find('input[name="fName"]').val(i.fName);
					n.find('select[name="fDeleted"]').empty();
					if(i.fDeleted=="1"){
						n.find('select[name="fDeleted"]').append("<option value='1'>启用</option>").append("<option value='0'>禁用</option>");
					}else if(i.fDeleted=="0"){
						n.find('select[name="fDeleted"]').append("<option value='0'>禁用</option>").append("<option value='1'>启用</option>");
					}
				}
			})
		}
	}), e("dept", {})
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