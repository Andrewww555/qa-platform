package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {
    private final SelenideElement firstProductCard = $(".room-card");
    private final SelenideElement addToCartButton = $(".btn.btn-primary");

    public CatalogPage openPage() {
        open("/");
        return this;
    }

    public CatalogPage addFirstProductToCart() {
        firstProductCard.shouldBe(visible);
        addToCartButton.click();
        return this;
    }
}
