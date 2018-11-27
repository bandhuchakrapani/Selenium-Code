package chakriprog;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test29 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.google.co.in");
		Thread.sleep(5000);
		// Fill text box with data to get cache/auto-complete
		chakri.findElement(By.name("q")).sendKeys("cricbuzz");
		Thread.sleep(5000);
		// Get count items in cache
		List<WebElement> l=chakri.findElements(By.xpath("//*[@role='listbox']/li"));
		int cs=l.size()-2;
		// search for a required items in cache
		Actions a=new Actions(chakri);
		int flag=0;
		for(int i=0;i<=cs;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			String x=chakri.findElement(By.name("q")).getAttribute("value");
			if(x.equalsIgnoreCase("cricbuzz asia cup"))
			{
				a.sendKeys(Keys.ENTER).build().perform();
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("No item matched");
		}
		else
		{
			System.out.println("Item found and selected");
		}
		// close site
		chakri.close();
	}
}