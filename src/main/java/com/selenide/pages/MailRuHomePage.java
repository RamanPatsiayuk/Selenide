package com.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import com.selenide.models.User;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.selenide.utils.PageTitlesConstants.EMAIL_PAGE_TITLE;

@Component
public class MailRuHomePage {

    @Value("${url}")
    private String URL;

    private static final String MAILBOX_CONTAINER = "#mailbox-container";
    private static final String LOGIN_FIELD = "#mailbox\\:login";
    private static final String PASSWORD_FIELD = "#mailbox\\:password";
    private static final String DOMAIN_FIELD = "#mailbox\\:domain";
    private static final String SUBMIT_BUTTON = "#mailbox\\:submit";
    private static final String REMEMBER_CHECKBOX = "#mailbox\\:saveauth";
    private static final String TITLE = "//title";

    @FindBy(css = LOGIN_FIELD)
    private SelenideElement loginField;

    @FindBy(css = PASSWORD_FIELD)
    private SelenideElement passwordField;

    @FindBy(css = DOMAIN_FIELD)
    private SelenideElement domainField;

    @FindBy(css = SUBMIT_BUTTON)
    private SelenideElement submitButton;

    @FindBy(css = REMEMBER_CHECKBOX)
    private SelenideElement rememberCheckBox;

    @FindBy(css = MAILBOX_CONTAINER)
    private SelenideElement mailBoxContainer;

    @FindBy(xpath = TITLE)
    private SelenideElement title;

    public MailRuHomePage openHomePage() {
        open(URL);
        return page(MailRuHomePage.class);
    }

    public EmailPage loginToMail(User user) {
        loginField.val(user.getLogin());
        passwordField.val(user.getPassword());
        domainField.selectOptionContainingText(user.getDomain());
        if (rememberCheckBox.is(attribute("selected", "true"))) {
            rememberCheckBox.click();
        }
        submitButton.click();
        title.shouldHave(text(EMAIL_PAGE_TITLE));
        return page(EmailPage.class);
    }


    private SelenideElement searchInput = $("#q");
    private SelenideElement searchButton = $("#search\\:submit");

    public SearchPageResult search(final String searchText){
        searchInput.setValue(searchText);
        searchButton.click();
        return page(SearchPageResult.class);
    }
}
