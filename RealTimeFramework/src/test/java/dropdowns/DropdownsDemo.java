package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownsDemo {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(3000);
		
		//fetch all values from skills dropdown
		//select any one skill from skills dropdown
		WebElement skillsDropdown=driver.findElement(By.xpath("//select[@id='Skills']"));
		List<WebElement> skillsList=skillsDropdown.findElements(By.tagName("option"));
		System.out.println("Total noof skills are: "+ skillsList.size());
		
		skillsDropdown.click();
		for(WebElement slist:skillsList)   // for(weblement reference:list)
		{
			String skillsName=slist.getText();
			System.out.println(skillsName);	
			
			if(skillsName.equals("APIs"))
			{
				slist.click();			
			}
		}
		
		//using getOption() from Select class
		//to automate dropdown, we have Select predefined class in selenium
		Select obj=new Select(skillsDropdown);
		List<WebElement> skillsOptions=obj.getOptions();
		System.out.println("Total noof skills are: "+ skillsOptions.size());
		
		//how to count and locate all the dropdowns
		List<WebElement> ndropdowns=driver.findElements(By.tagName("select"));
		System.out.println(ndropdowns.size());
		
		// how to select single value from particular dropdown
		// sendKeys or Select class - selectByIndex,selectByvisibleText,selectByvalue
		//by using select class.
		WebElement yeardp=driver.findElement(By.id("yearbox"));
		Select sc=new Select(yeardp);
		sc.selectByIndex(3);
		Thread.sleep(3000);
		sc.selectByValue("1923");
		Thread.sleep(3000);
		sc.selectByVisibleText("1930");
		Thread.sleep(3000);
		
		//by using sendkeys()
		yeardp.sendKeys("1950");
		
		

	}

}
