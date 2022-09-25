package com.qa.test;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.InvestecApi.InvestecApi;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class InvestecApiTest extends TestBase{
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	InvestecApi InvestecApi;
	CloseableHttpResponse closebaleHttpResponse;
	
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		
	    url = serviceUrl + apiUrl;
		
	}
	
	@Test
	public void getApiTest() throws ClientProtocolException, IOException{
    
		InvestecApi = new InvestecApi();
		
		closebaleHttpResponse = InvestecApi.get(url);
		
		//Json String:
				String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
				
				JSONObject responseJson = new JSONObject(responseString);
				System.out.println("Response JSON from API---> "+ responseJson);
				
		//get the value from JSON ARRAY:
				String skincolor  = TestUtil.getValueByJPath(responseJson, "/results[2]/skin_color");
				System.out.println("skin_color of R2-D2 :"+skincolor);
				
				Assert.assertEquals(skincolor , "white, blue"); 
				
	}
	
}
				
		
	
		