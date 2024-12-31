package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	
	//@Test
	public void testPost() {
		
		JSONObject req = new JSONObject();
		req.put("name", "Prince");
		req.put("job", "Student");
		System.out.println(req.toJSONString());

		baseURI = "https://reqres.in/api";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().
			all();
		
	}
	
	//@Test
	public void testPut() {
		JSONObject request = new JSONObject ();
		request.put("name", "Kalpana");
		request.put("job", "Lecturer");
		
		baseURI = "https://reqres.in/api";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().
			all();
	}
	
	@Test
	public void testPatch() {
		Map<String, Object> map =  new HashMap<String, Object>();
		map.put("name", "Sachi");
		map.put("job", "princess");
		
		JSONObject re = new JSONObject(map);
		
		baseURI = "https://reqres.in";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(re.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().
			all();
	}
	
	@Test
	public void testDelete() {
		
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204);
		
	}

}
