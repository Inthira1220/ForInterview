package com.practices.pages;

import com.practices.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchPage {
    public AmazonSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "twotabsearchtextbox")
    public WebElement searchBar;
    @FindBy (id = "nav-search-submit-button")
    public WebElement pressButton;
    @FindBy (xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public WebElement linkKeyBoard;
    @FindBy (xpath = "//input[@id='add-to-cart-button']")
    public WebElement addOrder;
    @FindBy (xpath = "//span[@class='a-button a-button-grouplast a-button-base']")
    public WebElement noAddProtectionPlan;

}
