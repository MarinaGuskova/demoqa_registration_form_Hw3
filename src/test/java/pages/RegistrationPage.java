package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            emailInput = $("#userEmail"),
            genderButton = $("#genterWrapper").$(byText(userGender)),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesBox = $("#hobbiesWrapper").$(byText(value)),
            uploadPicrureButton = $("#uploadPicture"),
            CurrentAddressInput = $("#currentAddress");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue("value");
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderButton.click();
        return this;

    }

    public RegistrationPage setPhone(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;

    }

    public RegistrationPage setHobbies(String value) {
        hobbiesBox.$(byText(value)).click();
        return this;

    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicrureButton.uploadFromClasspath(value);
        return this;

    }

    public RegistrationPage setCurrentAddress(String value) {
        CurrentAddressInput.setValue(value);
        return this;

    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;

    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
        return this;

    }

}

