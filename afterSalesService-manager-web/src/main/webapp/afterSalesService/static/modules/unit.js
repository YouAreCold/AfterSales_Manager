/** afterSalesService.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
	var t = layui.$,
		i = layui.table,
		r = (layui.form, layui.element);
	i.render({
		elem: "#LAY-app-system-order",
		//url: layui.setter.base + "json/ad/demo.js",
		url:"http://127.0.0.1:8081/unit/read/listPage",
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
				field: "id",
				width: 200,
				title: "内码",
				align: "center",
				sort: !0
			}, {
				field: "fNumber",
				title: "代码",
				align: "center",
				width: 200
			}, {
				field: "fUnitName",
				title: "单位名称",
				align: "center",
				width: 400
			}, {
				field: "fSortId",
				title: "排序号",
				align: "center",
				width: 100
			}, {
				field: "created",
				title: "创建时间",
				align: "center",
				width: 200
			}, {
				field: "updated",
				title: "近期修改时间",
				align: "center",
				width: 200
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
		if("del" === t.event) layer.confirm("确定删除此单位管理？", function(e) {
			var jsonData = { "id" : i.id };
			 $.ajax({
                url: "http://127.0.0.1:8081/unit/read/delete?dels=-1",
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
				title: "编辑此单位",
				content: "../../../views/basicInformation/unit/listform.html",
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
							"id":n.find('input[name="unit_id"]').val(),
							"fNumber":n.find('input[name="fNumber"]').val(),
							"fUnitName":n.find('input[name="fUnitName"]').val(),
							"updated" : getNowFormatDate()
						};
					$.ajax({
		               	url: "http://127.0.0.1:8081/unit",
		               	type: "POST",
		               	data: JSON.stringify(jsonData),
		               	dataType: 'json',
		               	contentType: "application/json;charset=UTF-8",
		               	success: function(data){
		                   if(data.code=="0"){
		                   		t.update({
									id :  n.find('input[name="unit_id"]').val(),
									fNumber :  n.find('input[name="fNumber"]').val(),
									fUnitName :  n.find('input[name="fUnitName"]').val(),
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
					n.find('input[name="fUnitName"]').val(i.fUnitName);
					n.find('input[name="unit_id"]').val(i.id);
				}
			})
		}
	}), e("unit", {})
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