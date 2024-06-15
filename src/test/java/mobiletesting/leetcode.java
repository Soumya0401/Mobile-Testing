package mobiletesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class leetcode 
{
	WebDriver driver;
	
	@BeforeTest
	public void open_browser()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://leetcode.com/accounts/login/");
	}
	@Test
	public void login_page()
	{
		driver.findElement(By.id("id_login")).sendKeys("rajsoumya135@gmail.com");
		driver.findElement(By.id("id_password")).sendKeys("Technofine@123");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		//driver.findElement(By.xpath("//span[@class='cb-lb-t']")).click();
		driver.findElement(By.id("signin_btn")).click();
	}

}
