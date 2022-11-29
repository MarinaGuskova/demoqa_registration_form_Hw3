
package tests;

import org.junit.jupiter.api.Test;

import static testData.TestData.*;


public class RegistrationWithPageObjectTests extends TestBase {

    @Test
    void successfulRegistrationTest() {

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
                .verifyResult("Date of Birth", testData.dayBirth + " " + testData.monthBirth + "," + testData.yearBirth)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", "dog.jfif")
                .verifyResult("Address", userCurrentAddres)
                .verifyResult("State and City", userState + " " + userCity);

    }
}

