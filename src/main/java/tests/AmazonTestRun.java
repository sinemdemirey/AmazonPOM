package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import org.openqa.selenium.WebDriver;

public class AmazonTestRun {
    String driverPath = "/Users/sinemdemirey/PycharmProjects/drivers/chromedriver";
    String baseUrl = "https://www.amazon.com/";
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    CategoryPage categoryPage;
    ProductPage productPage;
    CartPage cartPage;

    public AmazonTestRun() {
    }

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", this.driverPath);
        this.driver = new ChromeDriver();
        this.driver.get(this.baseUrl);
        this.driver.manage().window().maximize();
    }

    @Test
    public void testAmazon() {
        this.homePage = new HomePage(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.productPage = new ProductPage(this.driver);
        this.cartPage = new CartPage(this.driver);
        this.categoryPage = new CategoryPage(this.driver);
        Assert.assertEquals(this.driver.getCurrentUrl(), this.baseUrl, "You are not in homepage.");
        this.homePage.goToLogin();
        this.loginPage.signIn();
        this.homePage.seeAllCategories();
        this.categoryPage.goToRandomCategory();
        this.categoryPage.goToRandomProduct();
        this.productPage.addToCart();
        this.productPage.goToCart();
        this.cartPage.goToCheckout();
        this.cartPage.deleteItem();
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
