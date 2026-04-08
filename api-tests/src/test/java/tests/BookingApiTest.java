package tests;

import config.ApiTestConfig;
import io.restassured.http.ContentType;
import models.Booking;
import models.BookingDates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

public class BookingApiTest extends ApiTestConfig {
    @Test
    @Tag("smoke")
    @DisplayName("GET /booking returns non-empty list")
    void getBookings_shouldReturn200() {
        given()
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Tag("regression")
    @DisplayName("POST /booking creates booking")
    void createBooking_shouldReturn200() {
        BookingDates dates = new BookingDates("2026-12-01", "2026-12-10");
        Booking booking = new Booking("John", "Doe", 150, true, dates, "Breakfast");

        given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue());
    }
}
