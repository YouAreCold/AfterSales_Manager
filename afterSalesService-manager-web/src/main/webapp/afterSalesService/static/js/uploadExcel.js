/* 导入Excel通用 */
layui.use('upload', function() {
	var upload = layui.upload;

	//执行上传
	var uploadInst = upload.render({
		elem: '#import' //绑定元素
			,
		url: 'http://127.0.0.1:8081/comm/importexcel' //上传接口
			,
		method: 'POST',
		accept: 'file',
		size: 50,
		before: function(obj) {
			layer.load();
		},
		done: function(res) { //上传完毕回调
			layui.table.reload('LAY-app-system-order'); // 更新数据
			layer.closeAll('loading');
			layer.msg("导入完成", {
				icon: 6
			});
		},
		error: function() { //请求异常回调
			layer.closeAll('loading');
			layer.msg('导入出现异常，请稍后重试！');
		}
	});
});