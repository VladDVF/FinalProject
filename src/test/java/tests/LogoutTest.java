package tests;

import common.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;

public class LogoutTest extends BasePage {
    Helper helper = new Helper();

    By Username = By.xpath("//input[@placeholder=\"Username\"]");
    By Password = By.xpath("//input[@placeholder=\"Password\"]");
    By LoginButton = By.xpath("//input[@name=\"login-button\"]");
    By WebsiteLogo = By.xpath("//div[@class='app_logo']");
    By BurgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");
    By LogoutButton = By.xpath("//a[@id='logout_sidebar_link']");

    @Test(priority=16)
    public void verifySuccessfulLogout() throws InterruptedException {
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(BurgerMenu);
        helper.wait10AndClick(LogoutButton);
        helper.findElementByXPath(LoginButton);
        Thread.sleep(1000);
    }
}
