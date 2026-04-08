package tests;

import config.UiTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import pages.CartPage;
import pages.CatalogPage;
import pages.CheckoutPage;
import pages.LoginPage;

public class E2eCriticalPathTest extends UiTestConfig {
    @Test
    @Tag("e2e")
    @Tag("regression")
    @EnabledIfSystemProperty(named = "ui.e2e.enabled", matches = "true")
    @DisplayName("Critical path: login -> catalog -> cart -> checkout")
    void criticalPathFlow_shouldWork() {
        new LoginPage()
                .openPage()
                .verifyFormVisible()
                .loginAs("qa-user", "qa-password");

        new CatalogPage()
                .openPage()
                .addFirstProductToCart();

        new CartPage()
                .openPage()
                .verifyCartNotEmpty()
                .checkout();

        new CheckoutPage().verifyCheckoutPageVisible();
    }
}
