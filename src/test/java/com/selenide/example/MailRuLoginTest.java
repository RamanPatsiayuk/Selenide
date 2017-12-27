package com.selenide.example;

import com.selenide.pages.EmailPage;
import com.selenide.pages.MailRuHomePage;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class MailRuLoginTest {
    private static final String LOGIN = "test_user2017";
    private static final String PASSWORD = "Password123";

    @Test
    public void openMailRuHomePageTest(){
        open("https://mail.ru/");
        $(By.xpath("//title")).shouldHave(text("Mail.Ru: почта, поиск в интернете, новости, игры"));
    }

    @Test
    public void loginToMailRuTest() {
        open("https://mail.ru/");
        $("input#mailbox\\:login").val(LOGIN);
        $("input#mailbox\\:password").val(PASSWORD);
        $("#mailbox\\:domain").selectOptionContainingText("@mail.ru");
        $("label#mailbox\\:submit").click();
        $(By.xpath("//title")).shouldHave(text("Входящие - Почта Mail.Ru"));
    }

    @Test
    public void loginToMailPoTest() {
        EmailPage emailPage = new MailRuHomePage().openHomePage().loginToMail();
        $(By.xpath("//title")).shouldHave(text("Входящие - Почта Mail.Ru"));
    }
}
