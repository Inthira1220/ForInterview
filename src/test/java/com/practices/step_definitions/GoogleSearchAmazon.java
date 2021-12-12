package com.practices.step_definitions;

import com.practices.pages.AmazonSearchPage;
import com.practices.utilites.ConfigurationReader;
import com.practices.utilites.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GoogleSearchAmazon {
    AmazonSearchPage amazonSearchPage = new AmazonSearchPage();

    @Given("User is on landing the Google Home Page")
    public void user_is_on_landing_the_google_home_page() {
        String url = ConfigurationReader.getProperty("amazonUrl");
        Driver.getDriver().get(url);
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }

    @When("User searches for amazon")
    public void user_searches_for_amazon() {
        amazonSearchPage.searchBar.sendKeys("keyboard");
        amazonSearchPage.pressButton.click();
        //amazonSearchPage.linkKeyBoard.click();
        //amazonSearchPage.addOrder.click();
        //amazonSearchPage.noAddProtectionPlan.click();


    }
    @Then("User should see amazon is in the Title")
    public void user_should_see_amazon_is_in_the_title() {
        String expectedTitle = "Amazon.com : keyboard";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }


}
