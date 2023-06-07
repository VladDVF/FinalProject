package tests;

import common.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;

public class AboutTest extends BasePage {
    Helper helper = new Helper();

    By Username = By.xpath("//input[@placeholder=\"Username\"]");
    By Password = By.xpath("//input[@placeholder=\"Password\"]");
    By LoginButton = By.xpath("//input[@name=\"login-button\"]");
    By WebsiteLogo = By.xpath("//div[@class='app_logo']");
    By BurgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");
    By AboutButton = By.xpath("//a[@id='about_sidebar_link']");

    @Test(priority=1)
    public void verifySuccessfulNavigationToAboutPage() throws InterruptedException {
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(BurgerMenu);
        helper.clickAndVerifyUrl(AboutButton, "https://saucelabs.com/");
        Thread.sleep(1000);
    }
}


