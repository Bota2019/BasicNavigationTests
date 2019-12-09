package com.cbt.tests.TestNGHomework;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase9 {

    WebDriver driver;

    @BeforeMethod
    public void obpenBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @DataProvider(name = "data-provider")
    public Object[] dataProviderMethod() {
        return new Object[]{"200", "301", "404", "500"};
    }

    @Test(dataProvider = "data-provider")
    public void test9(String data) {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.cssSelector("a[href='status_codes/" + data + "']")).click();
        WebElement text = driver.findElement(By.xpath("//h3/../p"));
        String actual = "This page returned a " + data + " status code.";
        String expected = text.getText();

        Assert.assertTrue(expected.startsWith(actual));


        driver.close();
    }


}