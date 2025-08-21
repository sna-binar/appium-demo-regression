package pages;

import com.applitools.eyes.selenium.Eyes;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By getUsernameField = AppiumBy.id("nameET");
    private By getPasswordField = AppiumBy.id("passwordET");
    private By getLoginBtn = AppiumBy.id("loginBtn");

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getUsernameField)).isDisplayed();
        WebElement usernameInput = driver.findElement(getUsernameField);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(getPasswordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(getLoginBtn).click();
    }

    public void visualCheckLoginPage(Eyes eyes) {
        eyes.checkWindow("Login Page");
    }
}

