package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;

public class TestExamples {
	
	@Test
	public void test() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		int responseStatusCode = response.statusCode();
		long responseTime = response.getTime();
		//ResponseBody responseBody = response.getBody();

		System.out.println(responseStatusCode);
		System.out.println(responseTime);
		System.out.println();
		System.out.println(response.getBody().asString());
		System.out.println();
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		//assertions
		Assert.assertEquals(responseStatusCode, 200);
		
		//if(responseStatusCode==200) {
		//	System.out.println("passed");
		//} else {
		//	System.out.println("failed");
		//}

	}
}
