package chakriprog;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test16 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.gmail.com");
		Thread.sleep(5000);
		chakri.navigate().forward();
		Thread.sleep(5000);
		chakri.navigate().to("http://www.facebook.com");
		Thread.sleep(5000);
		chakri.navigate().back();
		Thread.sleep(5000);
	    chakri.close();
	}

}
