package radiobuttons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioBtnDemo {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
	
		//locating all radio buttons
		List<WebElement> radiosList=driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Total no of radio butons are: "+ radiosList.size());
		
		Thread.sleep(3000);
		//select only one radio button from the list
		for(int i=0;i<radiosList.size();i++)
		{
			String radioName=radiosList.get(i).getAttribute("value");
			System.out.println(radioName);
			if(radioName.equals("Male"))
			{
				radiosList.get(i).click();
			}
			
		}
		
	
	
	}

}
