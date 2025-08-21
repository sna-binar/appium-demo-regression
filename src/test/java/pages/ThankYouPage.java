package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ThankYouPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public ThankYouPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By getCheckoutCompleteText = AppiumBy.id("completeTV");
    private By getThankYouText = AppiumBy.id("thankYouTV");
    private By getContinueShoppingBtn = AppiumBy.id("shoopingBt");

    public boolean isCheckoutCompleteDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCheckoutCompleteText)).isDisplayed();
        return driver.findElement(getCheckoutCompleteText).isDisplayed();
    }

    public boolean isThankYouForYourOrderDisplayed() {
        return driver.findElement(getThankYouText).isDisplayed();
    }

    public boolean isContinueShoppingButtonDisplayed() {
        return driver.findElement(getContinueShoppingBtn).isDisplayed();
    }
}
