/** afterSalesService.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
	var t = layui.$,
		i = layui.table,
		r = (layui.form, layui.element);
	i.render({
		elem: "#LAY-app-system-order",
		//url: layui.setter.base + "json/ad/demo.js",
		url:"http://127.0.0.1:8081/staff/read/listPage",
		method:"POST",
		toolbar: true,
		cols: [
			[{
				type: "numbers",
				title: "序号",
				fixed: "left",
				align: "center"
			},{
				type: "checkbox",
				fixed: "left",
				align: "center"
			}, {
				field: "id",
				width: 100,
				title: "内码",
				sort: !0,
				align: "center"
			}, {
				field: "fNumber",
				title: "代码",
				width: 150,
				align: "center"
			}, {
				field: "fName",
				title: "职员名称",
				width: 100,
				align: "center"
			}, {
				field: "fEmpGroup",
				title: "职员分类",
				width: 100,
				align: "center"
			}, {
				field: "fDeptId",
				title: "部门内码",
				width: 130,
				align: "center"
			}, {
				field: "fSex",
				title: "性别",
				templet: "#buttonSex",
				width: 80,
				align: "center"
			}, {
				field: "fBirthday",
				title: "出生日期",
				width: 130,
				align: "center"
			}, {
				field: "fPhone",
				title: "手机",
				width: 130,
				align: "center"
			}, {
				field: "fId",
				title: "身份证号码",
				width: 180,
				align: "center"
			}, {
				field: "fDutyId",
				title: "职务内码",
				width: 150,
				align: "center"
			}, {
				field: "fHireDate",
				title: "入职日期",
				width: 130,
				align: "center"
			}, {
				field: "fLeaveDate",
				title: "离职日期",
				width: 130,
				align: "center"
			}, {
				field: "fBankAccount",
				title: "开户银行及账号",
				width: 200,
				align: "center"
			}, {
				field: "fAddress",
				title: "住址",
				width: 150,
				align: "center"
			}, {
				field: "fEmail",
				title: "电子邮件",
				width: 200,
				align: "center"
			}, {
				field: "fRemarks",
				title: "备注",
				width: 230,
				align: "center"
			}, {
				field: "fSortId",
				title: "排序",
				width: 70,
				align: "center"
			}, {
				field: "fDeleted",
				title: "是否禁用",
				templet: "#buttonDeleted",
				width: 90,
				align: "center"
			}, {
				title: "操作",
				align: "center",
				fixed: "right",
				width: 157,
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
		if("del" === t.event) layer.confirm("确定除去此职员？", function(e) {
			var jsonData = { "id" : i.id };
			 $.ajax({
                url: "http://127.0.0.1:8081/staff/read/delete?dels=-1",
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
				title: "编辑职员管理",
				content: "../../../views/basicInformation/staff/listform.html",
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
							"id" :  n.find('input[name="staff_id"]').val(),
							"fNumber" :  n.find('input[name="fNumber"]').val(),
							"fName" :  n.find('input[name="fName"]').val(),
							"fEmpGroup" :  n.find('input[name="fEmpGroup"]').val(),
							"fDeptId" :  n.find('input[name="fDeptId"]').val(),
							"fSex" :  n.find('select[name="fSex"]').val(),
							"fBirthday" :  n.find('input[name="fBirthday"]').val(),
							"fPhone" :  n.find('input[name="fPhone"]').val(),
							"fId" :  n.find('input[name="fId"]').val(),
							"fDutyId" :  n.find('input[name="fDutyId"]').val(),
							"fHireDate" :  n.find('input[name="fHireDate"]').val(),
							"fLeaveDate" :  n.find('input[name="fLeaveDate"]').val(),
							"fBankAccount" :  n.find('input[name="fBankAccount"]').val(),
							"fAddress" :  n.find('input[name="fAddress"]').val(),
							"fEmail" :  n.find('input[name="fEmail"]').val(),
							"fRemarks" :  n.find('input[name="fRemarks"]').val(),
							"fDeleted" :  n.find('select[name="fDeleted"]').val(),
							"updated" : getNowFormatDate()
						};
					$.ajax({
		               	url: "http://127.0.0.1:8081/staff",
		               	type: "POST",
		               	data: JSON.stringify(jsonData),
		               	dataType: 'json',
		               	contentType: "application/json;charset=UTF-8",
		               	success: function(data){
		                   if(data.code=="0"){
		                   		t.update({
		                   			id :  n.find('input[name="staff_id"]').val(),
									fNumber :  n.find('input[name="fNumber"]').val(),
									fName :  n.find('input[name="fName"]').val(),
									fEmpGroup :  n.find('input[name="fEmpGroup"]').val(),
									fDeptId :  n.find('input[name="fDeptId"]').val(),
									fSex :  n.find('select[name="fSex"]').val(),
									fBirthday :  n.find('input[name="fBirthday"]').val(),
									fPhone :  n.find('input[name="fPhone"]').val(),
									fId :  n.find('input[name="fId"]').val(),
									fDutyId :  n.find('input[name="fDutyId"]').val(),
									fHireDate :  n.find('input[name="fHireDate"]').val(),
									fLeaveDate :  n.find('input[name="fLeaveDate"]').val(),
									fBankAccount :  n.find('input[name="fBankAccount"]').val(),
									fAddress :  n.find('input[name="fAddress"]').val(),
									fEmail :  n.find('input[name="fEmail"]').val(),
									fRemarks :  n.find('input[name="fRemarks"]').val(),
									fDeleted :  n.find('select[name="fDeleted"]').val()
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
					n.find('input[name="fName"]').val(i.fName);
					n.find('input[name="fEmpGroup"]').val(i.fEmpGroup);
					n.find('input[name="fDeptId"]').val(i.fDeptId);
					n.find('input[name="fBirthday"]').val(i.fBirthday);
					n.find('input[name="fPhone"]').val(i.fPhone);
					n.find('input[name="fId"]').val(i.fId);
					n.find('input[name="fDutyId"]').val(i.fDutyId);
					n.find('input[name="fHireDate"]').val(i.fHireDate);
					n.find('input[name="fLeaveDate"]').val(i.fLeaveDate);
					n.find('input[name="fBankAccount"]').val(i.fBankAccount);
					n.find('input[name="fBirthday"]').val(i.fBirthday);
					n.find('input[name="fAddress"]').val(i.fAddress);
					n.find('input[name="fEmail"]').val(i.fEmail);
					n.find('input[name="fRemarks"]').val(i.fRemarks);
					n.find('input[name="staff_id"]').val(i.id);
					n.find('select[name="fSex"]').empty();
					if(i.fSex=='1'){
						n.find('select[name="fSex"]').append("<option value='1'>男</option>").append("<option value='2'>女</option>").append("<option value='0'>未知</option>");
					}else if(i.fSex=='2'){
						n.find('select[name="fSex"]').append("<option value='2'>女</option>").append("<option value='1'>男</option>").append("<option value='0'>未知</option>");
					}else if(i.fSex=='0'){
						n.find('select[name="fSex"]').append("<option value='0'>未知</option>").append("<option value='1'>男</option>").append("<option value='2'>女</option>");
					}
					n.find('select[name="fDeleted"]').empty();
					if(i.fDeleted=='1'){
						n.find('select[name="fDeleted"]').append("<option value='1'>启用</option>").append("<option value='0'>禁用</option>");
					}else if(i.fDeleted=="0"){
						n.find('select[name="fDeleted"]').append("<option value='0'>禁用</option>").append("<option value='1'>启用</option>");
					}
				}
			})
		}
	}), e("staff", {})
});