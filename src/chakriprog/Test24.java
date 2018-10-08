package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test24 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://www.seleniumhq.org");
		chakri.manage().window().maximize();
		Thread.sleep(5000);
		//close login
		chakri.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();
		Thread.sleep(5000);
		// Move mouse pointer to an element
		WebElement e=chakri.findElement(By.xpath("//*[text()='Women']"));
		Actions a=new Actions(chakri);
		a.moveToElement(e).build().perform();
		Thread.sleep(5000);
		//close site
		chakri.close();
	}

}
