package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test25 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://jqueryui.com/droppable");
		chakri.manage().window().maximize();
		Thread.sleep(5000);
		WebElement e=chakri.findElement(By.xpath("//*[text()='Download']"));
		Actions a=new Actions(chakri);
		a.contextClick(e).build().perform();
	}

}
