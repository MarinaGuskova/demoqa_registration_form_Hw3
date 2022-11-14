package com.example.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll

    static void BeforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1620x800";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browser = "firefox";

    }
    @Test
    void FillFormTest(){

      open("/automation-practice-form");

      //  Кнопка закрытия баннера не сработала $("#close-fixedban").click();
      // убрать баннер
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

      $("#firstName").setValue("Собака");
      $("#lastName").setValue("Сутулая");
      $("#userEmail").setValue("Sutulaya@mail.net");
      $x("//label[text()='Other']").click();
      $("#userNumber").setValue("1234567890");
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select").click();
      $(".react-datepicker__month-select").selectOption("February");
      $(".react-datepicker__year-select").click();
      $(".react-datepicker__year-select").selectOption("2098");
      $x("//div[@aria-label='Choose Friday, February 28th, 2098']").click();
      $x("//input[@id='subjectsInput']").setValue("Офигенный автотест");
      $x("//label[text()='Sports']").click();
      $x("//label[text()='Reading']").click();
      $x("//label[text()='Music']").click();
      //     Загрузить файл
      $x("//input[@id='uploadPicture']").uploadFile(new File("src/test/resources/dog.jfif"));
      $x("//textarea[@id='currentAddress']").setValue("Ramdev Mandir");
      $x("//div[@id='state']").click();
      $x("//div[text()='Rajasthan']").click();
      $x("//div[@id='city']").click();
      $x("//div[text()='Jaiselmer']").click();

      $("#submit").click();


      $x("//div[text()='Thanks for submitting the form']").shouldBe(Condition.visible);
      $(".table-responsive").shouldHave(text("Собака Сутулая"),
                                                 text("Sutulaya@mail.net"),
                                                 text("Other"),
                                                 text("1234567890"),
                                                 text("28 February,2098"),
                                                 text("Sports, Reading, Music"),
                                                 text("dog.jfif"),
                                                 text("Ramdev Mandir"),
                                                 text("Rajasthan Jaiselmer")
      );


    }

}
