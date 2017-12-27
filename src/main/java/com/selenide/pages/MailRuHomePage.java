package com.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MailRuHomePage {

    private static final String LOGIN = "test_user2017";
    private static final String PASSWORD = "Password123";

    @FindBy(css = "#mailbox\\:login")
    private SelenideElement loginField;

    @FindBy(css = "#mailbox\\:password")
    private SelenideElement passwordField;

    @FindBy(css = "#mailbox\\:domain")
    private SelenideElement domainField;

    @FindBy(css = "label#mailbox\\:submit")
    private SelenideElement submitButton;

    public MailRuHomePage openHomePage(){
        open("https://mail.ru/");
        return page(MailRuHomePage.class);
    }

    public EmailPage loginToMail() {
        loginField.val(LOGIN);
        passwordField.val(PASSWORD);
        domainField.selectOptionContainingText("@mail.ru");
        submitButton.click();
        return page(EmailPage.class);
        //$(By.xpath("//title")).shouldHave(text("Входящие - Почта Mail.Ru"));
    }
}
