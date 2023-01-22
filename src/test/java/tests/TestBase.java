package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfiguration;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    private static WebConfig config;
    private static ProjectConfiguration configuration;

    @BeforeAll
    static void beforeAll() {
        config = ConfigFactory.create(WebConfig.class, System.getProperties());
        configuration = new ProjectConfiguration();
        configuration.webConfig(config);

        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("https://www.rabota.ru");
//        Selenide.clearBrowserCookies();
//        Selenide.clearBrowserLocalStorage();
//        executeJavaScript("sessionStorage.clear();");
    }

    @AfterEach
    void AfterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}