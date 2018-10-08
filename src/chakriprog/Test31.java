package chakriprog;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test31 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		chakri.manage().window().maximize();
		Thread.sleep(5000);
		// open drop down (developed using <div> tag)
		WebElement e=chakri.findElement(By.xpath("(//*[contains(@class,'ui selection dropdown')])[1]"));
		Actions a=new Actions(chakri);
		a.click(e).build().perform();
		Thread.sleep(5000);
		// get items and display
		List<WebElement> il=chakri.findElements(By.xpath("(//*[contains(@class,'ui selection dropdown')])[1]/child::*[4]/div"));
		System.out.println("No of items is:"+il.size());
		for(int i=0;i<il.size();i++)
		{
			System.out.println(il.get(i).getText());
		}
		// select 2nd item
		a.click(il.get(1)).build().perform();
		Thread.sleep(5000);
		// close site
		chakri.close();
	}

}
