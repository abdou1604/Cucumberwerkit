package com.xyzcorp;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class FruitTest {
    // Rest-Assured
    //[{"description":"Winter fruit","name":"Apple"} => [0]
    // {"description":"Tropical fruit","name":"Pineapple"}] => [1]
    @Test
                public  void testSomeThing () {

                given()
                        .relaxedHTTPSValidation()
                        .accept(ContentType.JSON)
                        .when()
                        .get("https://staging.tiered-planet.net/mild-temper/fruits")
                        .then()
                        .assertThat()
                        .body("[0].description", equalTo("Winter fruit"));
    }
}