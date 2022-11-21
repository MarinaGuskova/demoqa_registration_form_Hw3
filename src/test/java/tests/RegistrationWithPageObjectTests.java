package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationWithPageObjectTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String userName = "Собака";
        String userLastName = "Сутулая";
        String userEmail = "Sutulaya@mail.net";
        String userGender = "Other";
        String userPhone = "1234567890";
//        datepicker
        String userSubjects = "Math";
        String userHobbies = "Sports";
//        userPicture?
        String userCurrentAddres = "Ramdev Mandir";
        String userState = "Rajasthan";
        String userCity = "Jaiselmer";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate("28" , "February", "2098");


                // datepicker

                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadPicture("dog.jfif")
                .setCurrentAddress(userCurrentAddres)
                .setState(userState)
                .setCity(userCity);

        $("#submit").click();
        registrationPage.verifyResultsModalAppears();



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
