package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test4 {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.gecko.driver", "D:\\softwaretesting\\geckodriver.exe");
		FirefoxDriver chakri=new FirefoxDriver();
		chakri.get("http://www.google.co.in");
		Thread.sleep(5000);
		chakri.findElement(By.name("q")).sendKeys("gmail");
	}

}
