package TestComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.swing.plaf.basic.BasicFileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage l;
	
	
	
	@BeforeMethod
	public void preConditions()
	{
		String Browser= System.getProperty("browser")!=null?System.getProperty("browser"):"Chrome";
		if(Browser.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		}
		
		else
		{
			driver = new EdgeDriver();
		}
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
	
	public String takeScreenShot(String testcase, WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("./target/"+testcase+".png");
		FileUtils.copyFile(src, des);
		return "./target/\"+testcase+\".png";
		
	}

}
