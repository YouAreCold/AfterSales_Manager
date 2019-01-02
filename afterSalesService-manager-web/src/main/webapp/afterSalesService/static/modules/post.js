/** afterSalesService.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
	var t = layui.$,
		i = layui.table,
		r = (layui.form, layui.element);
	i.render({
		elem: "#LAY-app-system-order",
		url:"http://127.0.0.1:8081/post/read/listPage",
		toolbar: true,
		cols: [
			[{
				type: "numbers",
				title: "序号",
				fixed: "left",
				align: "center"
			},{
				type: "checkbox",
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
			}, {
				field: "fName",
				title: "岗位名称",
				align: "center",
			}, {
				field: "fLevel",
				title: "职级",
				align: "center",
			}, {
				field: "fSortId",
				title: "排序",
				align: "center",
				width: 70
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
		if("del" === t.event) layer.confirm("确定删除此职位管理？", function(e) {
			var jsonData = { "id" : i.id };
			 $.ajax({
                url: "http://127.0.0.1:8081/post/read/delete?dels=-1",
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
				title: "编辑职位管理",
				content: "../../../views/basicInformation/post/listform.html",
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
							"id" :  n.find('input[name="post_id"]').val(),
							"fNumber" :  n.find('select[name="fNumber"]').val(),
							"fName" :  n.find('input[name="fName"]').val(),
							"fLevel" :  n.find('input[name="fLevel"]').val()
						};
					$.ajax({
		               	url: "http://127.0.0.1:8081/post",
		               	type: "POST",
		               	data: JSON.stringify(jsonData),
		               	dataType: 'json',
		               	contentType: "application/json;charset=UTF-8",
		               	success: function(data){
		                   if(data.code=="0"){
		                   		t.update({
									id :  n.find('input[name="post_id"]').val(),
									fNumber :  n.find('input[name="fNumber"]').val(),
									fName :  n.find('input[name="fName"]').val(),
									fLevel :  n.find('input[name="fLevel"]').val()
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
					n.find('input[name="post_id"]').val(i.id);
					n.find('input[name="fNumber"]').val(i.fNumber);
					n.find('input[name="fName"]').val(i.fName);
					n.find('input[name="fLevel"]').val(i.fLevel);
				}
			})
		}
	}), e("post", {})
});