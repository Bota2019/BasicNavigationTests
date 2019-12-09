package com.cbt.tests.TestNGHomework;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {

    WebDriver driver;
        @BeforeMethod
        public void openBrowser() throws InterruptedException {
            driver = WebDriverFactory.getDriver("chrome");
            Thread.sleep(2000);
            driver.manage().window().maximize();
            driver.get("https://practice-cybertekschool.herokuapp.com/");
        }
        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
    }
    @Test
    public void AutoTest() throws InterruptedException {
        driver.findElement(By.linkText("Autocomplete")).click();
       driver.findElement(By.id("myCountry")).sendKeys("Uni");
         driver.findElement(By.id("myCountry")).sendKeys(Keys.ARROW_DOWN);
         Thread.sleep(1000);
        driver.findElement(By.id("myCountry")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("myCountry")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
         driver.findElement(By.id("myCountry")).sendKeys(Keys.ENTER);
         Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[type='button']")).click();
         String message=driver.findElement(By.id("result")).getText();
        System.out.println(message);
        Assert.assertEquals(message,"You selected: United States of America");

    }
    }
