package com.trenditra.tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName();
        registrationPage.typeLastName();
        registrationPage.typeEmail();
        registrationPage.selectGender();
        registrationPage.typeMobile();
        registrationPage.selectDateOfBirth();
        registrationPage.selectSubjects();
        registrationPage.selectHobbies();
        registrationPage.uploadPicture();
        registrationPage.typeCurrentAddress();
        registrationPage.selectState();
        registrationPage.selectCity();
        registrationPage.submitForm();

        registrationPage.checkSubmittedTitle();
        registrationPage.checkSubmittedForm();
    }
}