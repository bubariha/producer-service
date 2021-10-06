package com.microservice.producerservie.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

@SpringBootTest
public class PublishControllerTest {

    @Test
    public void testGetUserDetails() {
        String jsonRequest = "{\"address\":{\"addressLine1\":\"string\",\"addressLine2\":\"string\",\"postalCode\":\"string\",\"street\":\"string\"},\"birthDate\":\"09/01/1993\",\"country\":\"string\",\"countryCode\":\"string\",\"customerNumber\":\"123\",\"customerStatus\":\"R\",\"email\":\"string\",\"firstName\":\"Haribabu Pacharla\",\"lastName\":\"Haribabu Pacharla\",\"mobileNumber\":\"1234567890\"}";
        Gson gson = new GsonBuilder().create();
      /*  when().
                post("/publish", gson.fromJson(jsonRequest, Map.class)).
                then().
                statusCode(200).
                body("status", equalTo("success"),
                        "message", "Published successfully");*/

                        given()
                        .contentType(ContentType.JSON)
                        .body(jsonRequest)
                        .post("/publish")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }
}
