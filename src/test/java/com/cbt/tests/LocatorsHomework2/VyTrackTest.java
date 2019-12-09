package com.cbt.tests.LocatorsHomework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class VyTrackTest {
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
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"][@role=\"menu\"]/li[2]")).click();
        Thread.sleep(2000);

        String actual=driver.getTitle();

        String expected= "Magdalena Stehr";
        if(actual.startsWith(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }

}
