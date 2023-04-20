package com.slavinskiy.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1900x1080";
    }

    @Test
    void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Wolf");
        $("#userEmail").setValue("olegwolf@gmail.com");
        $x("//label[contains(text(),'Male')]").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $x("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/select[1]").click();
        $x("//option[contains(text(),'December')]").click();
        $x("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/select[1]").click();
        $x("//option[contains(text(),'1993')]").click();
        $x("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $x("//label[contains(text(),'Reading')]").click();
        $x("//label[contains(text(),'Music')]").click();
        $("#uploadPicture").uploadFile(new File("C:/Downloads/examples/example.jpg"));
        $("#currentAddress").setValue("Wolfs street 7");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $x("//tbody/tr[1]/td[2]").shouldHave(text("Oleg Wolf"));
        $x("//tbody/tr[2]/td[2]").shouldHave(text("olegwolf@gmail.com"));
        $x("//tbody/tr[3]/td[2]").shouldHave(text("Male"));
        $x("//tbody/tr[4]/td[2]").shouldHave(text("0123456789"));
        $x("//tbody/tr[5]/td[2]").shouldHave(text("07 December,1993"));
        $x("//tbody/tr[6]/td[2]").shouldHave(text("English"));
        $x("//tbody/tr[7]/td[2]").shouldHave(text("Sports, Reading, Music"));
        $x("//tbody/tr[8]/td[2]").shouldHave(text("example.jpg"));
        $x("//tbody/tr[9]/td[2]").shouldHave(text("Wolfs street 7"));
        $x("//tbody/tr[10]/td[2]").shouldHave(text("NCR Delhi"));
    }
}