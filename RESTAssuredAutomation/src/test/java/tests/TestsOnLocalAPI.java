package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class TestsOnLocalAPI {
	
	//@Test
	public void getRequest() {
		
		baseURI = "http://localhost:3000";
		
		given().
			get("/users").
		then().
			statusCode(200).
			log().
			all();
	}
	
	//@Test
	public void postRequest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "Suraj");
		map.put("lastName", "Ade");
		map.put("subjectId", "1");
		
		baseURI = "http://localhost:3000";
		
		JSONObject objReq = new JSONObject(map);
		
		System.out.println(objReq.toJSONString());
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(objReq.toJSONString()).
		when()
			.post("/users").
		then().
			statusCode(201).
			log().
			body();
	}
	
	//@Test
	public void putRequest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "Sarika");
		map.put("lastName", "Rathod");
		map.put("subjectId", "3");
		
		JSONObject obj = new JSONObject(map);
		
		baseURI = "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(obj.toJSONString()).
		when().
			put("/users/5").
		then().
			statusCode(200);
	}
	
	//@Test
	public void patchRequest() {
		Map<String, Object> map =  new HashMap<String, Object>();
		map.put("subjectId", 2);
		
		JSONObject obj = new JSONObject(map);
		
		baseURI = "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(obj.toJSONString())
		.when()
			.patch("/users/5")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void deleteRequest() {
		
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/5")
		.then()
			.statusCode(200);//Some times it is 200, some times 204.
	}
}
