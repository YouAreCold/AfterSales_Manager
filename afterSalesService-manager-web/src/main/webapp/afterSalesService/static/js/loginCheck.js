/* 登陆验证  */
 		function loginCheck(){
 			// 加载中
			var index = layer.load(2, {
			  shade: [0.1,'#fff'] //0.1透明度的白色背景
			});
 			var token = getParam('token');
 				//1.创建ajax对象
        if(window.XMLHttpRequest)//如果有XMLHttpRequest，那就是非IE6浏览器。()里面加window的原因下面会有描述。
        {
            var oAjax = new XMLHttpRequest();//创建ajax对象
        }
        else//如果没有XMLHttpRequest，那就是IE6浏览器
        {
            var oAjax = new ActiveXObject("Microsoft.XMLHTTP");//IE6浏览器创建ajax对象
        }
        
        //2.连接服务器
        oAjax.open("GET","http://127.0.0.1:8088/uUser/user/token?token="+token,true);
        
        //3.发送请求
        oAjax.send();
        
        //4.接收返回 客户端和服务器端有交互的时候会调用onreadystatechange
        oAjax.onreadystatechange=function()
        {
            if(oAjax.readyState==4)//oAjax.readyState  //浏览器和服务器，进行到哪一步了。
            {
                if(oAjax.status==200)//判断是否成功,如果是200，就代表成功
                {
                		var jsonData = JSON.parse(oAjax.responseText);
                    if(jsonData.code=="400"){
					        		document.getElementById('login-user-info').innerHTML='<a href="javascript:;">                            '+
								 			'																<img src="http://t.cn/RCzsdCq" class="layui-nav-img">                    '+
								 			'																<cite>请登陆</cite>                                                         '+
								 			'                               <span class="layui-nav-more"></span>																			'+
								 			'															</a>                                                                       '+
								 			'															<dl class="layui-nav-child">                                               '+
								 			'																<dd layadmin-event="logout" style="text-align:center;"><a>退出</a></dd>    '+
								 			'															</dl>';
								 			/*layer.msg('登录已过期，无权限进入后台(2秒后自动跳转)',{time:2*1000},{icon: 4},function(){
                    		location.href = 'http://127.0.0.1:8088/afterSalesService/views/user/login.html';// 强制跳转登录
                    	});*/
                    	layer.msg('登录已过期，无权限进入后台(2秒后自动跳转)', {time:2*1000},function(){
                    		location.href = 'http://127.0.0.1:8088/afterSalesService/views/user/login.html';// 强制跳转登录
                    	});
					        	}else{
					        		var userinfo = "views/template/personalpage.html?id="+jsonData.data.id;	//个人中心
						        	var upassword = "views/set/user/password.html?id="+jsonData.data.id;		// 修改密码
						        	var info = "views/set/user/info.html?id="+jsonData.data.id;							// 基本资料
								      document.getElementById('login-user-info').innerHTML='<a href="javascript:;">                            '+
								 			'																 ♪ 和美 欢迎您                             																											'+//<img src="http://t.cn/RCzsdCq" class="layui-nav-img">
								 			'																<cite>['+jsonData.data.nickname+']</cite>                                  '+
								 			//'                               <span class="layui-nav-more"></span>																			'+
								 			'															</a>                                                                       '+
								 			'															<dl class="layui-nav-child">                                               '+
								 			'																<dd><a lay-href="'+userinfo+'">个人中心</a></dd>       										 '+
								 			'																<dd><a lay-href="'+info+'">基本资料</a></dd>                									'+
								 			'																<dd><a lay-href="'+upassword+'">修改密码</a></dd>            								'+
								 			'																<hr>                                                                      '+
								 			'																<dd layadmin-event="logout" style="text-align:center;"><a>退出</a></dd>    '+
								 			'															</dl>';
								 			addMenuParentNode();
					        		layer.close(index);// 赋值完成，关闭Loading层
					        		
					        	}
                }
                else
                {
                    layer.msg('获取token失败，请重新登录(2秒后自动跳转)',{time:2*1000},function(){
                    	location.href = 'http://127.0.0.1:8088/afterSalesService/views/user/login.html';//获取token失败 重新登陆
                    });
                }
            }
        };
 		}
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