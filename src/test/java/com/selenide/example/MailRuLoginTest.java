package com.selenide.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.junit.ScreenShooter;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.common.io.Files;
import com.selenide.models.User;
import com.selenide.pages.EmailPage;
import com.selenide.pages.MailRuHomePage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.selenide.utils.PageTitlesConstants.EMAIL_PAGE_TITLE;
import static com.selenide.utils.PageTitlesConstants.MAILRU_HOME_PAGE_TITLE;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context.xml"})
public class MailRuLoginTest extends BaseTest {
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @Autowired
    private MailRuHomePage mailRuHomePage;

    @Autowired
    private User user;

    @Test
    @Ignore
    public void openMailRuHomePageTest() {
        mailRuHomePage.openHomePage();
        $(By.xpath("//title")).shouldHave(text(MAILRU_HOME_PAGE_TITLE));
    }

    @Test
    @Ignore
    public void loginToMailRuTest() {
        open("https://mail.ru/");
        $("input#mailbox\\:login").val(user.getLogin());
        $("input#mailbox\\:password").val(user.getPassword());
        $("#mailbox\\:domain").selectOptionContainingText(user.getDomain());
        $("label#mailbox\\:submit").click();
        $(By.xpath("//title")).shouldHave(text(EMAIL_PAGE_TITLE));
    }

    @Test
    public void loginToMailPoTest() {
        EmailPage emailPage = mailRuHomePage.openHomePage().loginToMail(user);
        assertThat("Title is not correct", emailPage.isTitleCorrect());
    }
}

