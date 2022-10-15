package com.RESTAssured.RESTAssured;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC_03Post {
	
	@Test
	public void Test_1Post() {
		/*Map<String,Object>map=new HashMap<String,Object>();
		map.put("Name", "Arjun");
		map.put("job", "Teacher");
		System.out.println(map)
		JSONObject request=new JSONObject(map);*/
		JSONObject request=new JSONObject();
		request.put("Name", "Arjun");
		request.put("job", "Teacher");
		System.out.println(request);
		System.out.println(request.toJSONString());
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  body(request.toJSONString()).
		  when().
		  post("https://reqres.in/api/users").
		  then().
		  statusCode(201).
		  log().all();
	}

}
