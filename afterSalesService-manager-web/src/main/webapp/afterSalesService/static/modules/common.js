/** afterSalesService.std-v1.0.0-beta9 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(function(e) {
	var i = (layui.$, layui.layer, layui.laytpl, layui.setter, layui.view, layui.admin);
	i.events.logout = function() {
		i.req({
			url: 'http://127.0.0.1:8088/uUser/user/outLogin?token='+getParam('token'),// 调用退出登录接口
			type: "GET",
			done: function(e) {
				i.exit(function() {
					layer.msg('退出登录成功(2秒后自动跳转)',{time:2*1000},function(){
                    		location.href = "http://127.0.0.1:8088/afterSalesService/views/user/login.html"
                   	});
				})
			}
		})
	}, e("common", {})
});

/** 
 * 获取指定的URL参数值 
 * URL:http://www.quwan.com/index?name=tyler 
 * 参数：paramName URL参数 
 * 调用方法:getParam("name") 
 * 返回值:tyler 
 */ 
function getParam(paramName) { 
    paramValue = "", isFound = !1; 
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) { 
        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0; 
        while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++ 
    } 
    return paramValue == "" && (paramValue = null), paramValue 
} 