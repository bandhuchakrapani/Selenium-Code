package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test26 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://jqueryui.com/droppable");
		chakri.manage().window().maximize();
		Thread.sleep(5000);
		chakri.switchTo().frame(0);
		// drag and drop
		WebElement e1=chakri.findElement(By.id("draggable"));
		WebElement e2=chakri.findElement(By.id("droppable"));
		Actions a=new Actions(chakri);
		a.dragAndDrop(e1,e2).build().perform();
		Thread.sleep(5000);
		chakri.switchTo().defaultContent();
	}

}
