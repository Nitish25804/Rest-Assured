package com.RESTAssured.RESTAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TC_08DataProvider1 {
	
	@DataProvider(name="DataRestAssured")
	public Object[][] DataForPost() {
		/*Object[][] obj=new Object[2][3];
		
		obj[0][0]="Albert";
		obj[0][1]="Einstine";
		obj[0][2]=238;
		
		obj[1][0]="Thomas";
		obj[1][1]="Edison";
		obj[1][2]=237;
		return obj;8*/
		return new Object[][] {
			{"Graham","Bell",243},
			{"Mania","Query",241}
		};
}
	
	@Test(dataProvider="DataRestAssured",enabled=false)
	public void Test_01(String First_Name,String Last_Name,int a) {
		baseURI="http://localhost:3000/";
		JSONObject js=new JSONObject();
		js.put("first_name",First_Name );
		js.put("last_name",Last_Name );
		js.put("id", a);
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
	
}
