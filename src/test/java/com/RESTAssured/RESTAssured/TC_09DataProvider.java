package com.RESTAssured.RESTAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_09DataProvider {

	@DataProvider(name="DeleteItom")
	public Object[] DataForDelete() {
		return new Object[] {
				243,241
		};
	}
	
	@Test(dataProvider="DeleteItom")
	public void Test_02(int Data) {
		baseURI="http://localhost:3000/";
		when()
		.delete("/users/"+Data)
		.then()
		.statusCode(204)
		.log().all();
	}

}
