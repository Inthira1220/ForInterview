package com.practices.pages;

import com.practices.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubePage {
    public YoutubePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//tp-yt-paper-item[@class='style-scope ytd-guide-entry-renderer']")
    public WebElement homePage;
    @FindBy(name = "search_query")
    public WebElement searchBox;
    @FindBy(id= "search-icon-legacy")
    public WebElement clickSearch;
    @FindBy(xpath = "//*[@id='video-title']/yt-formatted-string")
    public WebElement selectVideo;
    @FindBy(xpath = "//*[@class ='style-scope ytd-button-renderer style-text size-default']")
    public WebElement popUpDismiss;

}
