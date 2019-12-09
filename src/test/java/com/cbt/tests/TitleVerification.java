package com.cbt.tests;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/", "https://walmart.com");
        for (String url : urls) {
            getUrl(url);

        }

    }

    public static void getUrl(String url){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(url);
        String title = driver.getTitle();
        System.out.println(title);
       String nospace=  title.replaceAll(" ","");
        System.out.println(nospace);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
       // StringUtility.verifyContains(nospace,currentUrl);

        //driver.qu



    }

}


