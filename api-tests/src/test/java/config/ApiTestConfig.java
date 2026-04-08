package config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestConfig {
    protected static final String BASE_URL =
            System.getProperty("api.base.url", "https://restful-booker.herokuapp.com");

    @BeforeAll
    static void setUpApi() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.filters(new AllureRestAssured());
    }
}
