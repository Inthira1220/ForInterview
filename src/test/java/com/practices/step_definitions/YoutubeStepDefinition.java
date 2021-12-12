package com.practices.step_definitions;

import com.practices.pages.YoutubePage;
import com.practices.utilites.BrowserUtils;
import com.practices.utilites.ConfigurationReader;
import com.practices.utilites.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class YoutubeStepDefinition {
    YoutubePage youtubePage = new YoutubePage();
    Actions actions = new Actions(Driver.getDriver());
    @Given("User is landing on youtube Page")
    public void user_is_landing_on_youtube_page() {
    String url = ConfigurationReader.getProperty("youtubeUrl");
        Driver.getDriver().get(url);
        String expectedTitle = "YouTube";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    @When("User search for Thailand in the youtube search box")
    public void userSearchForThailandInTheYoutubeSearchBox() throws InterruptedException {
        //youtubePage.homePage.click();
        youtubePage.searchBox.sendKeys("10 Best Places to Visit in Thailand - Travel Video");
        actions.click(youtubePage.clickSearch).perform();
        Thread.sleep(1000);
        String expectedTitle = "10 Best Places to Visit in Thailand - Travel Video - YouTube";
        BrowserUtils.assertTitle(expectedTitle);
    }
    @When("User should be able to click the search button")
    public void user_should_be_able_to_click_the_search_button() throws InterruptedException {

        Thread.sleep(1000);
        actions.doubleClick(youtubePage.selectVideo).perform();
        Thread.sleep(1000);
        youtubePage.popUpDismiss.click();
    }
    @Then("User should be able to play")
    public void user_should_be_able_to_play() {
        String expectedTitle = "10 Best Places to Visit in Thailand - Travel Video - YouTube";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));

        //Driver.closeDriver();

    }
}
