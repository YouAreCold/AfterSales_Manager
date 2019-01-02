/** afterSalesService.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
	var t = layui.$,
		i = layui.table,
		r = (layui.form, layui.element);
	var mTypeId = layui.mTypeId;
	i.render({
		elem: "#LAY-app-system-order",
		url:"http://127.0.0.1:8081/reservationLog/read/listPage",
		toolbar: true,
		method:"POST",
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
				field: "fOrdlogSn",
				title: "单号",
				align: "center",
				width: 120
			}, {
				field: "fOrdlogItemnumber",
				title: "产品代码",
				align: "center",
				width: 100
			}, {
				field: "fOrdlogItemnote",
				title: "产品品牌",
				align: "center",
				width: 200
			}, {
				field: "fOrdlogItemname",
				title: "产品名称",
				align: "center",
				width: 120
			}, {
				field: "fOrdlogItemcolor",
				title: "产品颜色",
				align: "center",
				width: 70
			}, {
				field: "fOrdlogQty",
				title: "数量",
				align: "center",
				width: 100
			}, {
				field: "fOrdlogBuydate",
				title: "购买日期",
				width: 100,
				align: "center"
			}, {
				field: "fOrdlogClient",
				title: "客户名称",
				minWidth: 100,
				align: "center"
			}, {
				field: "fOrdlogAmount",
				title: "收费进金额",
				width: 120,
				align: "center"
			}, {
				field: "fOrdlogSerowner",
				title: "服务技师",
				width: 90,
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
                url: "http://127.0.0.1:8081/materials/read/delete?dels=-1",
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
				title: "编辑物料管理",
				content: "../../../views/basicInformation/materials/listform.html",
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
							"id" :  n.find('input[name="materials_id"]').val(),
							"fNumber" :  n.find('input[name="fNumber"]').val(),
							"fBrand" :  n.find('input[name="fBrand"]').val(),
							"fName" :  n.find('input[name="fName"]').val(),
							"fModel" :  n.find('input[name="fModel"]').val(),
							"fAlias" :  n.find('input[name="fAlias"]').val(),
							"fChartNumber" :  n.find('input[name="fChartNumber"]').val(),
							"fHelpCode" :  n.find('input[name="fHelpCode"]').val(),
							"fEquipmentNum" :  n.find('input[name="fEquipmentNum"]').val(),
							"fSalePrice" :  n.find('input[name="fSalePrice"]').val(),
							"fType" :  n.find('input[name="fType"]').val()
						};
					$.ajax({
		               	url: "http://127.0.0.1:8081/materials",
		               	type: "POST",
		               	data: JSON.stringify(jsonData),
		               	dataType: 'json',
		               	contentType: "application/json;charset=UTF-8",
		               	success: function(data){
		                   if(data.code=="0"){
		                   		t.update({
									id :  n.find('input[name="materials_id"]').val(),
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
					n.find('input[name="materials_id"]').val(i.id);
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
	}), e("materials", {})
});