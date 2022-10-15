package com.RESTAssured.RESTAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC_04Put {
	
	@Test
	public void Test_1() {
		JSONObject js=new JSONObject();
		js.put("Nama","Anubhav");
		js.put("Job", "Actor");
		System.out.println(js.toJSONString());
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(js.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
	}

}
