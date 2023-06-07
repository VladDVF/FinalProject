package pages;

import common.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BasePage {
    protected WebDriver driver;
    private String baseURL = "https://saucedemo.com";
    public BasePage() {
        //default constructor
    }
    public BasePage(WebDriver driver){
        this.driver = driver;

    }
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dorof\\Desktop\\Project\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

        // Set the driver in the Helper class
        Helper.driver = driver;
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
