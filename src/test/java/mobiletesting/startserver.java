package mobiletesting;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

public class startserver {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@Test
	public void configureAppium() throws MalformedURLException
	{
		//run appium server
		//aapiumjs is used to invoke appium server
		//AppiumServiceBuilder service= new AppiumServiceBuilder().withAppiumJS("C:\\Users\\rajso\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		 service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\rajso\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		 .withIPAddress("127.0.0.1").usingPort(4723).build();
		 
		 service.start();
				
		 UiAutomator2Options options = new UiAutomator2Options();
		 options.setDeviceName("Demo");
		// options.setApp("C:\\Users\\rajso\\eclipse-workspace\\appium\\src\\test\\java\\resource\\ApiDemos-debug.apk");
		 options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resource\\ApiDemos-debug.apk");
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		
	   //object Locator: xpath, id, className, accessbilityId, androidUIautomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();)
		driver.quit();
	    service.stop();
	    
	}

}

