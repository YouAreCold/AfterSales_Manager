/** afterSalesService.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
	var t = layui.$,
		i = layui.table,
		r = (layui.form, layui.element);
	var mTypeId = layui.mTypeId;
	i.render({
		elem: "#LAY-app-system-order",
		url:"http://127.0.0.1:8081/complaint/read/listPage",
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
				field: "fNumber",
				title: "代码",
				align: "center",
				width: 130
			}, {
				field: "fReply",
				title: "批复意见",
				align: "center",
				width: 200
			}, {
				field: "fClerkName",
				title: "业务员",
				align: "center",
				width: 120
			}, {
				field: "fTeacherNumber",
				title: "老师代码",
				align: "center",
				width: 120
			}, {
				field: "fTeacher",
				title: "老师名称",
				align: "center",
				width: 130
			}, {
				field: "fTeacherPhone",
				title: "老师电话",
				width: 160,
				align: "center"
			}, {
				field: "fClientName",
				title: "客户名称",
				width: 130,
				align: "center"
			}, {
				field: "fWords",
				title: "投诉建议",
				width: 300,
				align: "center"
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
		if("del" === t.event) layer.confirm("确定删除此物料管理？", function(e) {
			var jsonData = { "id" : i.id };
			 $.ajax({
                url: "http://127.0.0.1:8081/complaint/read/delete?dels=-1",
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
				title: "投诉建议-编辑",
				content: "../../../views/basicInformation/complaintRecord/listform.html",
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
							"id" :  n.find('input[name="complaintRecord_id"]').val(),
							"fNumber" :  n.find('input[name="fNumber"]').val(),
							"fCancel" :  n.find('input[name="fCancel"]').val(),
							"fStatus" :  n.find('input[name="fStatus"]').val(),
							"fSel" :  n.find('input[name="fSel"]').val(),
							"fTeacherNumber" :  n.find('input[name="fTeacherNumber"]').val(),
							"fTeacherItemId" :  n.find('input[name="fTeacherItemId"]').val(),
							"fTeacher" :  n.find('input[name="fTeacher"]').val(),
							"fClientName" :  n.find('input[name="fClientName"]').val(),
							"fClientPhone" :  n.find('input[name="fClientPhone"]').val(),
							"fClientAddress" :  n.find('input[name="fClientAddress"]').val(),
							"fWords" :  n.find('input[name="fWords"]').val(),
							"fClerkName" :  n.find('input[name="fClerkName"]').val(),
							"fReply" :  n.find('input[name="fReply"]').val(),
							"fCheck" :  n.find('input[name="fCheck"]').val(),
							"fCheckDate" :  n.find('input[name="fCheckDate"]').val()
						};
					$.ajax({
		               	url: "http://127.0.0.1:8081/complaintRecord",
		               	type: "POST",
		               	data: JSON.stringify(jsonData),
		               	dataType: 'json',
		               	contentType: "application/json;charset=UTF-8",
		               	success: function(data){
		                   if(data.code=="0"){
		                   		t.update({
									id :  n.find('input[name="complaintRecord_id"]').val(),
									fNumber :  n.find('input[name="fNumber"]').val(),
									fBrand :  n.find('input[name="fBrand"]').val(),
									fName :  n.find('input[name="fName"]').val(),
									fModel :  n.find('input[name="fModel"]').val(),
									fAlias :  n.find('input[name="fAlias"]').val(),
									fChartNumber :  n.find('input[name="fChartNumber"]').val(),
									fHelpCode:  n.find('input[name="fHelpCode"]').val(),
									fEquipmentNum :  n.find('input[name="fEquipmentNum"]').val(),
									fSalePrice :  n.find('input[name="fSalePrice"]').val(),
									fType :  n.find('input[name="fType"]').val()
									
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
					n.find('input[name="complaintRecord_id"]').val(i.id);
					n.find('input[name="fNumber"]').val(i.fNumber);
					n.find('input[name="fBrand"]').val(i.fBrand);
					n.find('input[name="fName"]').val(i.fName);
					n.find('input[name="fModel"]').val(i.fModel);
					n.find('input[name="fAlias"]').val(i.fAlias);
					n.find('input[name="fChartNumber"]').val(i.fChartNumber);
					n.find('input[name="fHelpCode"]').val(i.fHelpCode);
					n.find('input[name="fEquipmentNum"]').val(i.fEquipmentNum);
					n.find('input[name="fSalePrice"]').val(i.fSalePrice);
					n.find('input[name="fType"]').val(i.fType);
				}
			})
		}
	}), e("complaintRecord", {})
});