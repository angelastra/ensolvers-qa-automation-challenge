package qachallenge.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qachallenge.pages.LoginPage;
import qachallenge.testComponents.BaseTest;

public class LoginTest extends BaseTest {

    @Test()
    public void successfulLoginTest() {
        // Test logic using page objects
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.navigateTo();
        //loginPage.fillTheForm("user","user");
        Assert.assertTrue(loginPage.visibilityOfSuccessfulLogInMessage());
    }

    @Test
    public void successfulLogoutTest() {
        // Test logic using page objects
        //LoginPage loginPage = new LoginPage(driver);
       // loginPage.navigateTo();
        //loginPage.fillTheForm("user","user");
        homePage.logOutSession();
        Assert.assertTrue(homePage.verifyLogOut());
    }
}


