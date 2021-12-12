package com.practices.testsNoBDD;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FaceBookTasts1 {


    @Test
    public void facebook() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
        System.out.println("actualTitle = " + actualTitle);





        WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));

        WebElement inputPassword = driver.findElement(By.id("pass"));




        WebElement headerVerify = driver.findElement(By.xpath("//*[@class='_8eso']"));

        String expectedHeader = "Connect with friends and the world around you on Facebook.";
        String actualHeader = driver.findElement(By.xpath("//*[@class='_8eso']")).getText();
        System.out.println("actualHeader = " + actualHeader);
        if(expectedHeader.equals(actualHeader)){
            System.out.println("Title is as expected, verify is passed");
        }else{
            System.out.println("Title is not as expected, verify is failed");

        }


       driver.findElement(By.xpath("//*[@href='/pages/create/?ref_type=registration_form']"))
               .sendKeys(Keys.ENTER);


    }
}
