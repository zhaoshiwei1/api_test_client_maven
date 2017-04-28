package com.api.client.http;

import java.util.List;
import java.util.Map;

import org.json.JSONException;

import com.api.client.globaldefine.GlobalDefine;

public class HttpRun 
{
	public HttpRun()
	{
		
	}
	
	public StringBuffer run(List<Map> lis)
	{
		ParameterUtility pu = new ParameterUtility();
		HttpUtility hu = new HttpUtility();
		
		String id = null;
		String case_name = null; 
		String url = null;
		String http_method = null;
		for(Map p : lis)
		{
			switch (p.get("name").toString())
			{
				case GlobalDefine.TC_ID:
					id = p.get("value").toString();
					break;
				case GlobalDefine.TC_NAME:
					case_name = p.get("value").toString();
					break;
				case GlobalDefine.TC_URL:
					url = p.get("value").toString();
					break;
				case GlobalDefine.TC_METHOD:
					http_method = p.get("value").toString();
					break;
				default:
					break;
			}
		}
		
		String URL = GlobalDefine.BASE_URIL + url;
		//System.out.print("Final URL" + URL + "\n");
		switch (http_method)
		{
			case GlobalDefine.GET:
				//System.out.print("GET\n");
				return hu.Get_Util(pu.BuildGetUrl(lis, URL));
			case GlobalDefine.POST:
				//System.out.print("POST\n");
				try {
					return hu.Post_Util(pu.BuildJson(lis), URL);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			default:
				return new StringBuffer("Err MSG: /n/t"+case_name+"/n/t"+url+"/n/t"+http_method+"/n");
		}
		
	}

	private StringBuffer format(List<Map> lis)
	{
		StringBuffer buf = new StringBuffer("");
		return null;
	}

}
