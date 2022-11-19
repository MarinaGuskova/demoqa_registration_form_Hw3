package com.example.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll

    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1620x800";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browser = "firefox";

    }

    @Test
     void fillFormTest() {

        open("/automation-practice-form");

        //  Кнопка закрытия баннера не сработала $("#close-fixedban").click();
        // убрать баннер
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Собака");
        $("#lastName").setValue("Сутулая");
        $("#userEmail").setValue("Sutulaya@mail.net");
//        $x("//label[text()='Other']").click(); or $(byText("Other")).click(); // not very good
//        $("label[for=gender-radio-3]").click(); // better
        $("#genterWrapper").$(byText("Other")).click(); // best
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").click(); // лишнее
        $(".react-datepicker__month-select").selectOption("February");
//        $(".react-datepicker__year-select").click(); // лишнее
        $(".react-datepicker__year-select").selectOption("2098");
//        $x("//div[@aria-label='Choose Friday, February 28th, 2098']").click(); // not very good
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
//        $x("//input[@id='subjectsInput']").setValue("Офигенный автотест"); неверно
        $("#subjectsInput").setValue("Math").pressEnter();
//        $x("//label[text()='Sports']").click(); // not very good
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //     Загрузить файл
//        $x("//input[@id='uploadPicture']").uploadFile(new File("src/test/resources/dog.jfif")); // can be
        $("#uploadPicture").uploadFromClasspath("dog.jfif");
//        $x("//textarea[@id='currentAddress']").setValue("Ramdev Mandir"); // can be
        $("#currentAddress").setValue("Ramdev Mandir");
//        $x("//div[@id='state']").click(); // can be
        $("#state").click();
//        $x("//div[text()='Rajasthan']").click(); // can be
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
//        $x("//div[@id='city']").click(); // can be
        $("#city").click();
//        $x("//div[text()='Jaiselmer']").click(); // can be
        $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
        $("#submit").click();


        $x("//div[text()='Thanks for submitting the form']").shouldBe(Condition.visible);
//        $(".modal-dialog").should(appear); // can be
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Собака Сутулая"),
                text("Sutulaya@mail.net"),
                text("Other"),
                text("1234567890"),
                text("28 February,2098"),
                text("Sports"),
                text("dog.jfif"),
                text("Ramdev Mandir"),
                text("Rajasthan Jaiselmer")
        );
    }
}
