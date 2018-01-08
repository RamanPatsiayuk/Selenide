package com.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import com.selenide.models.User;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

@Component
public class MailRuHomePage {

    @Value("${url}")
    private String URL;

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

    public MailRuHomePage openHomePage() {
        open(URL);
        return page(MailRuHomePage.class);
    }

    public EmailPage loginToMail(User user) {
        loginField.val(user.getLogin());
        passwordField.val(user.getPassword());
        domainField.selectOptionContainingText(user.getDomain());
        submitButton.click();
        return page(EmailPage.class);
    }
}
