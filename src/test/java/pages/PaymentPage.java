package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public PaymentPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By getFullNameTextField = AppiumBy.id("nameET");
    private By getCardNumberTextField = AppiumBy.id("cardNumberET");
    private By getExpirationDateTextField = AppiumBy.id("expirationDateET");
    private By getSecurityCodeTextField = AppiumBy.id("securityCodeET");
    private By getReviewOrderBtn = AppiumBy.id("paymentBtn");
    private By getPlaceOrderBtn = AppiumBy.id("paymentBtn");


    public void enterFullName(String fullName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getReviewOrderBtn)).isDisplayed();
        WebElement fullNameInput = driver.findElement(getFullNameTextField);
        fullNameInput.clear();
        fullNameInput.sendKeys(fullName);
    }

    public void enterCardNumber(String cardNumber) {
        WebElement cardNumberInput = driver.findElement(getCardNumberTextField);
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNumber);
    }

    public void enterExpirationDate(String expirationDate) {
        WebElement expirationDateInput = driver.findElement(getExpirationDateTextField);
        expirationDateInput.clear();
        expirationDateInput.sendKeys(expirationDate);
    }

    public void enterSecurityCode(String securityCode) {
        WebElement securityCodeInput = driver.findElement(getSecurityCodeTextField);
        securityCodeInput.clear();
        securityCodeInput.sendKeys(securityCode);
    }

    public void clickReviewOrderButton() {
        driver.findElement(getReviewOrderBtn).click();
    }

    public void clickPlaceOrderButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPlaceOrderBtn)).isDisplayed();
        driver.findElement(getPlaceOrderBtn).click();
    }
}

