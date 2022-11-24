package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll

    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1620x800";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "firefox";

    }
}
