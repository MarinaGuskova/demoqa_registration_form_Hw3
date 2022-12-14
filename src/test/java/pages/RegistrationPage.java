package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            emailInput = $("#userEmail"),
            genderButton = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesBox = $("#hobbiesWrapper"),
            uploadPicrureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("#submit");



    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
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
        genderButton.$(byText(value)).click();
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
        currentAddressInput.setValue(value);
        return this;

    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;

    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;

    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;


    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;

    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResults(key, value);
        return this;

    }
    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }
}

