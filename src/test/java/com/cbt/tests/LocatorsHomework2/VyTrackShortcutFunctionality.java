package com.cbt.tests.LocatorsHomework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class VyTrackShortcutFunctionality {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[id='prependedInput']")).sendKeys("salesmanager119");
        driver.findElement(By.cssSelector("input[id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).submit();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();

        String actual="https://qa2.vytrack.com/";
        String expected=driver.getCurrentUrl();
        System.out.println(expected);
        if (actual.equals(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("See full list")).click();
        driver.findElement(By.linkText("Opportunities")).click();
        String actual1="https://qa2.vytrack.com/opportunity";
        String expected1=driver.getCurrentUrl();
        System.out.println(expected1);
        if(actual1.equals(expected1)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("See full list")).click();
       // driver.findElement((By.xpath("//div[@id='container']/div[2]/div/table/tbody/tr[17]/td/a")).
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='nav top-search shortcuts']/div/a/i")).click();
        driver.findElement(By.linkText("See full list")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Vehicle Services Logs")).click();
       WebElement errorMessage=driver.findElement(By.xpath("//div[@class='alert alert-error fade in top-messages ']/div"));
        System.out.println(errorMessage);


    }
            }
