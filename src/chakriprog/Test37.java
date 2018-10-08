package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test37 {

	public static void main(String[] args) 
	{
			System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
			ChromeDriver chakri=new ChromeDriver();	
			chakri.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
			chakri.manage().window().maximize();
			// wait for page ready
			WebDriverWait w=new WebDriverWait(chakri,10);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='rcMainTable']/tbody")));
			chakri.manage().window().maximize();
			chakri.findElement(By.linkText("6")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.className("raDiv")));
			//close site
			chakri.close();
	}

}
