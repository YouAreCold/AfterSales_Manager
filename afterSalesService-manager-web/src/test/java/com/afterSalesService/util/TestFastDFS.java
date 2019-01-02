package com.afterSalesService.util;

import org.junit.Test;

import com.afterSalesService.utils.FastDFSClient;

public class TestFastDFS {

	@Test
	public void uploadFile() throws Exception {
		/*//1、向工程中添加jar包
		//2、创建一个配置文件。配置tracker服务器地址
		//3、加载配置文件
		ClientGlobal.init("F:/开发/深圳健康/eclipseWork/afterSalesService-manager-web/src/main/resources/resource/client.conf");
		//4、创建一个TrackerClient对象。
		TrackerClient trackerClient = new TrackerClient();
		//5、使用TrackerClient对象获得trackerserver对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		//6、创建一个StorageServer的引用null就可以。
		StorageServer storageServer = null;
		//7、创建一个StorageClient对象。trackerserver、StorageServer两个参数。
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//8、使用StorageClient对象上传文件。
		String[] strings = storageClient.upload_file("F:/123.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}*/
	}
	
	@Test
	public void testFastDfsClient()  {
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("F:/开发/afterSalesService/afterSalesService-manager-web/src/main/resources/resource/client.conf");
			String string = fastDFSClient.uploadFile("F:/test.jpg");
			System.out.println("http://192.168.0.163:8088/"+string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
