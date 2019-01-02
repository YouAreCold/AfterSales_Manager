package com.afterSalesService.common.utils;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;


public class FastDFSTest {
	/**
	 * 测试上传
	 * @throws Exception
	 */
	@org.junit.Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient client = new FastDFSClient("F:/开发/afterSalesService/afterSalesService-manager-web/src/main/resources/resource/client.conf");
		String uploadFile = client.uploadFile("F:/test.jpg", "jpg");
		System.out.println(uploadFile);
	}
	/**
	 * 测试删除
	 * @throws Exception
	 */
	@org.junit.Test
	public void testFastDfsClientDelete() throws Exception {
		FastDFSClient client = new FastDFSClient("F:/开发/afterSalesService/afterSalesService-manager-web/src/main/resources/resource/client.conf");
		Integer delete_file = client.delete_file("group1/M00/00/00/wKglo1tIgKOACkIzAABdrZgsqUU777.jpg");
		System.out.println(delete_file);
	}
	
	/**
	 * 测试下载
	 * @throws Exception 
	 */
	public void testDownLoad() throws Exception{
		FastDFSClient client = new FastDFSClient("F:/开发/afterSalesService/afterSalesService-manager-web/src/main/resources/resource/client.conf");
		FileOutputStream fos = new FileOutputStream("F:/");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int downID = client.download_file("group1/M00/00/00/wKglo1tIgKOACkIzAABdrZgsqUU777.jpg",bos);
	}

}
