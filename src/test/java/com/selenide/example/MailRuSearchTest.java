package com.selenide.example;

import com.codeborne.selenide.CollectionCondition;
import com.selenide.pages.MailRuHomePage;
import com.selenide.pages.SearchPageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.codeborne.selenide.Condition.text;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context.xml"})
public class MailRuSearchTest extends BaseTest {

    @Autowired
    private MailRuHomePage mailRuHomePage;

    @Autowired
    private SearchPageResult searchPageResult;

    @Test
    public void mailRuSearchTest() {
        String expectedText = "Selenide: лаконичные и стабильные UI тесты на Java ";
        searchPageResult = mailRuHomePage.openHomePage().search("selenide");
        searchPageResult.getSearchResults().shouldHave(CollectionCondition.size(11));
        searchPageResult.getResult(1).shouldHave(text(expectedText));
    }
}
