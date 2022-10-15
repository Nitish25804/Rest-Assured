package com.RESTAssured.RESTAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_06Delete {
	
	@Test
	public void Test_01() {
		when().
		delete("https://reqres.in/api/users/2").
		then().
		statusCode(204).
		log().all();
	}

}
