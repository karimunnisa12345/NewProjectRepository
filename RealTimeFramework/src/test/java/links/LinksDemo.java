package links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksDemo {

	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.linkText("Gmail")).click();
		driver.navigate().back();
		
		//fetch the text of gmail from that page.
		
		String gmailtext=driver.findElement(By.linkText("Gmail")).getText();
		System.out.println(gmailtext);
		
		//fetch all the links text in that google webpage.
	List<WebElement> linksList=driver.findElements(By.tagName("a"));			
	//list is a interfacei n hava, used to store multiple elements of any type at a time.
	//linksList now contains all the links detials 
	//[Gmail,Images,Hindi,Telugu,About,Advertising,etcc...] 
	//  0      1      2      3    4  ,......
	
	for(int i=0;i<linksList.size();i++) // size is a method from List interface.
	{     
		// i=0;i<20; 
		System.out.println(linksList.get(i).getText());
		
		//linksList.get(0).getText() -> Gmail
		//i=1;1<20
		//linksList.get(1).getText() -> Images
	}
	
	
		//check google img is present or not in that webpage.
		WebElement googleimg=driver.findElement(By.xpath("//img[@src='/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png']"));
		
		if(googleimg.isDisplayed()) // true
		{
			System.out.println(googleimg.getAttribute("src"));
		}
		else
		{
			System.out.println("google logo is not present");
		}
		
		//driver.findElement(By.partialLinkText("Gma")).click();
		
		List<WebElement> imagesList=driver.findElements(By.tagName("img"));
		for(int i=0;i<imagesList.size();i++)
		{
			System.out.println(imagesList.get(i).getAttribute("src"));
		}
		
		
		
		
	}
}
