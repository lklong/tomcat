/**
 * 
 */
package com.lkl.muyi.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.Test;

/**
 * @author lkl
 *
 */
public class LKLHttp {

	private static final String GET_URL = "http://localhost:8080/webdemo/hello/welcome/login.html";
	public void getOfHttp(String geturl) throws IOException{
		geturl += "?username="+URLEncoder.encode("一个肥胖 的男人", "utf-8")+"&password="+URLEncoder.encode("123456","utf-8");
		URL url = new URL(geturl);
		HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
		httpURLConnection.connect();
		 BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		 String lines;
		 while ((lines=reader.readLine())!=null) {
			System.out.println(lines);
		}
		 reader.close();
		 httpURLConnection.disconnect();
	}
	
    public static void readContentFromPost() throws IOException {

        // Post请求的url，与get不同的是不需要带参数

        URL postUrl = new URL("POST_URL");

        // 打开连接

        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();

        //打开读写属性，默认均为false

        connection.setDoOutput(true);                 

 connection.setDoInput(true);

        // 设置请求方式，默认为GET

        connection.setRequestMethod(" POST ");

        // Post 请求不能使用缓存

        connection.setUseCaches(false);

        // URLConnection.setFollowRedirects是static 函数，作用于所有的URLConnection对象。

        // connection.setFollowRedirects(true);

        //URLConnection.setInstanceFollowRedirects 是成员函数，仅作用于当前函数

        connection.setInstanceFollowRedirects(true);

        // 配置连接的Content-type，配置为application/x- www-form-urlencoded的意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode进行编码

        connection.setRequestProperty(" Content-Type ",

                        " application/x-www-form-urlencoded ");

        // 连接，从postUrl.openConnection()至此的配置必须要在 connect之前完成，

        // 要注意的是connection.getOutputStream()会隐含的进行调用 connect()，所以这里可以省略

        //connection.connect();

        DataOutputStream out = new DataOutputStream(connection

                        .getOutputStream());

        //正文内容其实跟get的URL中'?'后的参数字符串一致

        String content = " firstname= "+URLEncoder.encode(" 一个大肥人 ", " utf-8 ");

        // DataOutputStream.writeBytes将字符串中的16位的 unicode字符以8位的字符形式写道流里面

        out.writeBytes(content);

        out.flush();

        out.close(); // flush and close

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;

        System.out.println(" ============================= ");

        System.out.println(" Contents of post request ");

        System.out.println(" ============================= ");

        while ((line = reader.readLine()) != null) {

                System.out.println(line);

        }

        System.out.println(" ============================= ");

        System.out.println(" Contents of post request ends ");

        System.out.println(" ============================= ");

        reader.close();

        //connection.disconnect();

 }


	@Test
	public void testGet(){
		try {
			getOfHttp(GET_URL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
