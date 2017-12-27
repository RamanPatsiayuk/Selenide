package com.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MailRuHomePage {

    private static final String LOGIN = "test_user2017";
    private static final String PASSWORD = "Password123";
    private static final String LOGIN_FIELD = "#mailbox\\:login";
    private static final String PASSWORD_FIELD = "#mailbox\\:password";
    private static final String DOMAIN_FIELD = "#mailbox\\:domain";
    private static final String SUBMIT_BUTTON = "#mailbox\\:submit";


    @FindBy(css = LOGIN_FIELD)
    private SelenideElement loginField;

    @FindBy(css = PASSWORD_FIELD)
    private SelenideElement passwordField;

    @FindBy(css = DOMAIN_FIELD)
    private SelenideElement domainField;

    @FindBy(css = SUBMIT_BUTTON)
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
    }
}
