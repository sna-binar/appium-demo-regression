package pages;

import com.applitools.eyes.selenium.Eyes;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By getProductsTitle = By.xpath(" //android.widget.TextView[@text='Products']");
    private By getViewMenuButton = AppiumBy.accessibilityId("View menu");
    private By getLoginMenu = By.xpath("//android.widget.TextView[@text='Log In']");

    public void goToViewMenuPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getProductsTitle)).isDisplayed();
        WebElement viewMenuButton = driver.findElement(getViewMenuButton);
        viewMenuButton.click();
    }

    public void goToLoginPage() {
        WebElement loginMenu = driver.findElement(getLoginMenu);
        loginMenu.click();
    }

    public void visualCheckHomePage(Eyes eyes) {
        eyes.checkWindow("View Menu Page");
    }
}
