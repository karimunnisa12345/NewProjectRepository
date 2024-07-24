package checkboxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxesDemo {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(3000);
		
		//locate all checkboxes 
		List<WebElement> checkboxesList=driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Total no of checkboxes are: "+ checkboxesList.size());
		
		//select one checkbox
		for(int i=0;i<checkboxesList.size();i++)
		{
			String checkboxesName=checkboxesList.get(i).getAttribute("value");
			if(checkboxesName.equals("Movies") || checkboxesName.equals("Hockey"))
			{
				checkboxesList.get(i).click();
			}
		}

	}

}
