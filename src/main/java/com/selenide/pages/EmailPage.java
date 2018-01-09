package com.selenide.pages;

import static com.codeborne.selenide.Selenide.title;

public class EmailPage {
    private static final String EMAIL_PAGE_TITLE = "Входящие - Почта Mail.Ru";

    public boolean isTitleCorrect() {
        return title().contains(EMAIL_PAGE_TITLE);
    }

}
