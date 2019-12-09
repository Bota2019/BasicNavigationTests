package com.cbt.tests.TestNGHomework2;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase1 {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
      driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
      driver.findElement(By.id("_submit")).click();

       Thread.sleep(2000);
       actions = new Actions(driver);
       WebElement activities=driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[5]/a/span"));
       WebElement calendarEvents=driver.findElement(By.xpath("//span[text()='Calendar Events']"));
       Thread.sleep(2000);
        actions.moveToElement(calendarEvents).perform();
       calendarEvents.click();

}
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.quit();

    }
   @Test
    public void Test1() throws InterruptedException{
       WebElement options= driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']"));
       Assert.assertTrue(options.isDisplayed());
   }
    @Test
    public void Test2() throws InterruptedException{
        String page=driver.findElement(By.cssSelector("input[type='number']")).getAttribute("Value");
        Assert.assertEquals(page,"1");
    }
    @Test
    public void Test3() throws InterruptedException{
       Thread.sleep(2000);

        String perPage=driver.findElement(By.xpath("//div/button[contains(text(),'        25')]")).getText();
        System.out.println("something " + perPage);
        Assert.assertEquals(perPage.trim(),"25");
    }
      @Test
    public void Test4() throws InterruptedException{
          Thread.sleep(1000);
          List<WebElement> allRows = driver.findElements(By.xpath("//tbody/tr"));
          System.out.println(allRows.size());
          String expectation = "Total Of " + allRows.size() + " Records";
          String actual = driver.findElement(By.xpath("//label[contains(@class,'dib')][3]")).getText();
          Assert.assertEquals(expectation, actual );
    }

   @Test
    public void Test5()  throws InterruptedException{
        Thread.sleep(1000);
        WebElement checkBox=driver.findElement(By.xpath("//div[@class='btn-group dropdown']/button/input"));
        checkBox.click();
        Thread.sleep(1000);
      List<WebElement> checked=driver.findElements(By.xpath("//input[@tabindex='-1']"));
       System.out.println(checked.size());
       int count =0;
       for(WebElement each : checked) {
           boolean box = each.isSelected();
           count++;
           System.out.println(count + ". row is clicked:" + box);
       }

   }

     @Test
    public void Test6() throws InterruptedException{
        Thread.sleep(1000);
        WebElement testersMeeting=driver.findElement(By.xpath("//td[contains(text(),'Testers Meeting')]"));
        testersMeeting.click();
        List<WebElement> title=driver.findElements(By.xpath("(//div[@class='section-content'])[1]"));
         System.out.println(title.size());
        int count=0;
        for(WebElement each: title){
            boolean text=each.isDisplayed();
            count++;
            System.out.println(count+ ". schedule is displayed");
            // New Changes
        }
     }
}
