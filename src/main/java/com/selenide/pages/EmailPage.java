package com.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.*;

@Component
public class EmailPage {
    private static final String EMAIL_PAGE_TITLE = "Входящие - Почта Mail.Ru";

    private SelenideElement authUser = $("#PH_authMenu_button").find("#PH_user-email");
    private SelenideElement logoutLink = $("#PH_logoutLink");

    public boolean isTitleCorrect() {
        return title().contains(EMAIL_PAGE_TITLE);
    }

    public MailRuHomePage logOut() {
        logoutLink.click();
        return page(MailRuHomePage.class);
    }

}
