package com.practices.testsNoBDD;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTask {
    /*
    TC #1: Smartbear software link verification
        1. Open browser
        2. Go to website:
        http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        3. Enter username: “Tester”
        4. Enter password: “test”
        5. Click to Login button
        6. Print out count of all the links on landing page
        7. Print out each link text on this page
     */
    @Test
    public void smartBearTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passWord = driver.findElement(By.id("ctl00_MainContent_password"));
        passWord.sendKeys("test");
        WebElement logInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        logInButton.sendKeys(Keys.ENTER);
        //List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        List <WebElement> listOfLinks = driver.findElements(By.xpath("//ul[@id='ctl00_menu']//li"));
        System.out.println("listOfLinks.size() = " + listOfLinks.size());
        for (WebElement each : listOfLinks) {

            System.out.println("each.getText() "+each.getText());
        }
            /*
            Click on Login button
            6. Click on Order
            7. Select familyAlbum from product, set quantity to 2
            8. Click to “Calculate” button
            9. Fill address Info with JavaFaker
            • Generate: name, street, city, state, zip code
            10. Click on “visa” radio button
            11. Generate card number using JavaFaker
            12. Click on “Process”
            13. Verify success message “New order has been successfully added.”
             */
        WebElement clickOrder = driver.findElement(By.linkText("Order"));
        clickOrder.sendKeys(Keys.ENTER);

        WebElement selectProduct = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        selectProduct.sendKeys("2", Keys.ENTER);
        Thread.sleep(1000);
        WebElement selectButton = driver.findElement((By.xpath("//input[@class='btn_dark']")));
        selectButton.sendKeys(Keys.ENTER);
        //Fill address Info with JavaFaker • Generate: name, street, city, state, zip code
        WebElement name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement street = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement state = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        Faker faker = new Faker();
        String nameFaker = faker.name().firstName();
        name.sendKeys(nameFaker, Keys.ENTER);
        Thread.sleep(1000);
        String streetName = faker.address().cityName();
        street.sendKeys(streetName, Keys.ENTER);
        Thread.sleep(1000);
        String cityName = faker.address().city();
        city.sendKeys(cityName, Keys.ENTER);
        Thread.sleep(1000);
        String stateName = faker.address().cityName();
        state.sendKeys(stateName, Keys.ENTER);
        Thread.sleep(1000);
        //String zipCodeName = faker.address().zipCode();
        zipCode.sendKeys("22182", Keys.ENTER);
        /*
        Click on “visa” radio button
            11. Generate card number using JavaFaker
            12. Click on “Process”
            13. Verify success message “New order has been successfully added.”
         */
        WebElement visa = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visa.click();
        Thread.sleep(1000);
        WebElement cardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        //String cardNumberFaker = faker.number()
        cardNumber.sendKeys("12341234122341234", Keys.ENTER);
        Thread.sleep(1000);
        WebElement cardExpired = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        //String expiredNumber = faker.number().digit();
        cardExpired.sendKeys("05/21", Keys.ENTER);
        Thread.sleep(1000);

        WebElement clickProcess = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        clickProcess.sendKeys(Keys.ENTER);

        String expectedProcess = "New order has been successfully added.";
        String actualProcess = clickProcess.getText();
        //Assert.assertTrue(expectedProcess.equals(actualProcess));

driver.close();

    }
}
