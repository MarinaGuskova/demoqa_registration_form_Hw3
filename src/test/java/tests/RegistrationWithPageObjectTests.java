package tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class RegistrationWithPageObjectTests extends TestBase {
    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker(new Locale("de"));

        String userName = faker.cat().breed();
        String userLastName = faker.animal().name();
        String userEmail = faker.internet().emailAddress();
        String userGender = "Other";
        String userPhone = faker.phoneNumber().subscriberNumber(10);
        String dayBirth = "28";
        String monthBirth = "February";
        String yearBirth = "2098";
        String userSubjects = "Math";
        String userHobbies = "Sports";
        String pictureDirectory = "dog.jfif";
        String userCurrentAddres = faker.shakespeare().romeoAndJulietQuote();
        String userState = "Rajasthan";
        String userCity = "Jaiselmer";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(dayBirth, monthBirth, yearBirth)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadPicture(pictureDirectory)
                .setCurrentAddress(userCurrentAddres)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit();

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
