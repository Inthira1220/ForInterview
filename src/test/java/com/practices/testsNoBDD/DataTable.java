package com.practices.testsNoBDD;

import com.practices.utilites.ConfigurationReader;
import com.practices.utilites.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataTable {
    @Test
    public void dataTable(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/tables");

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //verify email = 	jsmith@gmail.com
        WebElement emailName = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[4]//td[3]"));
        System.out.println("emailName.getText() = " + emailName.getText());

        String expectedEmail = "tconway@earthlink.net";
        String actualEmail = emailName.getText();
        Assert.assertTrue(actualEmail.equals(expectedEmail));


        WebElement lastTable = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[last()]//td[last()]"));
        System.out.println("lastTable.getText() = " + lastTable.getText());
        WebElement tableHead = driver.findElement(By.xpath("//table[@id='table1']//th[3]"));
        System.out.println("tableHead.getText() = " + tableHead.getText());


        driver.close();
    }
}
