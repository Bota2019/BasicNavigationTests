package com.cbt.tests.TestNGHomework;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Registration Form")).click();
    }

   @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
       driver.quit();

    }
    @Test
    public void test1(){

        WebElement input1=driver.findElement(By.cssSelector("input[name='birthday']"));
        input1.sendKeys("5/19/85");
       String wrongmsg= driver.findElement(By.className("help-block")).getText();
        System.out.println(wrongmsg);
        Assert.assertEquals(wrongmsg, "The date of birth is not valid");
    }
   @Test
    public void test2(){
        WebElement CPlus=driver.findElement(By.xpath("(//label[@class='form-check-label'])[1]"));

       String actual = CPlus.getText();
       Assert.assertEquals(actual, "C++","Text did not match");
       System.out.println(actual);

         WebElement Java=driver.findElement(By.xpath("(//label[@class='form-check-label'])[2]"));
         String actual1=Java.getText();
         Assert.assertEquals(actual1,"Java","Text did not match");
       System.out.println(actual1);

         WebElement JavaScript=driver.findElement(By.xpath("(//label[@class='form-check-label'])[3]"));
         String actual2=JavaScript.getText();
         Assert.assertEquals(actual2,"JavaScript","Text did not match");
       System.out.println(actual2);
    }
     @Test
    public void test3(){
        WebElement firstName=driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("A");
        String wrongName=driver.findElement(By.cssSelector("small[data-bv-result='INVALID']")).getText();
         System.out.println(wrongName);
         Assert.assertEquals(wrongName,"first name must be more than 2 and less than 64 characters long");
     }

      @Test
    public void test4(){
        WebElement lastName=driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("B");
        String wrongLastName=driver.findElement(By.cssSelector("small[data-bv-result=\"INVALID\"]")).getText();
          System.out.println(wrongLastName);
          Assert.assertEquals(wrongLastName,"The last name must be more than 2 and less than 64 characters long");
      }
       @Test
    public void test5(){
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Aijan");
         driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Tugelbai");
         driver.findElement(By.cssSelector("input[name='username']")).sendKeys("vicky2019");
         driver.findElement(By.cssSelector("input[name='email']")).sendKeys("vicky2583@gmail.com");
         driver.findElement(By.cssSelector("input[name='password']")).sendKeys("User12345");
         driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("424-644-5797");
         driver.findElement(By.cssSelector("input[value='female']")).click();
         driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("03/25/1983");
         Select department=new Select(driver.findElement(By.cssSelector("select[name='department']")));
         department.selectByVisibleText("MPDC");
         Select job=new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
         job.selectByVisibleText("Product Owner");
         driver.findElement(By.xpath("(//label[@class='form-check-label'])[2]")).click();
         driver.findElement(By.id("wooden_spoon")).click();
         WebElement message=driver.findElement(By.cssSelector("div[class='alert alert-success']"));
         String successMessage=message.getText();
           System.out.println(successMessage);
           Assert.assertEquals(successMessage,"Well done!\n"+"You've successfully completed registration!");

       }

}