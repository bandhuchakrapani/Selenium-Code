package chakriprog;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test36 {

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://semantic-ui.com/modules/dropdown.html");
		chakri.manage().window().maximize();
		Thread.sleep(5000);
		List<WebElement> il=chakri.findElements(By.xpath("(//*[@class='ui dopdown'])[1]/div[2]/div"));
		System.out.println(il.size());
		for(int i=0;i<il.size();i++)
		{
			chakri.executeScript("var x=arguments[0].textContent; window.alert(x),;il.getSize(i)");
			String y=chakri.switchTo().alert().getText();
			System.out.println(y);
		}
			Thread.sleep(5000);
			chakri.switchTo().alert().dismiss();
			chakri.close();
			
		}
	}

