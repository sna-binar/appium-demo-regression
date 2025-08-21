package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    String appPath = Paths.get(System.getProperty("user.dir"), "mydemoapp2.apk").toString();

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "12");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:app", appPath);
        caps.setCapability("appium:automationName", "UiAutomator2");

        URL proxy = new URL("http://localhost:8085");
        driver = new AndroidDriver(proxy, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
