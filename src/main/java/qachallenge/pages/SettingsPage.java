package qachallenge.pages;

import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {


    //Locators
    String firstNameInput = "//input[@id='firstName']";
    String lastNameInput = "//input[@id='lastName']";
    String emailInput = "//input[@id='email']";
    String saveButton = "//button[text()='Save']";
    String settingsSavedAlert = "//div[text()='Settings saved!']";

    WebDriver driver;

    public SettingsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        
    }
    
    public void editUserSettings(String firstName, String lastName, String email){
        write(firstNameInput, firstName);
        write(lastNameInput, lastName);
        write(emailInput, email);
        clickElement(saveButton);
    }

    public boolean settingsSavedAlertIsDisplayed() throws InterruptedException{
        Thread.sleep(3000);
        return elementIsDisplayed(settingsSavedAlert);
    }


}
