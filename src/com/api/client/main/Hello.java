package com.api.client.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.api.client.db.DataBaseUtility;
import com.api.client.globaldefine.GlobalDefine;
import com.api.client.http.HttpRun;
/*
add some comments to test github
add some comments to test github
 */
public class Hello 
{
	public static void main(String[] args)
	{	
		StringBuffer buf = new StringBuffer("\r\n");
		HttpRun hr = new HttpRun();
		List<List<Map>> l = new ArrayList();
		//System.out.print("Hello world!"+"\n");
		DataBaseUtility dbu = new DataBaseUtility(GlobalDefine.DB_PATH);
		l = dbu.getData(GlobalDefine.TC_TABLE);
		for (List m : l)
		{
			buf.append(log.log_format_parameter(m));
			buf.append("\r\n	RESPONSE: ");
			buf.append(hr.run(m).toString());
			buf.append("\r\n\r\n\r\n");
			buf.append("*****************************************************************************************\r\n\r\n");
		}
		log.out_to_file(GlobalDefine.LOG_PATH, buf);
	}
}
