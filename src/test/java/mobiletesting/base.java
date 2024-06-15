package mobiletesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class base {
    
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void startAppiumService() {
        // Initialize the Appium service
        service = new AppiumServiceBuilder().usingAnyFreePort().build();
        service.start();
    }

    @AfterClass
    public void stopAppiumService() {
        // Stop the Appium service
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }

    @Test
    public void configureAppium() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Demo");
        options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resource\\ApiDemos-debug.apk");
        
        // Create the AndroidDriver instance and connect to the Appium server
        driver = new AndroidDriver(new URL(service.getUrl().toString()), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        
        // Quit the driver
        driver.quit();
    }
}
