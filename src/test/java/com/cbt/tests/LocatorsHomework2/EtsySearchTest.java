package com.cbt.tests.LocatorsHomework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EtsySearchTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ebay.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[id='gh-ac']")).sendKeys("wooden spoon");
        driver.findElement(By.cssSelector("input[id=\"gh-btn\"]")).click();
        String totalNum = driver.findElement(By.cssSelector("h1[class=\"srp-controls__count-heading\"]")).getText();
        System.out.println(totalNum);
        String afterSplit1 = totalNum.split(" ")[0].replace(",", "");
        int result1 = Integer.parseInt(afterSplit1);
        driver.findElement(By.xpath("//div[@id='x-refine__group__0']/ul/li/a/span")).click();
        String totalResult = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(totalResult);
        String afterSplit = totalResult.split(" ")[0].replace(",", "");
        int result = Integer.parseInt(afterSplit);
        if (result > result1) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver.navigate().back();
        String search = "driver.findElement(By.cssSelector(\"input[id='gh-ac']\"))";
        String actual="wooden spoon";
        if (search.contains(actual)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


    }
}
