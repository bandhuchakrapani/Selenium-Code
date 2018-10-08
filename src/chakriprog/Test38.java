package chakriprog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test38 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		chakri.manage().window().maximize();
		// wait for page ready
		FluentWait w=new FluentWait(chakri).withTimeout(30, TimeUnit.SECONDS)
		        .pollingEvery(5, TimeUnit.SECONDS);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='rcMainTable']/tbody")));
		chakri.manage().window().maximize();
		chakri.findElement(By.linkText("6")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		//close site
		chakri.close();
	

	}

}
