package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAnnotations {
	WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("BeforeSuite will execute before the execution of all the testcases.");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("AfterSuite will execute after exeuction of all testcaes");	
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("BeforeTest will execute before the execution of multiple classes.");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("AfterTest will execute after the execution of multiple classes.");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		//System.out.println("Beforeclass will execute before execution of any test method");
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException
	{
	//	System.out.println("AfterClass will execute after execution of all the test method");		
		Thread.sleep(3000);
		driver.close();
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("beforemethod will execute before exeuction of each test method");
	}
	@Test
	public void searchOperation()
	{
		driver.findElement(By.id("APjFqb")).sendKeys("selenium",Keys.ENTER);
	}
	
	@Test
	public void gmailOperation()
	{
		driver.findElement(By.linkText("Gmail")).click();
		driver.navigate().back();
	}
		
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
		System.out.println("aftermethod will execute after exeuction of each test method");
	}
	




}
