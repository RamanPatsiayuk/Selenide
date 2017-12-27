package com.selenide.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class EmailPage {
    private static final String EMAIL_PAGE_TITLE = "Входящие - Почта Mail.Ru";

    public String getTitle() {
        return title();
    }

    public boolean isTitleCorrect() {
        return title().matches(EMAIL_PAGE_TITLE);
    }

}
