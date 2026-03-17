package com.muvi.api.tests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.muvi.api.base.BaseTest;
import com.muvi.api.pojo.*;
import com.muvi.api.utils.PayLoadBuilder;

import static io.restassured.RestAssured.*;

public class PostApiTest extends BaseTest {

//	@Test
//	public void CreateJSONObjectFromEmployeeClassObject() throws JsonProcessingException {
//		
//		PayLoadBuilder payloadBod=new PayLoadBuilder();
//		Product product=payloadBod.createEmployee("Vivo Mobile", 9999);
//		System.out.println(product);
//		ObjectMapper om=new ObjectMapper();
//		String productJson= om.writerWithDefaultPrettyPrinter().writeValueAsString(product);
//		//System.out.println(employeeJson);
//		
//		RequestSpecification reqs=given();
//		
//
//		reqs.contentType(ContentType.JSON);
//		reqs.body(productJson);
//		Response res= reqs.post("/products/add");
//		
//		System.out.println(res.prettyPrint());
//		
//		
//		
//	}
	@Test
	public void testCreateProduct() throws JsonProcessingException {
	    PayLoadBuilder payloadBod = new PayLoadBuilder();
	    Product product = payloadBod.createEmployee("Vivo Mobile", 9999);

	    Response res = given()
	            .contentType(ContentType.JSON)
	            .body(product)
	            .when()
	            .post("/products/add")
	            .then()
	            .statusCode(201)
	            .extract().response();

	    // Assertions on echoed response
	    Assert.assertEquals(res.jsonPath().getString("title"), "Vivo Mobile");
	    Assert.assertEquals(res.jsonPath().getInt("price"), 9999);
	    
	}

		
}

       