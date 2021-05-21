package com.pranav.interview.WebServicesTest;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/breeds")
public class Controller {
 
	@GetMapping(value="/list/all", produces="application/json")
	public JSONObject getAll() {
		JSONParser parser = new JSONParser();
		try {
			//InputStream is = new ClassPathResource("input.json").getInputStream();
			File file = new File(getClass().getResource("input.json").getFile());
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			return Collections.sort(jsonObject);
 			//JSONArray companyList = (JSONArray) jsonObject.get("Company List");


		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
