package com.api.client.globaldefine;

public class GlobalDefine 
{
	/*
	 * ���������ݿ������������ÿ�����ԵĹ̶������ֶ���
	 */
	public static final String TC_ID = "TESTCASEID";
	public static final String TC_NAME = "NAME";
	public static final String TC_URL = "URL";
	public static final String TC_METHOD = "HTTP_METHOD";
	
	/*
	 * ���ݿ���NULL����ò��������޴��ֶΣ���EMPTY�������д��ֶε���ֵΪ��
	 */  
	public static final String TC_EMPTY = "EMPTY";
	
	/*
	 * ����sqlite3 ���ݿ��ļ���ַ�ͱ�����
	 */
	public static final String DB_PATH = "database/testCase.db3";
	public static final String TC_TABLE = "SETTLEMENT_TESTCASE";
	
	/*
	 * ����BaseUrl
	 */
	public static final String BASE_URIL = "http://sandbox.settlement.yongche.org";
	
	/*
	 * ����HTTP����
	 */
	public static final String GET = "GET";
	public static final String POST = "POST";
	/*
	 * ������ʱ��־�����ַ
	 */
	public static final String LOG_PATH = "SETTLEMENT_API_TEST_SUITE.txt";
}
