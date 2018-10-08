package chakriprog;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test21 {

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
		List<WebElement> l=s.getOptions();
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
	//close site
	chakri.close();
	}
}
