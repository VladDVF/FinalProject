package common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    public static WebDriver driver = null;

    public void wait10AndClick(By xpath) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();
    }

    public void wait10AndType(By xpathForStatedTextBox, String stringToType) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions
                .elementToBeClickable(xpathForStatedTextBox));
        WebElement statedTextBox = findElementByXPath(xpathForStatedTextBox);
        Assert.assertNotNull(statedTextBox);
        statedTextBox.sendKeys(stringToType);
    }

    public WebElement findElementByXPath(By xPathToSearchFor) {
        try {
            return driver.findElement(xPathToSearchFor);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean elementNotDisplayed(By xpath) {
        try {
            WebElement element = driver.findElement(xpath);
            return !element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickAndVerifyUrlOnDifferentTab(By xpath, String expectedUrl) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();

        // Switch to the newly opened tab
        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Verify that current url is equal with the expected one
        WebDriverWait urlWaiter = new WebDriverWait(driver, 10);
        urlWaiter.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);

        // Close the new tab and switch back to the original tab
        driver.close();
        driver.switchTo().window(originalHandle);
    }

    public void clickAndVerifyUrl(By xpath, String expectedUrl) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();

        // Verify that current url is equal with the expected one
        WebDriverWait urlWaiter = new WebDriverWait(driver, 10);
        urlWaiter.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);
    }
}
