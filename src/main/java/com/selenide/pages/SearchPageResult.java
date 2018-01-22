package com.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class SearchPageResult {

    public ElementsCollection getSearchResults(){
        return $$("#js-result>li");
    }

    public SelenideElement getResult(int index) {
        return $(String.format("#js-result_%d", index));
    }
}
