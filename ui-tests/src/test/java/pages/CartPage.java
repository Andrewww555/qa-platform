package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {
    private final SelenideElement cartItems = $(".booking-details");
    private final SelenideElement checkoutButton = $(".btn.btn-success");

    public CartPage openPage() {
        open("/booking");
        return this;
    }

    public CartPage verifyCartNotEmpty() {
        cartItems.shouldBe(visible);
        return this;
    }

    public CartPage checkout() {
        if (checkoutButton.exists()) {
            checkoutButton.click();
        }
        return this;
    }
}
