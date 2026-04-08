package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    private final SelenideElement checkoutMarker = $("body");

    public CheckoutPage verifyCheckoutPageVisible() {
        checkoutMarker.shouldBe(visible);
        return this;
    }
}
