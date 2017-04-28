package com.api.client.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class HttpUtility 
{
	public HttpUtility()
	{
		
	}
	
	public StringBuffer Post_Util(String js,String url)
	{
//		System.out.print(js+"\n");
//		System.out.print(url+"\n");
		StringBuffer buffer=new StringBuffer();
		try{
				URL serverUrl= new URL(url);
				URLConnection uct= serverUrl.openConnection();
				HttpURLConnection hutc=(HttpURLConnection)uct;	
				// 设置报文参数
				hutc.setRequestMethod("POST");
				// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在 http正文内，因此需要设为true, 默认情况下是false; 
				hutc.setDoOutput(true);
				// 设置是否从httpUrlConnection读入，默认情况下是true
				hutc.setDoInput(true);
				hutc.setUseCaches(false);
		        hutc.setInstanceFollowRedirects(true);
		        hutc.setRequestProperty("Content-Type","application/json");
				//hutc.setAllowUserInteraction(true);
			
				// 开启流，写入数据data
				OutputStream out=hutc.getOutputStream();
				
				out.write(js.getBytes("UTF-8"));
				out.flush();
				out.close();
				
				//以下代码为获取返回数据， 临时注释
				// 获取返回的数据	

				BufferedReader reader = null;
				InputStream ins=hutc.getInputStream();
				reader = new BufferedReader(new InputStreamReader(ins,"UTF-8"));
				String sg=reader.readLine();
				if (sg!= null)
				{
			           buffer.append(sg);
			    }
				//System.out.println("接收返回值:" + buffer+ "\n");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return buffer;
	}
	
	public StringBuffer Get_Util(String url)
	{
		StringBuffer buffer=new StringBuffer();
		BufferedReader in = null;
		try {
	            URL serverurl = new URL(url);
	            HttpURLConnection conn = (HttpURLConnection)serverurl.openConnection();
	            conn.setRequestMethod("GET");
	            //Get请求不需要DoOutPut
	            conn.setDoOutput(false);
	            conn.setDoInput(true);
	            //设置连接超时时间和读取超时时间
	            conn.setConnectTimeout(10000);
	            conn.setReadTimeout(10000);
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            //连接服务器  
	            conn.connect();  
	            // 取得输入流，并使用Reader读取  
	            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	            String line;
	            while ((line = in.readLine()) != null) {
	                buffer.append(line);
	            }
        	} catch (Exception e) 
        	{
        		e.printStackTrace();
        	}
        //关闭输入流
        finally{
	            try{
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
        	}
		return buffer;
	}
}
