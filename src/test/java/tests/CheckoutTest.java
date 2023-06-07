package tests;

import common.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;

public class CheckoutTest extends BasePage {
    Helper helper = new Helper();

    By Username = By.xpath("//input[@placeholder=\"Username\"]");
    By Password = By.xpath("//input[@placeholder=\"Password\"]");
    By LoginButton = By.xpath("//input[@name=\"login-button\"]");
    By WebsiteLogo = By.xpath("//div[@class='app_logo']");
    By AddToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By CartIcon = By.xpath("//a[@class='shopping_cart_link']");
    By CartItem = By.xpath("//div[@class='cart_item_label']");
    By CheckoutButton = By.xpath("//button[@id='checkout']");
    By FirstName = By.xpath("//input[@placeholder='First Name']");
    By LastName = By.xpath("//input[@placeholder='Last Name']");
    By ZipCode = By.xpath("//input[@placeholder='Zip/Postal Code']");
    By ContinueButton = By.xpath("//input[@value='Continue']");
    By FinishButton = By.xpath("//button[@id='finish']");
    By CancelButton = By.xpath("//button[@id='cancel']");

    By CheckoutCompleteMessage = By.xpath("//*[contains(text(),'Thank you for your order!')]");
    By ProductsTitle = By.xpath("//*[contains(text(),'Products')]");
    By EmptyFirstNameErrorMessage = By.xpath("//*[contains(text(),'Error: First Name is required')]");
    By EmptyLastNameErrorMessage = By.xpath("//*[contains(text(),'Error: Last Name is required')]");
    By EmptyZipPostalCodeErrorMessage = By.xpath("//*[contains(text(),'Error: Postal Code is required')]");

    @Test(priority=6)
    public void SuccessfullyCheckout() throws InterruptedException {
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(AddToCartButton);
        helper.wait10AndClick(CartIcon);
        helper.findElementByXPath(CartItem);
        helper.wait10AndClick(CheckoutButton);
        helper.wait10AndType(FirstName, "Andy");
        helper.wait10AndType(LastName, "Lucky");
        helper.wait10AndType(ZipCode, "1234");
        helper.wait10AndClick(ContinueButton);
        helper.wait10AndClick(FinishButton);
        helper.findElementByXPath(CheckoutCompleteMessage);
        Thread.sleep(1000);
    }

    @Test(priority=7)
    public void cancelCheckout() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(AddToCartButton);
        helper.wait10AndClick(CartIcon);
        helper.findElementByXPath(CartItem);
        helper.wait10AndClick(CheckoutButton);
        helper.wait10AndType(FirstName, "Andy");
        helper.wait10AndType(LastName, "Lucky");
        helper.wait10AndType(ZipCode, "1234");
        helper.wait10AndClick(ContinueButton);
        Thread.sleep(1000);
        helper.wait10AndClick(CancelButton);
        helper.findElementByXPath(ProductsTitle);
        Thread.sleep(1000);
    }

    @Test(priority=8)
    public void checkoutInfoEmptyFirstNameCredentialsValidation() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(AddToCartButton);
        helper.wait10AndClick(CartIcon);
        helper.findElementByXPath(CartItem);
        helper.wait10AndClick(CheckoutButton);
        helper.wait10AndType(FirstName, "");
        helper.wait10AndType(LastName, "Test");
        helper.wait10AndType(ZipCode, "1234");
        helper.wait10AndClick(ContinueButton);
        helper.findElementByXPath(EmptyFirstNameErrorMessage);
        Thread.sleep(1000);
    }

    @Test(priority=9)
    public void checkoutInfoEmptyLastNameCredentialsValidation() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(AddToCartButton);
        helper.wait10AndClick(CartIcon);
        helper.findElementByXPath(CartItem);
        helper.wait10AndClick(CheckoutButton);
        helper.wait10AndType(FirstName, "Test");
        helper.wait10AndType(LastName, "");
        helper.wait10AndType(ZipCode, "1234");
        helper.wait10AndClick(ContinueButton);
        helper.findElementByXPath(EmptyLastNameErrorMessage);
        Thread.sleep(1000);
    }

    @Test(priority=10)
    public void checkoutInfoEmptyZipPostalCodeCredentialsValidation() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(AddToCartButton);
        helper.wait10AndClick(CartIcon);
        helper.findElementByXPath(CartItem);
        helper.wait10AndClick(CheckoutButton);
        helper.wait10AndType(FirstName, "Test");
        helper.wait10AndType(LastName, "Test");
        helper.wait10AndType(ZipCode, "");
        helper.wait10AndClick(ContinueButton);
        helper.findElementByXPath(EmptyZipPostalCodeErrorMessage);
        Thread.sleep(1000);
    }
}
