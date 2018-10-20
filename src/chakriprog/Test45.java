package chakriprog;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test45 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
        chakri.get("http://www.seleniumhq.org");
        WebDriverWait w=new WebDriverWait(chakri,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		chakri.manage().window().maximize();
		// right click on link SWD
		WebElement e=chakri.findElement(By.linkText("Download"));
		Actions a=new Actions(chakri);
		a.contextClick(e).build().perform();
		Thread.sleep(5000);
		// automate win_menu(java robot(in jdk))
		Robot r=new Robot();
		for(int i=1;i<=2;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(5000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
