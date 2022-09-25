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
				
		
	
		
	
	
	
	
	
	
	
	
	
	/*//@Test
	public void getApiTest1() throws ClientProtocolException, IOException {
		
	
		InvestecApi = new InvestecApi();
		
		closebaleHttpResponse = InvestecApi.get(url);
		
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
						
				//Assert.assertEquals(skin_color , "white, blue"); */
				
	
		
	
	

	


