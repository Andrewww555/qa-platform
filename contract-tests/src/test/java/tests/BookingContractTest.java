package tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class BookingContractTest {
    @Test
    @Tag("contract")
    void shouldRespectContractForBookingList() {
        WireMockServer wm = new WireMockServer(0);
        wm.start();
        wm.stubFor(get(urlEqualTo("/booking"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"bookingid\":1}]")));
        try {
            given()
                    .baseUri("http://localhost:" + wm.port())
                    .when()
                    .get("/booking")
                    .then()
                    .statusCode(200)
                    .body("[0].bookingid", equalTo(1));
        } finally {
            wm.stop();
        }
    }
}
