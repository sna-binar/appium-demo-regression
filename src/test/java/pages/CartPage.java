package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By getProceedToCheckoutBtn = AppiumBy.id("cartBt");

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getProceedToCheckoutBtn)).isDisplayed();
        driver.findElement(getProceedToCheckoutBtn).click();
    }
}
