package TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage l;
	
	@BeforeMethod
	public void preConditions()
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		l = new LoginPage(driver);
		l.goToPage();
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.quit();
	}

}
