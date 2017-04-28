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
				// ���ñ��Ĳ���
				hutc.setRequestMethod("POST");
				// �����Ƿ���httpUrlConnection�������Ϊ�����post���󣬲���Ҫ���� http�����ڣ������Ҫ��Ϊtrue, Ĭ���������false; 
				hutc.setDoOutput(true);
				// �����Ƿ��httpUrlConnection���룬Ĭ���������true
				hutc.setDoInput(true);
				hutc.setUseCaches(false);
		        hutc.setInstanceFollowRedirects(true);
		        hutc.setRequestProperty("Content-Type","application/json");
				//hutc.setAllowUserInteraction(true);
			
				// ��������д������data
				OutputStream out=hutc.getOutputStream();
				
				out.write(js.getBytes("UTF-8"));
				out.flush();
				out.close();
				
				//���´���Ϊ��ȡ�������ݣ� ��ʱע��
				// ��ȡ���ص�����	

				BufferedReader reader = null;
				InputStream ins=hutc.getInputStream();
				reader = new BufferedReader(new InputStreamReader(ins,"UTF-8"));
				String sg=reader.readLine();
				if (sg!= null)
				{
			           buffer.append(sg);
			    }
				//System.out.println("���շ���ֵ:" + buffer+ "\n");

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
	            //Get������ҪDoOutPut
	            conn.setDoOutput(false);
	            conn.setDoInput(true);
	            //�������ӳ�ʱʱ��Ͷ�ȡ��ʱʱ��
	            conn.setConnectTimeout(10000);
	            conn.setReadTimeout(10000);
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            //���ӷ�����  
	            conn.connect();  
	            // ȡ������������ʹ��Reader��ȡ  
	            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	            String line;
	            while ((line = in.readLine()) != null) {
	                buffer.append(line);
	            }
        	} catch (Exception e) 
        	{
        		e.printStackTrace();
        	}
        //�ر�������
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
