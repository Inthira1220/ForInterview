package com.practices.testsNoBDD;

import com.practices.utilites.ConfigurationReader;
import com.practices.utilites.Driver;
import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDownTask {

    @Test
    public void dropDownTask() throws InterruptedException {
        /*
        TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Verify “Simple dropdown” default selected value is correct
        Expected: “Please select an option”
        4. Verify “State selection” default selected value is correct
        Expected: “Select a State”
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement selectSimple = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(selectSimple);
        select.selectByVisibleText("Please select an option");

        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        String expectedSelectSimple = "Please select an option";
        String actualSelectSimple = select.getFirstSelectedOption().getText();

        Assert.assertTrue(expectedSelectSimple.equals(actualSelectSimple));

        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String expectedSelectState = "Select a State";
        String actualSelectSate = selectState.getFirstSelectedOption().getText();
        if (expectedSelectState.equals(actualSelectSate)) {
            System.out.println("Default selected is correct");
        } else {
            System.out.println("Default selected is Incorrect");
        }
        /*
        3. Select Illinois
        4. Select Virginia
        5. Select California
        6. Verify final selected option is California.
        Use all Select options. (visible text, value, index)
         */

        Select selectStateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectStateDropDown.selectByValue("VA");
        Thread.sleep(1000);
        selectStateDropDown.selectByIndex(6);
        Thread.sleep(1000);
        selectStateDropDown.selectByVisibleText("Illinois");
        Thread.sleep(1000);

        String expectedState = "Illinois";
        String actualState = selectStateDropDown.getFirstSelectedOption().getText();
        Assert.assertTrue(expectedState.equals(actualState));

        /*
        Select “December 1st, 1922” and verify it is selected.
        Select year using  : visible text
        Select month using   : value attribute
        Select day using  : index number
         */


        Select selectDate = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectDate.selectByVisibleText("1");
        Thread.sleep(1000);
        selectMonth.selectByVisibleText("May");
        Thread.sleep(1000);
        selectYear.selectByValue("1977");
        Thread.sleep(1000);

        String day = "1";
        String month = "May";
        String year = "1977";
        String actualDay = selectDate.getFirstSelectedOption().getText();
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String actualYear = selectYear.getFirstSelectedOption().getText();

        System.out.println("actualDay = " + actualDay);
        System.out.println("actualMonth = " + actualMonth);
        System.out.println("actualYear = " + actualYear);
        if (day.equals(actualDay)&&month.equals(actualMonth)&&year.equals(actualYear)){
            System.out.println("date, month, year = "+ day+" "+ month+" "+year);
        }else{
            System.out.println("failed");
        }
        /*
        Select all the options from multiple select dropdown.
        Print out all selected values.
        Deselect all values.
         */
        driver.navigate().refresh();
        WebElement defaultPage = driver.findElement(By.tagName("h3"));
        System.out.println("defaultPage.getText() = " + defaultPage.getText());

        /*
        Click to non-select dropdown
        Select Facebook from dropdown
        Verify title is “Facebook - Log In or Sign Up”
         */
        WebElement websiteDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        Thread.sleep(1000);
        websiteDropdown.click();
        WebElement selectFaceBook = driver.findElement(By.xpath("//a[.='Facebook']"));
        selectFaceBook.click();
        String expectedFacebook = "Facebook - Log In or Sign Up";
        String actualFacebook = driver.getTitle();
        if(expectedFacebook.equals(actualFacebook)){
            System.out.println(actualFacebook);
        }else{
            System.out.println("Title is not as expected, verify is failed");
        }

                driver.close();
            }
        }
