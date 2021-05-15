package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingListPage extends BasePage {
    private static final By DELETE_ITEM = By.cssSelector("span[data-action='reg-item-delete']");

    public ShoppingListPage(WebDriver driver) {
        super(driver);
    }

    public void deleteItem() {
        this.waitForElement(DELETE_ITEM).click();
    }
}
