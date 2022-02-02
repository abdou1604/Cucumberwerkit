package com.xyzcorp;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestLegume {
    // [{"description":"Root vegetable, usually orange","name":"Carrot"},
    // {"description":"Summer squash","name":"Zucchini"}]
    @Test
    public  void testVegetable() {

           given()
                .relaxedHTTPSValidation()
                .accept(ContentType.JSON)
                .when()
                .get("https://staging.tiered-planet.net/mild-temper/legumes\n")
                .then()
                .assertThat()
                .body("[1].name", equalTo("Zucchini"));
    }
}
