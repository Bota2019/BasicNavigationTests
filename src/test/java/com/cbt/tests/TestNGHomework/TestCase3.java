package com.cbt.tests.TestNGHomework;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase3 {

    WebDriver driver;
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(1000);
    }
    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
     @Test
    public void TestButton() throws InterruptedException{
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/botagozdaulyetbai/Desktop/dsdsdd.txt");
       driver.findElement(By.id("file-submit")).click();
       String file=driver.findElement(By.xpath("//h3")).getText();
         Assert.assertEquals(file,"File Uploaded!");
         String uploadedFile=driver.findElement(By.id("uploaded-files")).getText();
         Assert.assertEquals(uploadedFile,"dsdsdd.txt");


    }

}
