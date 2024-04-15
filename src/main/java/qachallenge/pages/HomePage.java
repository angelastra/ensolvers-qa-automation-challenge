package qachallenge.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //Locators
    String manageToDoItemsButton = "//button[contains(text(),'Manage To-Do Items')]";
    String manageFoldersButton = "//button[contains(text(),'Manage Folders')]";
    String accountMenuLink = "//a/span[text()='Account']";
    String accountSettingsLink = "//a/span[text()='Account']";
    String settingsLink = "//a[text()='Settings']";
    String signOutLink = "//a[@href='/logout']";
    String logoutSuccessfulAlert= "//h4[text()='Logged out successfully!']";

    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void logIn(){
        LoginPage lp = new LoginPage(driver);
        lp.navigateTo();
        lp.fillTheForm("user", "user");
    }

    public void clickOnManageToDoItemsButton(){
        clickElement(manageToDoItemsButton);
    }

    public void clickOnManageFoldersButton(){
        clickElement(manageFoldersButton);
    }

    public void navigateToUserSettings(){
        clickElement(accountSettingsLink);
        clickElement(settingsLink);
    }

    public void logOutSession(){
        clickElement(accountSettingsLink);
        clickElement(signOutLink);
    }

    public boolean verifyLogOut(){
        return elementIsDisplayed(logoutSuccessfulAlert);
    }
    
}
