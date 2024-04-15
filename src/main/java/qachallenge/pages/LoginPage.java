package qachallenge.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //Locators
    String usernameTextField = "//input[@id='username']";
    String passwordTextField = "//input[@id='password']";
    String signInButton = "//button[@type='submit']";
    String didYouForgetYourPasswordLink = "//a[text()='Did you forget your password?']";
    String logInSuccessfulMessage = "//div[@role='alert' and contains(text(),'You are logged in as')]";
    private String URL = "https://qa-challenge.ensolvers.com/login";
    WebDriver driver;

    public LoginPage(WebDriver driver) 
    {
        super(driver);
        this.driver=driver;
    }

    public void navigateTo(){
        navigateTo(URL);
    }

    public void fillTheForm(String username,String password){
        write(usernameTextField, username);
        write(passwordTextField, password);
        clickElement(signInButton);

    }

    public boolean visibilityOfSuccessfulLogInMessage(){
        return elementIsDisplayed(logInSuccessfulMessage);
    }

    
}
