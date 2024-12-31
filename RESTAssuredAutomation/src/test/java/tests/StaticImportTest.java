package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class StaticImportTest {
	
	@Test
	public void test_1() {
		
		//non-static
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		//static
		Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
	}
	
	@Test
	public void test_2() {
		//given().get("https://reqres.in/api/users?page=2");
		
		baseURI = "https://reqres.in/api";
		
		//given().get("/users?page=2").then().statusCode(200);
		//Validate that the response status code matches an integer. 
		//E.g. get("/something").then().assertThat().statusCode(200);
		
		given()
		   .get("/users?page=2").
		then().statusCode(200)
		      .body("data[0].id", equalTo(7))
		      .log()
		      .all();
	}
}
