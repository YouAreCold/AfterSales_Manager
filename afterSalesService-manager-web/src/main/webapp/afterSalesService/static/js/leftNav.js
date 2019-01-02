/*左导航栏*/
function addMenuParentNode() { /*父节点*/
	// 菜单拼接HTML
	var htmlTest = "";
	// 菜单入参
	var jsonParent = {
		"parent_id": "1***0***2",
		"orderby" : ["sortId",true]
	};
	//1.创建ajax对象
	if(window.XMLHttpRequest) //如果有XMLHttpRequest，那就是非IE6浏览器。()里面加window的原因下面会有描述。
	{
		var oAjax = new XMLHttpRequest(); //创建ajax对象
	} else //如果没有XMLHttpRequest，那就是IE6浏览器
	{
		var oAjax = new ActiveXObject("Microsoft.XMLHTTP"); //IE6浏览器创建ajax对象
	}
	//2.连接服务器并且设置请求头
	oAjax.open("POST", "http://127.0.0.1:8081/sysMenu/read/listPage", true);
	oAjax.setRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
	oAjax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	
	//3.发送请求
	oAjax.send(JSON.stringify(jsonParent));

	//4.接收返回 客户端和服务器端有交互的时候会调用onreadystatechange
	oAjax.onreadystatechange = function() {
		if(oAjax.readyState == 4) //oAjax.readyState  //浏览器和服务器，进行到哪一步了。
		{
			if(oAjax.status == 200) //判断是否成功,如果是200，就代表成功
			{
				var jsonData = JSON.parse(oAjax.responseText);

				var menuData = jsonData.data;
				for(var p in menuData) { //遍历json对象的每个key/value对,p为key
					htmlTest += '<li data-name="' + menuData[p].menuId + '" class="layui-nav-item">' +
						' <a href="javascript:void();" lay-tips="' + menuData[p].menuName + '" lay-direction="2">' +
						' <i class="layui-icon '+menuData[p].iconCode+'"></i>' +
						' <cite>' + menuData[p].menuName + '</cite>' +
						'</a>' +
						'<dl class="layui-nav-child" id="f_' + menuData[p].id + '">' +
						'</dl>' +
						'</li>';
					addChildNode(menuData[p].id); // 追加子节点
				}

				document.getElementById("LAY-system-side-menu").innerHTML = htmlTest;
				//console.log(htmlTest);

			}
		}
	};
}
/*二级子节点*/
function addChildNode(id) { /*子节点*/
	// 菜单拼接HTML
	var htmlTest = '';
	// 菜单入参
	var jsonData = {
		"parent_id": "1***" + id + "***2"
	};
	//1.创建ajax对象
	if(window.XMLHttpRequest) //如果有XMLHttpRequest，那就是非IE6浏览器。()里面加window的原因下面会有描述。
	{
		var oAjax = new XMLHttpRequest(); //创建ajax对象
	} else //如果没有XMLHttpRequest，那就是IE6浏览器
	{
		var oAjax = new ActiveXObject("Microsoft.XMLHTTP"); //IE6浏览器创建ajax对象
	}

	//2.连接服务器并且设置请求头
	oAjax.open("POST", "http://127.0.0.1:8081/sysMenu/read/listPage", true);
	oAjax.setRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
	oAjax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	//3.发送请求
	oAjax.send(JSON.stringify(jsonData));

	//4.接收返回 客户端和服务器端有交互的时候会调用onreadystatechange
	oAjax.onreadystatechange = function() {
		if(oAjax.readyState == 4) //oAjax.readyState  //浏览器和服务器，进行到哪一步了。
		{
			if(oAjax.status == 200) //判断是否成功,如果是200，就代表成功
			{
				var jsonDatas = JSON.parse(oAjax.responseText);
				var pId = '';
				var menuData = jsonDatas.data;
				for(var p in menuData) { //遍历json对象的每个key/value对,p为key
					addChildNodeT(menuData[p].id);
					if(menuData[p].menuUrl == "javascript:void();") {
						htmlTest += '<dd data-name="' + menuData[p].menuId + '" id="f_node_' + menuData[p].id + '">' +
							'<a href="' + menuData[p].menuUrl + '">' + menuData[p].menuName + '</a>' +
							'</dd>';
					} else {
						htmlTest += '<dd data-name="' + menuData[p].menuId + '" id="f_node_' + menuData[p].id + '">' +
							'<a lay-href="' + menuData[p].menuUrl + '">' + menuData[p].menuName + '</a>' +
							'</dd>';
					}
					pId = menuData[p].parentId;
				}
				document.getElementById("f_" + pId).innerHTML = htmlTest;
				var element = layui.element;
				element.render('nav');// 重新渲染左侧导航栏
			}
		}
	};
}

