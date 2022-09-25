package com.qa.InvestecApi;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.qa.base.TestBase;

public class InvestecApi extends TestBase{
	
	
	
	public CloseableHttpResponse get(String url) throws IOException,ClientProtocolException{
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpGet httpget = new HttpGet(url);
		
		CloseableHttpResponse CloseableHttpRespone = httpclient.execute(httpget);
		
		return CloseableHttpRespone ;
		
	
		
		
	}

	

}
