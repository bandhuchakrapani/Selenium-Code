package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test28 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.google.co.in");
		Thread.sleep(5000);
		// Fill text box with data to get cache/auto-complete
		chakri.findElement(By.name("q")).sendKeys("steve jobs");
		Thread.sleep(5000);
		// select 4th item in cache
		Actions a=new Actions(chakri);
		for(int i=0;i<=4;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(2000);
		}
		a.sendKeys(Keys.ENTER).build().perform();
		// close site
		chakri.close();
	}

}
