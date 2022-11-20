package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

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


                // datepicker

                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadPicture("dog.jfif")
                .setCurrentAddress(userCurrentAddres)
                .setState(userState)
                .setCity(userCity);


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("2098");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();


        $("#submit").click();


        $x("//div[text()='Thanks for submitting the form']").shouldBe(Condition.visible);
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