/*三级子节点*/
function addChildNodeT(id) { /*子节点*/
	
	/* 展示物料分类菜单 id=1003（物料管理）  start*/
	if(id==1003)
	{
		materialsTypeView();
		return;
	}
	/* 展示物料分类菜单 id=1003（物料管理）  end*/
	
	// 菜单拼接HTML
	var htmlTest = '';
	// 菜单入参
	var jsonData = {
		"parent_id": "1***" + id + "***2"
	};
	
	//1.创建ajax对象
	var oAjax;
	if(window.XMLHttpRequest) //如果有XMLHttpRequest，那就是非IE6浏览器。()里面加window的原因下面会有描述。
	{
	 	oAjax = new XMLHttpRequest(); //创建ajax对象
	} 
	else //如果没有XMLHttpRequest，那就是IE6浏览器
	{
	 	oAjax = new ActiveXObject("Microsoft.XMLHTTP"); //IE6浏览器创建ajax对象
	}

	//2.连接服务器并且设置请求头
	oAjax.open("POST", "http://127.0.0.1:8081/sysMenu/read/listPage", true);
	oAjax.setRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
	oAjax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	//3.发送请求
	oAjax.send(JSON.stringify(jsonData));

	//4.接收返回 客户端和服务器端有交互的时候会调用onreadystatechange
	oAjax.onreadystatechange = function() {
		if(oAjax.readyState == 4) //oAjax.readyState  //浏览器和服务器，进行到哪一步了。
		{
			if(oAjax.status == 200) //判断是否成功,如果是200，就代表成功
			{
				var jsonDatas = JSON.parse(oAjax.responseText);
				var pId = '';
				var menuData = jsonDatas.data;
				if(menuData.length != 0) {
					htmlTest += '<dl class="layui-nav-child" >';
					for(var p in menuData) { //遍历json对象的每个key/value对,p为key
						//console.log("三级节点==>" + menuData[p].menuName);
						htmlTest += '<dd data-name="' + menuData[p].menuId + '">' +
							'<a lay-href="' + menuData[p].menuUrl + '">' + menuData[p].menuName + '</a>' +
							'</dd>';
						pId = menuData[p].parentId;
					}
					htmlTest += '</dl>';
					var f_node_dl = document.getElementById("f_node_" + pId);
					f_node_dl.innerHTML = f_node_dl.innerHTML + htmlTest;
				}
				var element = layui.element;
				element.render('nav');// 重新渲染左侧导航栏
			}
		}
	};
}

/*展示物料分类表*/
function materialsTypeView()
{
	var htmlTest = '';
	//1.创建ajax对象
	var oAjax;
	if(window.XMLHttpRequest) //如果有XMLHttpRequest，那就是非IE6浏览器。()里面加window的原因下面会有描述。
	{
	 	oAjax = new XMLHttpRequest(); //创建ajax对象
	} 
	else //如果没有XMLHttpRequest，那就是IE6浏览器
	{
	 	oAjax = new ActiveXObject("Microsoft.XMLHTTP"); //IE6浏览器创建ajax对象
	}

	//2.连接服务器并且设置请求头
	oAjax.open("POST", "http://127.0.0.1:8081/materialsType/read/listPage", true);
	oAjax.setRequestHeader("Accept", "application/json, text/javascript, */*; q=0.01");
	oAjax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	//3.发送请求
	oAjax.send(null);

	//4.接收返回 客户端和服务器端有交互的时候会调用onreadystatechange
	oAjax.onreadystatechange = function() {
		if(oAjax.readyState == 4) //oAjax.readyState  //浏览器和服务器，进行到哪一步了。
		{
			if(oAjax.status == 200) //判断是否成功,如果是200，就代表成功
			{
				var jsonDatas = JSON.parse(oAjax.responseText);
				var pId = '';
				var materialsTypeData = jsonDatas.data;
				if(materialsTypeData.length != 0) {
					htmlTest += '<dl class="layui-nav-child" >';
					for(var p in materialsTypeData) { //遍历json对象的每个key/value对,p为key
						//console.log("三级节点==>" + menuData[p].menuName);
						htmlTest += '<dd data-name="' + materialsTypeData[p].id + '">' +
										'<a lay-href="' + "views/basicInformation/materials/list.html?materialsType="+materialsTypeData[p].id + '">' + "♬→"+materialsTypeData[p].materialsTypeName + '</a>' +
									'</dd>';
						pId = 1003;// 物料管理为父节点
					}
					htmlTest += '</dl>';
					var f_node_dl = document.getElementById("f_node_" + pId);
					f_node_dl.innerHTML = f_node_dl.innerHTML + htmlTest;
				}
				var element = layui.element;
				element.render('nav');// 重新渲染左侧导航栏
			}
		}
	};
}
