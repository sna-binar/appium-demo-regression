package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By getFullNameTextField = AppiumBy.id("fullNameET");
    private By getAddressLine1TextField = AppiumBy.id("address1ET");
    private By getCityTextField = AppiumBy.id("cityET");
    private By getZipCodeTextField = AppiumBy.id("zipET");
    private By getCountryTextField = AppiumBy.id("countryET");
    private By getToPaymentBtn = AppiumBy.id("cartBt");
    private By getReviewOrderBtn = AppiumBy.id("paymentBtn");


    public void enterFullName(String fullName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFullNameTextField)).isDisplayed();
        WebElement fullNameInput = driver.findElement(getFullNameTextField);
        fullNameInput.clear();
        fullNameInput.sendKeys(fullName);
    }

    public void enterAddress(String address) {
        WebElement addressInput = driver.findElement(getAddressLine1TextField);
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void enterCity(String city) {
        WebElement cityInput = driver.findElement(getCityTextField);
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterZipCode(String zipCode) {
        WebElement zipCodeInput = driver.findElement(getZipCodeTextField);
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);
    }

    public void enterCountry(String country) {
        WebElement countryInput = driver.findElement(getCountryTextField);
        countryInput.clear();
        countryInput.sendKeys(country);
    }

    public void clickProceedToReviewOrder() {
        driver.findElement(getToPaymentBtn).click();
    }

    public void clickProceedToPayment() {
        driver.findElement(getReviewOrderBtn).click();
    }
}
