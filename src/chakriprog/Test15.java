package chakriprog;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test15 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.sentia.in");
		Thread.sleep(5000);
		chakri.findElement(By.xpath("//*[contains(@src,'pay_online.jpg')]")).click();
		Thread.sleep(5000);
		chakri.findElement(By.xpath("(//*[contains(@href,'transportfeesentia1')])[1]")).click();
		Thread.sleep(5000);
		chakri.findElement(By.xpath("(//*[contains(@href,'paymentOptionsGroup')])[3]")).click();
		Thread.sleep(5000);
	    // Get browser windows / tabs handles
		ArrayList<String> a=new ArrayList<String>(chakri.getWindowHandles());
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
		// switch to 2nd window/tab and close
		chakri.switchTo().window(a.get(1));
		chakri.close();
	
		chakri.switchTo().window(a.get(0));
		chakri.close();
		Thread.sleep(5000);
		chakri.switchTo().window(a.get(2));
		chakri.close();
	}

}
