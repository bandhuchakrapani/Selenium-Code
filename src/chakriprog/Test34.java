package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test34 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://semantic-ui.com/modules/dropdown.html");
		chakri.manage().window().maximize();
		Thread.sleep(5000);
		// scroll to bottom
		chakri.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(5000);
		// scroll to top
		chakri.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(5000);
		Thread.sleep(5000);
		WebElement e=chakri.findElement(By.xpath("(//*[text()='Multiple Selection'])[2]"));
		
		chakri.executeScript("arguments[0].scrollIntoView()",e);
		Thread.sleep(5000);
		chakri.close();
	}

}
