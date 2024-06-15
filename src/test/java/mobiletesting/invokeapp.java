package mobiletesting;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.options.UiAutomator2Options;
	import io.appium.java_client.service.local.AppiumDriverLocalService;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;

	import org.testng.annotations.Test;

	public class invokeapp {
		
		public AndroidDriver driver;
		public AppiumDriverLocalService service;
		
		@Test
		public void configureAppium() throws MalformedURLException
		{
			
			 UiAutomator2Options options = new UiAutomator2Options();
			 options.setDeviceName("Test");
			// options.setApp("C:\\Users\\rajso\\eclipse-workspace\\appium\\src\\test\\java\\resource\\ApiDemos-debug.apk");
			 //options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resource\\ApiDemos-debug.apk");
			options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resource\\universal.apk");
		    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			driver.quit();
			//service.stop();
		    
		}

	}

