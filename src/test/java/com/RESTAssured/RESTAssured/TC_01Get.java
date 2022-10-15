package com.RESTAssured.RESTAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class TC_01Get {
	
	@Test
	public void Test_01() {
		//Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		System.out.println(response.getHeaders());
		System.out.println(response.getTime());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
	}
	
	@Test
	public void Test_02() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
	}
	@Test
	public void Test_3() {
		given().
		get("https://reqres.in/api/users?page=2").
		then().body("data.id[0]", equalTo(7));
		
	}

}
