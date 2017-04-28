package com.api.client.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class log
{

	public static void out_to_file(String File_Path, StringBuffer buffer) {
			try {  
	            File newFile = new File(File_Path);  
	            if (newFile.exists())// ���ڣ���ɾ��  
	                if (!newFile.delete())// ɾ���ɹ��򴴽�  
	                {  
	                    System.out.print("ɾ���ļ�" + newFile + "ʧ��");  
	                }  
	            if (newFile.createNewFile()) {// �����ɹ�����д���ļ�����  
	                PrintWriter p = new PrintWriter(new FileOutputStream(newFile  
	                        .getAbsolutePath()));  
	                p.write(buffer.toString());  
	                p.close();  
	            } else {  
	                System.out.print("�����ļ���" + newFile + "ʧ��");  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
    }  
	
	public static StringBuffer log_format_parameter(List<Map> list)
	{
		StringBuffer buf = new StringBuffer("");
		for(Map m : list)
		{
			String name = m.get("name").toString();
			String value = m.get("value").toString();
			String template = "                                        ";
			char[] name_array = name.toCharArray();
			char[] template_array = template.toCharArray();
			for(int i = 0; i<name_array.length; i ++)
			{
				template_array[template_array.length -2 - i] = name_array[name_array.length-1 - i]; 
			}
			buf.append(String.valueOf(template_array));
			buf.append(": ");
			buf.append(value+"\r\n");
		}
		
		return buf;
	}
}
