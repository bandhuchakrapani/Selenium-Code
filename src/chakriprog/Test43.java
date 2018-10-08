package chakriprog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test43 {

	public static void main(String[] args) 
	{
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver(op);	
		chakri.get("https://www.redbus.in/");
		chakri.manage().window().maximize();
		// wait for page ready
		WebDriverWait w=new WebDriverWait(chakri,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='monthTitle'][contains(text(),'Oct 2018')]")));
		//td[contains(text(),'Nov 2018')]
	
		//close site

	}

}
