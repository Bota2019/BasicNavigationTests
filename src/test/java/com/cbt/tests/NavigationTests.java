package com.cbt.tests;

        import com.cbt.utilities.WebDriverFactory;
        import com.cbt.utilities.StringUtility;
        import org.openqa.selenium.WebDriver;

public class NavigationTests {
    /*
     1.Open browser
     2.Go to website https://google.com
     3 Save the title in a string variable
     4.Go to https://etsy.com
             5. Save the title in a string variable
             6. Navigate back to previous page
             7. Verify that title is same is in step3
             8. Navigate forward to previous page
             9.Verify that title is same is in step5
             */
    public static void main(String[] args) {














        Chrome("chrome");
       FireFox("firefox");
            Safari("safari");
    }
        public static void Chrome (String browser){
            // open browser

            WebDriver driver = WebDriverFactory.getDriver(browser);
            // go to website https://google.com
            driver.get("https://google.com");
            //save the title in a String variable
            String title1 = driver.getTitle();
            //got to http://etsy.com
            driver.navigate().to("http://etsy.com");
            // driver.get("http://etsy.com");
            // save the title in a String variable
            String title2 = driver.getTitle();
            //navigate back to previous page
            driver.navigate().back();
            //Verify that title is same as page 3
            String title3 = driver.getTitle();

            //Navigate forward to previous page
            driver.navigate().forward();
            driver.quit();
        }

        public static void FireFox (String browser){
            WebDriver driver = WebDriverFactory.getDriver(browser);
            driver.get("https://google.com");
            String title1 = driver.getTitle();

            driver.navigate().to("http://etsy.com");


            String title2 = driver.getTitle();

            driver.navigate().back();
            String title3 = driver.getTitle();
            StringUtility.verifyEqual(title1, driver.getTitle());

            driver.navigate().forward();
            driver.quit();

        }

    public static void Safari (String browser){
        WebDriver driver = WebDriverFactory.getDriver(browser);
        driver.get("https://google.com");
        String title1 = driver.getTitle();

        driver.navigate().to("http://etsy.com");


        String title2 = driver.getTitle();

        driver.navigate().back();
        String title3 = driver.getTitle();
        StringUtility.verifyEqual(title1, driver.getTitle());

        driver.navigate().forward();
        driver.quit();

    }

    }




