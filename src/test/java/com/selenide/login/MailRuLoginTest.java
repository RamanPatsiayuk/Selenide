package com.selenide.login;

import com.selenide.BaseTest;
import com.selenide.models.User;
import com.selenide.pages.EmailPage;
import com.selenide.pages.MailRuHomePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static com.selenide.utils.PageTitlesConstants.EMAIL_PAGE_TITLE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context.xml"})
public class MailRuLoginTest extends BaseTest {

    @Autowired
    private MailRuHomePage mailRuHomePage;

    @Autowired
    private User user;

    /*@Test
    public void loginToMailRuTest() {
        open("https://mail.ru/");
        $("input#mailbox\\:login").val(user.getLogin());
        $("input#mailbox\\:password").val(user.getPassword());
        $("#mailbox\\:domain").selectOptionContainingText(user.getDomain());
        $("label#mailbox\\:submit").click();
        $(By.xpath("//title")).shouldHave(text(EMAIL_PAGE_TITLE));
    }*/

    @Test
    public void loginToMailPoTest() {
        EmailPage emailPage = mailRuHomePage.openHomePage().loginToMail(user);
        assertThat(title(), is(equalTo(EMAIL_PAGE_TITLE)));
        //assertThat("Title is not correct", emailPage.isTitleCorrect());
        emailPage.logOut();
    }
}

