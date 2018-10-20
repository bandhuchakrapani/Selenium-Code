package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test44 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();
		// launch site
				chakri.get("https://www.google.com");
				chakri.manage().window().maximize();
				// wait for page ready
				WebDriverWait w=new WebDriverWait(chakri,10);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
				// get details before focus
				WebElement e=chakri.findElement(By.xpath("(//*[text()='Gmail'])[1]"));
				// get details before focus
				String o1=e.getCssValue("opacity");
				String td1=e.getCssValue("text-decoration");
				// focus on element
				Actions a=new Actions(chakri);
				a.moveToElement(e).clickAndHold().build().perform();
				// get details once focus
				String o2=e.getCssValue("opacity");   //transparency to element background
				String td2=e.getCssValue("text-decoration");
				a.release().build().perform();
				chakri.close();
				System.out.println(o1+" "+o2);
				System.out.println(td1+" "+td2);
				
				
				
		
	}

}
