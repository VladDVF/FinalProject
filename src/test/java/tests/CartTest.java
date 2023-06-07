package tests;

import common.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;

public class CartTest extends BasePage {
    Helper helper = new Helper();

    By Username = By.xpath("//input[@placeholder=\"Username\"]");
    By Password = By.xpath("//input[@placeholder=\"Password\"]");
    By LoginButton = By.xpath("//input[@name=\"login-button\"]");
    By WebsiteLogo = By.xpath("//div[@class='app_logo']");
    By AddToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By CartIcon = By.xpath("//a[@class='shopping_cart_link']");
    By CartItem = By.xpath("//div[@class='cart_item_label']");
    By RemoveButton = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    By ContinueShoppingButton = By.xpath("//button[@name='continue-shopping']");
    By ProductsTitle = By.xpath("//*[contains(text(),'Products')]");
    By BurgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");
    By LogoutButton = By.xpath("//a[@id='logout_sidebar_link']");

    @Test(priority=2)
    public void successfullyAddToCart() throws InterruptedException {
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(AddToCartButton);
        helper.wait10AndClick(CartIcon);
        helper.findElementByXPath(CartItem);
        Thread.sleep(1000);
    }

    @Test(priority=3)
    public void successfullyRemoveFromCart() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(AddToCartButton);
        helper.wait10AndClick(CartIcon);
        helper.wait10AndClick(CartItem);
        helper.wait10AndClick(RemoveButton);
        Thread.sleep(1000);
        helper.elementNotDisplayed(CartItem);
    }

    @Test(priority=4)
    public void successfullyContinueShopping() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(AddToCartButton);
        helper.wait10AndClick(CartIcon);
        helper.findElementByXPath(CartItem);
        Thread.sleep(1000);
        helper.wait10AndClick(ContinueShoppingButton);
        Thread.sleep(1000);
        helper.findElementByXPath(ProductsTitle);
    }

    @Test(priority=5)
    public void itemsRemainedAddedToCartAfterLogoutLogin() throws InterruptedException {
        setUp();
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        Thread.sleep(1000);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(AddToCartButton);
        helper.wait10AndClick(CartIcon);
        helper.findElementByXPath(CartItem);
        helper.wait10AndClick(BurgerMenu);
        helper.wait10AndClick(LogoutButton);
        Thread.sleep(1000);
        helper.wait10AndType(Username, "standard_user");
        helper.wait10AndType(Password, "secret_sauce");
        helper.wait10AndClick(LoginButton);
        helper.findElementByXPath(WebsiteLogo);
        helper.wait10AndClick(CartIcon);
        Thread.sleep(1000);
        helper.findElementByXPath(CartItem);
    }
}
