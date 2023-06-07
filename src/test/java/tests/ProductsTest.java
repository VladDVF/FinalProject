package tests;

import common.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;

public class ProductsTest extends BasePage {
    Helper helper = new Helper();

    By Username = By.xpath("//input[@placeholder=\"Username\"]");
    By Password = By.xpath("//input[@placeholder=\"Password\"]");
    By LoginButton = By.xpath("//input[@name=\"login-button\"]");
    By WebsiteLogo = By.xpath("//div[@class='app_logo']");
    By ItemTitle = By.xpath("//*[contains(text(),'Sauce Labs Backpack')]");
    By BackToProducts = By.xpath("//button[@name='back-to-products']");

    @Test (priority=17)
    public void verifyProductsInfoPage() throws InterruptedException {
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(ItemTitle);
        Thread.sleep(1000);
        helper.clickAndVerifyUrl(BackToProducts, "https://www.saucedemo.com/inventory.html");
        Thread.sleep(1000);
    }
}
