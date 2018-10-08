package chakriprog;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test35 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://www.google.co.in");
		chakri.manage().window().maximize();
		Thread.sleep(5000);
        chakri.executeScript("alert('Hi this is chakrapani');");
	}

}
