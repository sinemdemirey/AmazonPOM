package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {
    public static final By EMPTY_CART = By.cssSelector(".a-spacing-mini.a-spacing-top-base");
    public static final By DELETE = By.cssSelector("input[data-action='delete']");
    public static final By CHECKOUT_BTN = By.id("sc-buy-box-ptc-button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCheckout() {
        this.click(CHECKOUT_BTN);
        this.driver.navigate().back();
    }

    public void deleteItem() {
        this.click(DELETE);
        Assert.assertTrue(this.waitForElement(EMPTY_CART).isDisplayed(), "We have items in cart to delete.");
    }
}