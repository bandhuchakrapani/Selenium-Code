package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test30
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.w3schools.com/css/css_tooltip.asp");
		Thread.sleep(5000);
		// Get tooltip via title attribute
		WebElement e1=chakri.findElement(By.linkText("JAVASCRIPT"));
		String x=e1.getAttribute("title");
		System.out.println(x);
		Thread.sleep(5000);
		// Move mouse pointer to an element for tooltip
		WebElement e2=chakri.findElement(By.xpath("(//*[@class='tooltip'])[1]"));
		Actions a=new Actions(chakri);
		a.moveToElement(e2).clickAndHold().build().perform();
		Thread.sleep(5000);
		WebElement e3=chakri.findElement(By.xpath("(//*[@class='tooltip'])[1]/span"));
		String y=e3.getText();
		System.out.println(y);
		a.release().build().perform();
		// close site
		chakri.close();
	}
}
