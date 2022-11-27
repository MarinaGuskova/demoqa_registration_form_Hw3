package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import testData.TestData;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @BeforeAll

    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1620x800";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browser = "firefox";

    }
}
