package Demo1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class test1 {
	@Test (enabled = false)
	public void signup() {
		//first step will always be to specify baseURL
		RestAssured.baseURI = "https://ecommerceservice.herokuapp.com";
		
		//second step will be to get the body
		String requestbody = "{\n"
				+ "	\"email\": \"djalok12@gmail.com\",\n"
				+ "	\"password\": \"djalok@123\"\n"
				+ "}";
		
		//third step is to use given method
		
		Response response = given()
		.header("content-Type","application/json")
		.body(requestbody)
		
		.when()
		.post("/user/signup")
		
		.then()
		.assertThat().statusCode(201).and().contentType(ContentType.JSON)
		
		.extract().response();
		
		//response i get the response will be as string //i have to convert the response in to json
		String responsebody = response.asString();
		
		//i want to convert it in to json
		JsonPath data = new JsonPath(responsebody);
		
		System.out.println(data.get("message"));
}
	
	@Test
	
	public void login() {
RestAssured.baseURI = "https://ecommerceservice.herokuapp.com";
		
		//second step will be to get the body
		String requestbody = "{\n"
				+ "	\"email\": \"djalok12@gmail.com\",\n"
				+ "	\"password\": \"djalok@123\"\n"
				+ "}";
		
		//third step is to use given method
		
		Response response = given()
		.header("content-Type","application/json")
		.body(requestbody)
		
		.when()
		.post("/user/login")
		
		.then()
		.assertThat().statusCode(200).and().contentType(ContentType.JSON)
		
		.extract().response();
		
		//response i get the response will be as string //i have to convert the response in to json
		String responsebody = response.asString();
		
		//i want to convert it in to json
		JsonPath data = new JsonPath(responsebody);
		
		System.out.println(data.get("accessToken"));
	}
	}
	
