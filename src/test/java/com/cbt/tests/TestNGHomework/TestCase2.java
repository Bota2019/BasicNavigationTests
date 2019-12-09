package com.cbt.tests.TestNGHomework;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2 {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(200);
    }

  //  @AfterMethod
  //  public void closeBrowser() throws InterruptedException {
   //     Thread.sleep(5000);
    //    driver.quit();

   // }
    @Test
    public void test1()throws InterruptedException{
      driver.get("https://www.tempmailaddress.com/");
        WebElement email=driver.findElement(By.cssSelector("a[class='navbar-brand']"));
        String emailID=email.getText();
        System.out.println(emailID);

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.cssSelector("input[name='full_name']")).sendKeys("Aijan Daulyetbai");
        driver.findElement(By.name("email")).sendKeys("emailID");
        driver.findElement(By.cssSelector("button[name='wooden_spoon']")).click();
       // String message=
    }

}