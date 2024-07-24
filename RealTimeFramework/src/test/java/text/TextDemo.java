package text;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextDemo {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		//fetch all normal text 
		List<WebElement> normalText=driver.findElements(By.tagName("p"));
		System.out.println("Total noof normal text is: "+ normalText.size());
		for(int i=0;i<normalText.size();i++)
		{
			System.out.println(normalText.get(i).getText());
		}
	
		//fetch all bold text 
		List<WebElement> boldText=driver.findElements(By.tagName("b"));
		System.out.println("Total noof bold text is: "+ boldText.size());
		for(int i=0;i<boldText.size();i++)
		{
			System.out.println(boldText.get(i).getText());
		}
	
	
	
	
	
	}

}
