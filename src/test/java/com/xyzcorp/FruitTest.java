package com.xyzcorp;

import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class FruitTest {
    // Rest-Assured
    //[{"description":"Winter fruit","name":"Apple"} => [0]
    // {"description":"Tropical fruit","name":"Pineapple"}] => [1]
    @Test
    public  void testGetFruits () {

                given()
                        .relaxedHTTPSValidation()
                        .accept(ContentType.JSON)
                        .when()
                        .get("https://staging.tiered-planet.net/mild-temper/fruits")
                        .then()
                        .assertThat()
                        .body("[0].description", equalTo("Winter fruit"));
    }
    @Test
    public  void tesTPostNewFruit () {

        JSONObject bananaObject =new JSONObject()

                .put("description","a delecious treat")
                .put("name","banana");
        //System.out.println(bananaObject);

        given()
                .relaxedHTTPSValidation()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(bananaObject.toString())
                .when()
                .get("https://staging.tiered-planet.net/mild-temper/fruits")
                .then()
                .assertThat()
                .statusCode(200);

    }
}