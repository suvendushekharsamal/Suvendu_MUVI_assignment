package com.muvi.api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import com.muvi.api.utils.ApiConstants;

public class BaseTest {
    @BeforeClass
    public void setup() {
<<<<<<< HEAD
        RestAssured.baseURI = "ApiConstants.BASE_URI"; 
=======
    	
        RestAssured.baseURI = ApiConstants.BASE_URI; // ✅ use HTTPS
>>>>>>> 283ea63 (Your commit message)
    }
}
