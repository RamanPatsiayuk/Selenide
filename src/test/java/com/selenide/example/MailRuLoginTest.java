package com.selenide.example;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import com.selenide.pages.EmailPage;
import com.selenide.pages.MailRuHomePage;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.selenide.utils.PageTitlesConstants.EMAIL_PAGE_TITLE;
import static com.selenide.utils.PageTitlesConstants.MAILRU_HOME_PAGE_TITLE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MailRuLoginTest {
    private static final String LOGIN = "test_user2017";
    private static final String PASSWORD = "Password123";

    @Test
    @Ignore
    public void openMailRuHomePageTest() {
        open("https://mail.ru/");
        $(By.xpath("//title")).shouldHave(text(MAILRU_HOME_PAGE_TITLE));
    }

    @Test
    //@Ignore
    public void loginToMailRuTest() {
        open("https://mail.ru/");
        $("input#mailbox\\:login").val(LOGIN);
        $("input#mailbox\\:password").val(PASSWORD);
        $("#mailbox\\:domain").selectOptionContainingText("@mail.ru");
        $("label#mailbox\\:submit").click();
        $(title()).shouldHave(text(EMAIL_PAGE_TITLE));
    }

    @Test
    @Ignore
    public void loginToMailPoTest() {
        EmailPage emailPage = new MailRuHomePage().openHomePage().loginToMail();
        assertThat(title(), is(equalTo(EMAIL_PAGE_TITLE)));
        //assertThat("Title is not correct", emailPage.isTitleCorrect());
    }

    /*@After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    private byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }*/
}

