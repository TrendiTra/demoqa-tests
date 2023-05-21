package com.trenditra.tests;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userMobile = faker.phoneNumber().subscriberNumber(10),
            userAddress = faker.address().fullAddress();

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            mobileInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select"),
            daySelect = $(".react-datepicker__day--007:not(.react-datepicker__day--outside-month)"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper").$(byText("Reading")),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateSelect = $("#state"),
            stateSelectValue = $("#stateCity-wrapper"),
            citySelect = $("#city"),
            stateCitySelect = $("#stateCity-wrapper"),
            submitClick = $("#submit"),
            submittedForm = $(".table-responsive"),
            submittedTitle = $(".modal-title");

    public void openPage() {
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName() {
        firstNameInput.setValue(firstName);
    }

    public void typeLastName() {
        lastNameInput.setValue(lastName);
    }

    public void typeEmail() {
        emailInput.setValue(userEmail);
    }

    public void selectGender() {
        genderInput.$(byText("Male")).click();
    }

    public void typeMobile() {
        mobileInput.setValue(userMobile);
    }

    public void selectDateOfBirth() {
        dateOfBirthInput.click();
        monthSelect.selectOption("December");
        yearSelect.selectOption("1993");
        daySelect.click();
    }

    public void selectSubjects() {
        subjectsInput.setValue("Math").pressEnter();
    }

    public void selectHobbies() {
        hobbiesInput.click();
    }

    public void uploadPicture() {
        pictureUpload.uploadFile(new File("C:/Downloads/examples/example.jpg"));
    }

    public void typeCurrentAddress() {
        currentAddressInput.setValue(userAddress);
    }

    public void selectState() {
        stateSelect.click();
        stateSelectValue.$(byText("NCR")).click();
    }

    public void selectCity() {
        citySelect.click();
        stateCitySelect.$(byText("Delhi")).click();
    }

    public void submitForm() {
        submitClick.click();
    }

    public void checkSubmittedTitle() {
        submittedTitle.shouldHave(text("Thanks for submitting the form"));
    }

    public void checkSubmittedForm() {
        submittedForm.shouldHave(text(firstName + " " + lastName)
                , text(userEmail)
                , text("Male")
                , text(userMobile)
                , text("7 December,1993")
                , text("Math")
                , text("Reading")
                , text("example.jpg")
                , text(userAddress)
                , text("NCR Delhi"));
    }
}
