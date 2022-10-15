package com.RESTAssured.RESTAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




import io.restassured.http.ContentType;

public class TC_10ParaMeters {
	
	@Test
	@Parameters({"namef","namel","j"})
	public void Test_01(String Name,String LName,int Id) {
		JSONObject js=new JSONObject();
		baseURI="http://localhost:3000/";
		js.put("first_name", Name);
		js.put("last_name", LName);
		js.put("id", Id);
		given().
		header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(js.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
