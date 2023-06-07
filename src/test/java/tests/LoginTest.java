package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import common.Helper;
import pages.BasePage;

public class LoginTest extends BasePage {
    Helper helper = new Helper();

    By Username = By.xpath("//input[@placeholder=\"Username\"]");
    By Password = By.xpath("//input[@placeholder=\"Password\"]");
    By LoginButton = By.xpath("//input[@name=\"login-button\"]");
    By WebsiteLogo = By.xpath("//div[@class='app_logo']");
    By InvalidCredentialsErrorMessage = By.xpath("//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]");
    By EmptyPasswordErrorMessage = By.xpath("//*[contains(text(),'Epic sadface: Password is required')]");
    By EmptyUsernameErrorMessage = By.xpath("//*[contains(text(),'Epic sadface: Username is required')]");

    @Test(priority=12)
    public void verifySuccessfulLogin() throws InterruptedException {
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
    }

    @Test(priority=13)
    public void verifyUnsuccessfulLoginWithInvalidCredentials() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "invalid_username");
        helper.wait10AndType(Password, "invalid_password");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(InvalidCredentialsErrorMessage);
    }

    @Test(priority=14)
    public void emptyPasswordCredentialsValidation() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "");
        helper.wait10AndClick(LoginButton);
        helper.findElementByXPath(EmptyPasswordErrorMessage);
        Thread.sleep(1000);
    }

    @Test(priority=15)
    public void emptyUsernameCredentialsValidation() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        helper.findElementByXPath(EmptyUsernameErrorMessage);
        Thread.sleep(1000);
    }
}

