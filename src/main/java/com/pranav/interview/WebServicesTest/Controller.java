package com.pranav.interview.WebServicesTest;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@RestController
@RequestMapping(value="/api/breeds")
public class Controller {
 
	@GetMapping(value="/list/all", produces="application/json")
	public JSONObject getAll() {
		JSONParser parser = new JSONParser();
		String result = "";
		Gson resultJSON = new Gson();
		try {
			//InputStream is = new ClassPathResource("input.json").getInputStream();
			//File file = new File(getClass().getResource("input.json").getFile());
			//Object obj = parser.parse(new FileReader("input.json"));
			//JSONObject jsonObject = (JSONObject) obj;
			RestTemplate rest = new RestTemplate();
			result = rest.getForObject("https://raw.githubusercontent.com/mlenze/CodingExcercise-Java/main/apidata.json", String.class);
			//return Collections.sort(jsonObject);
 			//JSONArray companyList = (JSONArray) jsonObject.get("Company List");
			
			return (JSONObject) parser.parse("{\"message\":"+result+",\"status\":\"success\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//@Override
	public int compare(JSONObject o1, JSONObject o2) {
	    String v1 = (String) ((JSONObject) o1.get("attributes")).get("COMMERCIALNAME_E");
	    String v3 = (String) ((JSONObject) o2.get("attributes")).get("COMMERCIALNAME_E");
	    return v1.compareTo(v3);
	}
	
	
}
