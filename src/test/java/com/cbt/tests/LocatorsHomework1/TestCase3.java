package com.cbt.tests.LocatorsHomework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCase3 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://wikipedia.org");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[id='searchInput']")).sendKeys("selenium WebDriver");
        driver.findElement(By.cssSelector("button[class=\"pure-button pure-button-primary-progressive\"]")).submit();
        driver.findElement(By.linkText("Selenium (software)")).click();
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.endsWith(("Selenium_(software)"))){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }


    }



}
