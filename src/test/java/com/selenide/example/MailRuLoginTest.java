package com.selenide.example;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MailRuLoginTest {
    public static final String LOGIN = "test_user2017";
    public static final String PASSWORD = "Password123";

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
        $("label#mailbox\\:submit").click();
    }
}
