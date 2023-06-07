package tests;

import common.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;

public class FooterNavigationTest extends BasePage {
    Helper helper = new Helper();

    By Username = By.xpath("//input[@placeholder=\"Username\"]");
    By Password = By.xpath("//input[@placeholder=\"Password\"]");
    By LoginButton = By.xpath("//input[@name=\"login-button\"]");
    By WebsiteLogo = By.xpath("//div[@class='app_logo']");
    By TwitterButton = By.xpath("//a[@href='https://twitter.com/saucelabs']");
    By FacebookButton = By.xpath("//a[@href='https://www.facebook.com/saucelabs']");
    By LinkedinButton = By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']");


    @Test(priority=11)
    public void verifyFooterNavigationFunctionality() throws InterruptedException {
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.clickAndVerifyUrlOnDifferentTab(TwitterButton, "https://twitter.com/saucelabs");
        helper.clickAndVerifyUrlOnDifferentTab(FacebookButton, "https://www.facebook.com/saucelabs");
        helper.clickAndVerifyUrlOnDifferentTab(LinkedinButton, "https://www.linkedin.com/company/sauce-labs/?original_referer=");
    }
}

