package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage extends BasePage {
    public static final By CATEGORIES = By.className("fsdDeptLink");
    public static final By PRODUCTS = By.className("s-image");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void goToRandomCategory() {
        int categorySize = this.waitForElements(CATEGORIES).size();
        ((WebElement)this.waitForElements(CATEGORIES).get(this.generateRandomNumber(categorySize))).click();
    }

    public void goToRandomProduct() {
        List<WebElement> products = this.waitForElements(PRODUCTS);
        if (products.isEmpty()) {
            this.driver.navigate().back();
            this.goToRandomCategory();
        }

        int productSize = products.size();
        ((WebElement)products.get(this.generateRandomNumber(productSize))).click();
    }
}