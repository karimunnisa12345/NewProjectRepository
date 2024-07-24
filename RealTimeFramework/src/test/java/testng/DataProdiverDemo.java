package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProdiverDemo {
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test(dataProvider = "testData")
	public void loginOperation(String un,String pwd) throws InterruptedException
	{
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		driver.navigate().to("https://www.saucedemo.com/");
		Thread.sleep(3000);
	}	
	//to check this loginoperation with different values, we will use dataprovider now	
	@DataProvider(name="testData")
	public Object[][] getData()
	{
		// to store data in row and column wise, use array 2D concept		
		Object data[][]=new Object[3][2]; // 3 rows and 2 columns
		
		data[0][0]="standard_user"; //correct un
		data[0][1]="secret_sauce"; //correct pwd
		
		data[1][0]="admin";  // incorrect un
		data[1][1]="secret_sauce"; // correct pwd
		
		data[2][0]="standard_user"; //correct un
		data[2][1]="admin123"; // incorrect pwd
		
		return data;	
	 }
	

}
