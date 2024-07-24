package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		//Thread.sleep(3000);
		//implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		TakesScreenshot ts=(TakesScreenshot)driver; //downcasting webdriver reference to takesscreenshot reference
		File googleimg=ts.getScreenshotAs(OutputType.FILE);
		
		Files.copy(googleimg, new File("C:\\Users\\91970\\Desktop\\screenshots\\google.png"));
		
		//if we create driver by using ChromeDriver class.
		
		ChromeDriver driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("https://www.google.com/");
		Thread.sleep(3000);
		File img=driver1.getScreenshotAs(OutputType.FILE);
		Files.copy(img, new File("C:\\Users\\91970\\Desktop\\screenshots\\image.jpeg"));
		
		
		
		
		
		
		
		
		
		
	}

}
