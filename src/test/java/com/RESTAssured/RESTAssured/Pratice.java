package com.RESTAssured.RESTAssured;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Pratice {
	
	@Test
	public void Test_01() {
		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.header("Connection", "keep-alive")
		.log().all();
	}

}
