package com.rhl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhl.domain.Report;

public class HttpHelper {
	

	public static void addNewReport(String reportName,List <String> header)  {
		HttpClient client =  HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://localhost:8080/service/addNewReport");
		post.setHeader("Accept", "application/json");
		post.setHeader("Content-type", "application/json");
		List<BasicNameValuePair> nameValuePairs = new ArrayList <BasicNameValuePair> (2);
		String jsonheader = "";
		nameValuePairs.add(new BasicNameValuePair("reportName", reportName)); 
		 ObjectMapper mapper = new ObjectMapper();
		 mapper.setSerializationInclusion(Include.NON_NULL);
		    try {
		    	jsonheader = mapper.writeValueAsString(header);
		        System.out.println(jsonheader);
		    } catch (JsonProcessingException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		nameValuePairs.add(new BasicNameValuePair("headers", jsonheader));
		try {
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response;
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void addNewReport(Report report) {
		HttpClient client = HttpClientBuilder.create().build();

		HttpPost post = new HttpPost("http://localhost:8080/service/addReport");
		post.setHeader("Accept", "application/json");
		post.setHeader("Content-type", "application/json");
		String reportJson = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		try {
			reportJson = mapper.writeValueAsString(report);
			System.out.println(reportJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			StringEntity params = new StringEntity(reportJson);
			post.setEntity(params);
			HttpResponse response;
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public static void publishReport(Report report,Map<String,Object> values) {
		HttpClient client =  HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://localhost:8080/service/addRow");
		post.setHeader("Accept", "application/json");
		post.setHeader("Content-type", "application/json");
		String reportJson = "";
		final Map <String,Object> row = new HashMap<String,Object>();
		row.put("reportName",report.getName());
	
		values.forEach((k,v)-> row.put(k,v)) ;
		ObjectMapper mapper = new ObjectMapper();
	//	mapper.setSerializationInclusion(Include.NON_NULL);
		try {
			reportJson = mapper.writeValueAsString(row);
			System.out.println(reportJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		//	post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
			StringEntity params = new StringEntity(reportJson);
			post.setEntity(params);
			HttpResponse response;
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	public static void publishReport(String reportName,Map<String,String> values) {
			HttpClient client =  HttpClientBuilder.create().build();
			HttpPost post = new HttpPost("http://restUrl");
			List <BasicNameValuePair> nameValuePairs = new ArrayList <BasicNameValuePair> (values.size()+1);
			nameValuePairs.add(new BasicNameValuePair("reportName", reportName)); // you can as many name value pair as you want in the list
			values.forEach((k,v)->  nameValuePairs.add(new BasicNameValuePair(k, v)));
			try {
				post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				HttpResponse response;
				response = client.execute(post);
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String line = "";
				while ((line = rd.readLine()) != null) {
					System.out.println(line);
				}
			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	


	

}
