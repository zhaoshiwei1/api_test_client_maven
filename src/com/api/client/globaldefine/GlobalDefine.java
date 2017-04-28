package com.api.client.globaldefine;

public class GlobalDefine 
{
	/*
	 * 定义了数据库测试用例表中每条测试的固定定义字段名
	 */
	public static final String TC_ID = "TESTCASEID";
	public static final String TC_NAME = "NAME";
	public static final String TC_URL = "URL";
	public static final String TC_METHOD = "HTTP_METHOD";
	
	/*
	 * 数据库中NULL代表该测试用例无此字段，“EMPTY”代表有此字段但是值为空
	 */  
	public static final String TC_EMPTY = "EMPTY";
	
	/*
	 * 定义sqlite3 数据库文件地址和表名称
	 */
	public static final String DB_PATH = "database/testCase.db3";
	public static final String TC_TABLE = "SETTLEMENT_TESTCASE";
	
	/*
	 * 定义BaseUrl
	 */
	public static final String BASE_URIL = "http://sandbox.settlement.yongche.org";
	
	/*
	 * 定义HTTP方法
	 */
	public static final String GET = "GET";
	public static final String POST = "POST";
	/*
	 * 定义临时日志输出地址
	 */
	public static final String LOG_PATH = "SETTLEMENT_API_TEST_SUITE.txt";
}
