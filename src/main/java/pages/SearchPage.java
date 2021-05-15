package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {
    private static final By PAGINATION_NEXT_BTN = By.cssSelector("[class='a-last']");
    private static final By PRODUCTS = By.className("a-size-medium");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void goToNextPage() {
        this.waitForElement(PAGINATION_NEXT_BTN).click();
    }

    public void clickOnProduct() {
        ((WebElement)this.waitForElements(PRODUCTS).get(2)).click();
    }
}
