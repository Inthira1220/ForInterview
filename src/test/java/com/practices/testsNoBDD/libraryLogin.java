package com.practices.testsNoBDD;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class libraryLogin {
    @Test
    public void facebook() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://library2.cybertekschool.com/login.html");

        WebElement inputEmail = driver.findElement(By.id("inputEmail"));
        Thread.sleep(1000);
        inputEmail.sendKeys("Librarian60@library");

        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        Thread.sleep(1000);
        inputPassword.sendKeys("OoNKtPqP");

        WebElement signinButton = driver.findElement(By.xpath("//button[text()='Sign in']"));

        signinButton.click();

        String expectedTitle = "Login - Library";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
    }
}
