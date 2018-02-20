package com.selenide.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

public abstract class BaseTest {
    WebDriver driver = WebDriverRunner.getWebDriver();

    @Before
    public void setUp() {
        Configuration.timeout = 6000;
    }

    @After
    public void tearDown() throws IOException {
        try {
            screenshot();
        }catch (NullPointerException ex){
            ex.getMessage();
        }
        /*if(driver != null){
            driver.quit();
        }*/

    }

    @Attachment(type = "image/png")
    private byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        if(screenshot.exists() && !screenshot.isDirectory())
            FileUtils.copyFile(screenshot, new File("build\\allure-results\\screenshots\\" + screenshot.getName()));
        return Files.toByteArray(screenshot);
    }
}
