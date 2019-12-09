package com.cbt.tests.LocatorsHomework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://amazon.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
        driver.findElement(By.xpath("//input[@class='nav-input']")).click();
       // driver.findElement(By.ByXPath"(//span[@class='a-size-medium a-color-base a-text-normal'])[1]");
        String actualTitle = driver.getTitle();
        if(actualTitle.contains("laptop")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }
    }