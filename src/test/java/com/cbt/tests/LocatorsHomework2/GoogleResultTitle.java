package com.cbt.tests.LocatorsHomework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class GoogleResultTitle {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "Selenium");
        driver.get("http://google.com");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.name("q"));
        Thread.sleep(2000);
        for (int i = 0; i < searchStrs.size(); i++) {
            search.sendKeys(searchStrs.get(i));
            search.submit();
            WebElement GreenUrl = driver.findElement(By.tagName("cite"));
            System.out.println(GreenUrl.getText());
            //clicking on first link
            WebElement FirstLink = driver.findElement(By.tagName("h3"));
            FirstLink.click();
            String currentUrl = driver.getCurrentUrl();
            System.out.println("currentUrl = " + currentUrl);
            if (GreenUrl.equals(currentUrl)) {
                System.out.println("PASS");
            } else {
                System.out.println("False");
                // go back at previous page
                driver.navigate().back();
                search = driver.findElement(By.name("q"));
                search.clear();
            }


        }

    }
    }
