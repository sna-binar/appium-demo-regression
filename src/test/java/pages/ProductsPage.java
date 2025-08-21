package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By getProductsTitle = By.xpath("//android.widget.TextView[@text='Products']");
    private By getSauceLabsBackpack = By.xpath("(//android.widget.ImageView[@content-desc='Product Image'])[1]");
    private By getAddToCartBtn = AppiumBy.id("cartBt");
    private By getCartBtn = AppiumBy.id("cartIV");


    public void clickSauceLabsBackpack() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getProductsTitle)).isDisplayed();
        WebElement product = driver.findElement(getSauceLabsBackpack);
        product.click();
    }

    public void clickAddToCartBtn() {
        WebElement product = driver.findElement(getAddToCartBtn);
        product.click();
    }

    public void clickCartBtn() {
        WebElement product = driver.findElement(getCartBtn);
        product.click();
    }
}