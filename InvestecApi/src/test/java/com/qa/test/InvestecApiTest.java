package com.qa.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Phaser;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.qa.InvestecApi.InvestecApi;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

import static org.junit.Assert.assertThat;

public class InvestecApiTest extends TestBase{
	
	TestBase TestBase;
	String serviceurl;
	String apiurl;
	String url;
	InvestecApi InvestecApi;
	CloseableHttpResponse CloseableHttpResponse ;
	
	
	
	@BeforeMethod
	
	public void setup() {
		
		TestBase = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiurl = prop.getProperty("serviceURL");
		url = serviceurl + apiurl;
	}
		
	@Test
	public void getApiTest() throws ClientProtocolException, IOException {
		
	
		InvestecApi = new InvestecApi();
		
		CloseableHttpResponse = InvestecApi.get(url);
		
		//to get full string from the page we have to use entityutils class
		
				//String responsestring = EntityUtils.toString(CloseableHttpResponse.getEntity(),"UTF-8");
				var Data = EntityUtils.toString(CloseableHttpResponse.getEntity(),"UTF-8");
				
				
				//to get jsonvalue from String:
				
				
				JSONObject responseJson = new JSONObject(Data);
				
				
				
							
				
			System.out.println("Response JSON from API : "+responseJson);
			
//			List<Map<String, Object>> dataList = JsonPath.parse(responseJson) .read("$[?('https://swapi.dev/api/flims/1/' in @['films'])]"); 
//			String title = (String) dataList.get(0).get("skin_color"); 
//			Assert.assertEquals("fair", title);
			
//			Object dataObject = JsonPath.parse(responseJson).read("$[?(@.height == '172')]");
//			String dataString = dataObject.toString();
//			assertThat(dataString, containsString("fair"));
			
			DocumentContext ctx = JsonPath.parse(responseJson);
			
			JSONArray obj = ctx.read("$.results");
			System.out.println(obj.get(0));
			
				
//				JSONParser jsonParser = new JSONParser();
//				//JSONObject jsonObject = (JSONObject) jsonParser.parse(responseJson)
//						
//						String value = (String) responseJson.get("results")	;	
//						System.out.println(value);
				//get the value from Json array:
				
//			String skincolor = TestUtil.getValueByJpath(responseJson,"$..results[0].skin_color");
//			
//			
//				
//				System.out.println("skin_color of R2-D2 :"+skincolor);
						
				//Assert.assertEquals(skin_color , "white, blue"); 
				
	}
		
	
	
}
	


