package com.RESTAssured.RESTAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_07DummyApi {
	
	@Test
	public void Test_01() {
		baseURI="http://localhost:3000";
		given()
		.get("/users")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(enabled=false)
	public void Test_02() {
		baseURI="http://localhost:3000/";
		JSONObject js=new JSONObject();
		js.put("first_name","Pinu");
		js.put("last_name","Behera");
		js.put("id",237);
		js.put("Job","Contractor");
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(js.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201)
		.log().all();
	}
	
	@Test
	public void Test_03() {
		baseURI="http://localhost:3000/";
		JSONObject js=new JSONObject();
		js.put("last_name","Mishra");
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(js.toJSONString())
		.when()
		.patch("/users/237")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void Test_04(){
		baseURI="http://localhost:3000/";
		when()
		.delete("/users/237")
		.then()
		.statusCode(204)
		.log().all();
	}

}
