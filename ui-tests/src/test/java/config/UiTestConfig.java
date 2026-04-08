package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class UiTestConfig {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = System.getProperty("ui.browser", "chrome");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("ui.headless", "true"));
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = System.getProperty("ui.base.url", "https://automationintesting.online");
        Configuration.screenshots = true;
        Configuration.savePageSource = true;

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
