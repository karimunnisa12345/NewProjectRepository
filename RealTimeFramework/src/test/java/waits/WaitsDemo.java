package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		// i want to wait upto gmail link gets click
		//WebElement gmailLink=driver.findElement(By.linkText("Gmail"));		
		
		//WebElement headset=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/a/div/div/div[1]/img"));
	
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""
		+ "//*[@id='container']/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[1]"
		+ "/div/div/div/a/div/div/div[1]/img")));
		
		
		
		
		
	}

}
