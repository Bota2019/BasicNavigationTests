package com.cbt.tests.LocatorsHomework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCase1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ebay.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[id='gh-ac']")).sendKeys("search term");
        driver.findElement(By.cssSelector("input[id='gh-btn']")).submit();
        WebElement result = driver.findElement(By.className("BOLD"));
        System.out.println(result.getText());





    }



}
