package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test27 {

	public static void main(String[] args) throws Exception

	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		// launch site
		chakri.get("http://www.jqueryui.com/slider");
		Thread.sleep(5000);
		chakri.manage().window().maximize();
		chakri.switchTo().frame(0);
		WebElement e1=chakri.findElement(By.xpath("//*[@id='slider']/span"));
		Actions a=new Actions(chakri);
		a.dragAndDropBy(e1, 200, 0).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e1, -200, 0).build().perform();
		Thread.sleep(5000);
		chakri.switchTo().defaultContent(); // back to page
		chakri.findElement(By.linkText("Vertical slider")).click();
		Thread.sleep(5000);
		chakri.switchTo().frame(0);
		WebElement e2=chakri.findElement(By.xpath("//*[@id='slider-vertical']/span"));
		a.dragAndDropBy(e2, 0, 100).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e2, 0, -100).build().perform();
		chakri.switchTo().defaultContent();
		//close site
		chakri.close();
		
	}

}
