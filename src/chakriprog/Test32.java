package chakriprog;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test32 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		chakri.manage().window().maximize();
		Thread.sleep(5000);
		// open drop down (developed using <div> tag)
		WebElement e=chakri.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown selection multiple')])[1]"));
		Actions a=new Actions(chakri);
		a.click(e).build().perform();
		Thread.sleep(5000);
		// get items and display
		List<WebElement> l=chakri.findElements(By.xpath("//div[@class='ui fluid dropdown selection multiple active visible']"));
		Thread.sleep(5000);
		System.out.println("No of items is:"+l.size());
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		Thread.sleep(5000);
		// close site
		chakri.close();

	}

}
