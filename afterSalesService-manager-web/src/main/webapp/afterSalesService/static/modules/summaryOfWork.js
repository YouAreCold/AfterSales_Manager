/** afterSalesService.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
	var t = layui.$,
		i = layui.table,
		r = (layui.form, layui.element);
	var mTypeId = layui.mTypeId;
	i.render({
		elem: "#LAY-app-system-order",
		//url: layui.setter.base + "json/ad/demo.js",
		url:"http://127.0.0.1:8081/wsummary/read/listPageAndPlant",
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
				width: 100,
				title: "内码",
				align: "center",
				sort: !0
			}, {
				field: "fWsummaryOwner",
				title: "姓名",
				align: "center"
			}, {
				field: "fWsummaryLevel",
				title: "职位",
				align: "center"
			}, {
				field: "fWsummaryContent",
				title: "内容",
				align: "center"
			}, {
				field: "fWsummaryOpinion",
				title: "主管意见",
				align: "center"
			}, {
				field: "fWsummaryCheckdate",
				title: "审核日期",
				align: "center"
			}, {
				field: "fWsummaryChecker",
				title: "审核人",
				align: "center"
			},{
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
		if("del" === t.event) layer.confirm("确定删除此工作总结？", function(e) {
			var jsonData = { "id" : i.id };
			 $.ajax({
                url: "http://127.0.0.1:8081/wsummary/read/delete?dels=-1",
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
				title: "编辑工作总结",
				content: "../../../views/application/summaryOfWork/listform.html",
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
								/*"fWsummaryPid" :  n.find('input[name="fWsummaryPid"]').val(),*/
								"id" :  n.find('input[name="summaryOfWork_id"]').val(),
								"fWsummaryOwner" :  n.find('input[name="fWsummaryOwner"]').val(),
								"fWsummaryLevel" :  n.find('input[name="fWsummaryLevel"]').val(),
								"fWsummaryContent" :  n.find('input[name="fWsummaryContent"]').val(),
								"fWsummaryOpinion" :  n.find('input[name="fWsummaryOpinion"]').val(),
								"fWsummaryCheckdate" :  n.find('input[name="fWsummaryCheckdate"]').val(),
								"fWsummaryChecker" :  n.find('input[name="fWsummaryChecker"]').val()
							
						};
					$.ajax({
		               	url: "http://127.0.0.1:8081/wsummary",
		               	type: "POST",
		               	data: JSON.stringify(jsonData),
		               	dataType: 'json',
		               	contentType: "application/json;charset=UTF-8",
		               	success: function(data){
		                   if(data.code=="0"){
		                   		t.update({
									id :  n.find('input[name="summaryOfWork_id"]').val(),
									fWsummaryOwner :  n.find('input[name="fWsummaryOwner"]').val(),
									fWsummaryLevel :  n.find('input[name="fWsummaryLevel"]').val(),
									fWsummaryContent :  n.find('input[name="fWsummaryContent"]').val(),
									fWsummaryOpinion :  n.find('input[name="fWsummaryOpinion"]').val(),
									fWsummaryCheckdate :  n.find('input[name="fWsummaryCheckdate"]').val(),
									fWsummaryChecker :  n.find('input[name="fWsummaryChecker"]').val()
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
					n.find('input[name="summaryOfWork_id"]').val(i.id);
					n.find('input[name="fWsummaryOwner"]').val(i.fWsummaryOwner);
					n.find('input[name="fWsummaryLevel"]').val(i.fWsummaryLevel);
					n.find('input[name="fWsummaryContent"]').val(i.fWsummaryContent);
					n.find('input[name="fWsummaryOpinion"]').val(i.fWsummaryOpinion);
					n.find('input[name="fWsummaryCheckdate"]').val(i.fWsummaryCheckdate);
					n.find('input[name="fWsummaryChecker"]').val(i.fWsummaryChecker);
				}
			})
		}
	}), e("summaryOfWork", {})
});