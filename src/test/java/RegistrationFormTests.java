package com.example.demoqa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll
    static void BeforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1132x753";
//        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browser = "firefox";
    }
    @Test
    void FillFormTest(){

      open("/automation-practice-form");

      $("#firstName").setValue("Собака");
      $("#lastName").setValue("Сутулая");
      $("#userEmail").setValue("Sutulaya@mail.net");
      $x("//div[@class='custom-control custom-radio custom-control-inline'][3]").click();
      $("#userNumber").setValue("1234567890");
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select").click();
      $(".react-datepicker__month-select").selectOption("February");
      $(".react-datepicker__year-select").click();
      $(".react-datepicker__year-select").selectOption("2098");
      $(".react-datepicker__year-select").click();
      $x("//div[@class='react-datepicker__week'][5]//div[@class='react-datepicker__day react-datepicker__day--028']").click();
      $("#close-fixedban").click();
    }

}
