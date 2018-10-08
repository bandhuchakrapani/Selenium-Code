package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test23 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Thread.sleep(5000);
		// switch to frame
		chakri.switchTo().frame("iframeResult");
		WebElement e=chakri.findElement(By.name("cars"));
		Select s=new Select(e);
		Actions a=new Actions(chakri);
		a.keyDown(Keys.CONTROL).click(s.getOptions().get(3)).click(s.getOptions().get(0)).click(s.getOptions().get(2)).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		s.deselectAll();
		Thread.sleep(5000);
		a.keyDown(Keys.CONTROL).click(s.getOptions().get(3)).click(s.getOptions().get(0)).click(s.getOptions().get(2)).keyUp(Keys.CONTROL).build().perform();
		s.deselectByIndex(2);
		Thread.sleep(5000);
		s.deselectByVisibleText("Volvo");
		Thread.sleep(5000);
		//close site
		chakri.close();
	}

}
