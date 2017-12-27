package com.selenide.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EmailPage {
    private static final String EMAIL_PAGE_TITLE = "Входящие - Почта Mail.Ru";

    public String getTitle() {
        return $(By.xpath("//title")).getText();
    }

    public boolean isTitleCorrect() {
        return $(By.xpath("//title")).getText().matches(EMAIL_PAGE_TITLE);
    }

}
