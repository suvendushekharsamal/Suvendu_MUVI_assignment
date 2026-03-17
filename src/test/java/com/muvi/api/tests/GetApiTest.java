package com.muvi.api.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.muvi.api.base.BaseTest;

public class GetApiTest extends BaseTest {
    @Test
    public void testGetPost() {
        Response response = 
           RestAssured
                .given()
                .when()
                .get(ApiConstants.USERS_ENDPOINT+"/1")
                .then()
                .statusCode(200)
                .extract().response();
        JsonPath path= response.jsonPath();
        
        String id = path.getString("id");
        
        // Validate data types
        Assert.assertTrue(id instanceof String);
       
        //Validate value of data
        Assert.assertEquals(path.getInt("id"), 1);
        Assert.assertEquals(path.get("reviews.rating[1]"), 4);
        Float width=path.get("dimensions.width");
        Assert.assertEquals(Math.round(width * 100.0) / 100.0, 15.14);
        
        //Validate the body size
        Map<String, Object> dimensions = path.getMap("dimensions");

        int count = dimensions.size();
        System.out.println("Number of fields in dimensions: " + count);
        Assert.assertEquals(count, 3); // width, height, depth
        
        List<Map<String, Object>> reviews = response.jsonPath().getList("reviews");

        // Count how many reviews
        int review = reviews.size();
        Assert.assertEquals(review, 3);
        

        System.out.println(response.asPrettyString());
        
        
    }
}
