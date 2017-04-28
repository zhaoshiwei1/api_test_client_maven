package com.api.client.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtility 
{
	public String db_path = null;
	
	public DataBaseUtility (String db_path)
	{
		this.db_path = db_path;
	}
	
	public List<List<Map>> getData(String table_name)
	{
		String JDBC_String = "jdbc:sqlite:" + this.db_path;
		String Select_SQL = "SELECT * FROM " + table_name +";";
		//String Select_SQL = "SELECT * FROM SETTLEMENT_TESTCASE WHERE NAME = \""+"temp" + "\";";
		Connection c = null;
		Statement s = null;
	    List full_map = new ArrayList();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection(JDBC_String);
		      c.setAutoCommit(false);
		      s = c.createStatement();
		      ResultSet rs = s.executeQuery( Select_SQL );

		      while ( rs.next() ) 
		      {
		    	  List list = new ArrayList();
		    	  ResultSetMetaData metaData = rs.getMetaData();  
		          for (int i = 0; i < metaData.getColumnCount(); i++) 
		          {	  Map info = new HashMap();  
		              // resultSet数据下标从1开始  
		              String columnName = metaData.getColumnName(i + 1); 
		              if(!(rs.getString(columnName)==null))
		              {
			              info.put("name", columnName);
			              info.put("value", rs.getString(columnName));
			              list.add(info);
		              }
	
		          }  
		          full_map.add(list);
		      }
		      rs.close();
		      s.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
		return full_map;
	}
}
