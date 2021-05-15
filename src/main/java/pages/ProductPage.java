package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage extends BasePage {
    CategoryPage categoryPage;
    private static final By ADD_TO_LIST_BTN = By.id("wishlistButtonStack");
    private static final By VIEW_LIST_BTN = By.id("WLHUC_viewlist");
    private static final By ADD_TO_CART_BTN = By.id("add-to-cart-button");
    private static final By GO_TO_CART = By.id("nav-cart");
    private static final By ITEM_ADDED = By.id("huc-v2-order-row-confirm-text");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToList() {
        this.click(ADD_TO_LIST_BTN);
    }

    public void viewYourList() {
        this.click(VIEW_LIST_BTN);
    }

    public void addToCart() {
        if (!this.waitForElement(ADD_TO_CART_BTN).isDisplayed()) {
            this.driver.navigate().back();
            this.categoryPage.goToRandomProduct();
        }

        this.waitForElement(ADD_TO_CART_BTN).click();
    }

    public void goToCart() {
        Assert.assertTrue(this.waitForElement(ITEM_ADDED).isDisplayed());
        this.click(GO_TO_CART);
    }
}
