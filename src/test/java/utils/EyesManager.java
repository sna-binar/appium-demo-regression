
package utils;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.BatchInfo;
import org.openqa.selenium.WebDriver;

public class EyesManager {
    private Eyes eyes;

    public EyesManager() {
        eyes = new Eyes();
        eyes.setApiKey("YOUR_API_KEY");  // Ganti dengan API key Applitools kamu
        eyes.setBatch(new BatchInfo("Appium Regression Tests"));
    }

    public Eyes getEyes(WebDriver driver, String testName) {
        eyes.open(driver, "MyDemo App", testName);
        return eyes;
    }

    public void closeEyes() {
        eyes.closeAsync();
    }

    public void abortEyesIfNotClosed() {
        eyes.abortIfNotClosed();
    }
}

