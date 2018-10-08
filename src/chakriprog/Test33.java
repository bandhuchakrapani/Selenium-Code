package chakriprog;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test33 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://www.google.co.in");
		chakri.manage().window().maximize();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor) chakri;
		js.executeScript("document.getElementById('lst-ib').style.border='2px solid blue';");
		Thread.sleep(5000);
		
	}

}
