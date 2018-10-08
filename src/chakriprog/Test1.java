package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 
{
	public static void main(String[] args) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
	ChromeDriver chakri=new ChromeDriver();	
	chakri.get("http://www.google.co.in");
	Thread.sleep(5000);
	chakri.findElement(By.name("q")).sendKeys("gmail");
	}
}
