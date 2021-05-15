package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage {
    public final WebDriver driver;
    WebDriverWait wait;
    static WebDriverWait waitLess;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 35L);
        waitLess = new WebDriverWait(driver, 5L);
    }

    public WebElement waitForElement(By locator) {
        return (WebElement)this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> waitForElements(By locator) {
        return (List)this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void click(By locator) {
        this.waitForElement(locator).click();
    }

    public void sendStringKeys(By locator, String keyword) {
        this.waitForElement(locator).sendKeys(new CharSequence[]{keyword});
    }

    public int generateRandomNumber(int upperBound) {
        Random rnd = new Random();
        return rnd.nextInt(upperBound);
    }
}
