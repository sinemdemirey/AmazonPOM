package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By EMAIL_TXT_BOX = By.id("ap_email");
    private static final By CONTINUE_BTN = By.cssSelector("span#continue");
    private static final By PASSWORD_TXT_BOX = By.id("ap_password");
    private static final By SIGN_IN_BTN = By.id("auth-signin-button");
    private static final String email = "";
    private static final String password = "";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void signIn() {
        this.sendStringKeys(EMAIL_TXT_BOX, email);
        this.click(CONTINUE_BTN);
        this.sendStringKeys(PASSWORD_TXT_BOX, password);
        this.click(SIGN_IN_BTN);
    }
}

