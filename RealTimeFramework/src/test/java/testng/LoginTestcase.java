package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(ListenerClass.class)
public class LoginTestcase {

	WebDriver driver;
		
	@Parameters("appURL")
	@BeforeTest
	public void setUp(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Parameters({"username","password"})
	@Test(priority=1)
	public void loginOperation(String un,String pwd)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority=2)
	public void validateLoginByURL()  
	{
		String actualURL=driver.getCurrentUrl();
		String expURL="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index1" ;
		/*if(actualURL.equals(expURL))
		{
			System.out.println("Login successfull");
		}
		else
		{
			System.out.println("Login Unsuccessfull");
		}
		*/
		
		Assert.assertEquals(actualURL, expURL, "Login Validation By URL Failed.." );
		System.out.println("Hard Assertion Remaining stmts");
		
	}
	
	@Test(priority=3,invocationCount = 2,dependsOnMethods = "validateLoginByURL")   // this test method will execute 2 times
	public void validateLoginByText()
	{
		String actualText=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		String expText="Dashboard1";
		/*if(actualText.equals(expText))
		{
			System.out.println("Login Success..");
		}
		else
		{
			System.out.println("Login Unsuccess");
		}*/
		//Assert.assertEquals(actualText, expText,"Login Validation By Text Failed..");
		//System.out.println("Remaining stmts");
	
	//applying softassertion 
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualText, expText, "Logiin validation by text failed..");
		
		System.out.println("Soft Assertion Remaining stmts");
		sa.assertAll();
	
	
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
}
