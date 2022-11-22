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
                .setBirthDate("28", "February", "2098")
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadPicture("dog.jfif")
                .setCurrentAddress(userCurrentAddres)
                .setState(userState)
                .setCity(userCity);

        $("#submit").click();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", "28 February,2098")
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", "dog.jfif")
                .verifyResult("Address", userCurrentAddres)
                .verifyResult("State and City", userState + " " + userCity);

    }
}
