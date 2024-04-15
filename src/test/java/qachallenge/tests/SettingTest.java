package qachallenge.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qachallenge.pages.SettingsPage;
import qachallenge.testComponents.BaseTest;

public class SettingTest extends BaseTest {
    
    @BeforeMethod
    public void accessSettingsPage(){
        homePage.navigateToUserSettings();
    }



    @Test
    public void editUserSettings() throws InterruptedException{
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.editUserSettings("Michael ", "Jordan", "michaeljordan@mail.com");
        Assert.assertTrue(settingsPage.settingsSavedAlertIsDisplayed(),"The alert is not shown");
    }
}
