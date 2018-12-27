package com.rhl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void  main(String k []) {
		// TODO Auto-generated constructor stub
		
		Map<String, String> crunchifyMap = new HashMap<String, String>();
		List<Map <String,Object>> list = new LinkedList <Map <String,Object>>() ;
		Map <String,Object> map = new HashMap <String,Object>();
		map.put("ID", 1235);
		map.put("TimeIN", "1235");
		map.put("TimeOut", "12356");
		
		list.add(map);
		Gson gson = new Gson();
		
		Map <String,Object> map2 = new HashMap <String,Object>();
		map2.put("ID", 235);
		map2.put("TimeIN", "235");
		map2.put("TimeOut", "2356");
	//	list.add(map2);
		
		log("Raw Map ===> " + crunchifyMap);
		
		GsonBuilder gsonMapBuilder = new GsonBuilder();
		 
		Gson gsonObject = gsonMapBuilder.create();
 
		String JSONObject = gsonObject.toJson(list);
		log("\nMethod-1: Using Google GSON ==> " + JSONObject);
 
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(crunchifyMap);
 
		log("\nPretty JSONObject ==> " + prettyJson);
		
		/*JSONObject crunchifyObject = new JSONObject(map);
		log("\nMethod-2: Using new JSONObject() ==> " + map);
		
		JSONArray array=new JSONArray("[" + crunchifyObject.toString() + "]");
		log("\nMethod-2: Using new JSONObject() ==> " + array);
		
		JSONObject listObject = new JSONObject(list);
		log("\nMethod-2: Using new JSONObject() ==> " + listObject.toString());
		
		JSONArray listarray=new JSONArray("[" + listObject.toString() + "]");
		log("\nMethod-2: Using new JSONObject() ==> " + listarray);*/
		
 
		try {
			// Default constructor, which will construct the default JsonFactory as necessary, use SerializerProvider as its 
			// SerializerProvider, and BeanSerializerFactory as its SerializerFactory.
			String objectMapper = new ObjectMapper().writeValueAsString(list);
			log("\nMethod-3: Using ObjectMapper().writeValueAsString() ==> " + objectMapper);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static void log(Object print) {
		System.out.println(print);
 
	}
}

	



