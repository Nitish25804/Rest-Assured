package com.RESTAssured.RESTAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_05Patch {
	
	@Test
	public void Test_01() {
		JSONObject js=new JSONObject();
		js.put("Nama","Bhabesh");
		js.put("Job", "Actor");
		System.out.println(js.toJSONString());
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(js.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
	}

}
