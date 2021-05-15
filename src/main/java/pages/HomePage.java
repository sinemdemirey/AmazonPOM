package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String searchKeyword = "samsung";
    private static final By ACCOUNT_BTN = By.className("nav-long-width");
    private static final By SEARCH_BOX = By.id("twotabsearchtextbox");
    private static final By SEARCH_SUBMIT_BTN = By.className("nav-search-submit");
    private static final By HAMBURGER_MENU = By.id("nav-hamburger-menu");
    private static final By FULL_STORE = By.xpath("//a[contains(text(),'Full Store Directory')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLogin() {
        this.click(ACCOUNT_BTN);
    }

    public void searchForProduct() {
        this.sendStringKeys(SEARCH_BOX, "samsung");
        this.click(SEARCH_SUBMIT_BTN);
    }

    public void seeAllCategories() {
        this.click(HAMBURGER_MENU);
        this.click(FULL_STORE);
    }
}

