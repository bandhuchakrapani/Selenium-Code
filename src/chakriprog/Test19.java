package chakriprog;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test19 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.google.co.in");
		Thread.sleep(5000);
		// Delete all cookies
		chakri.manage().deleteAllCookies();
		// Launch site
		chakri.get("http://www.facebook.com");
		Thread.sleep(5000);
		// cookies testing 
		if(chakri.manage().getCookies().size()!=0)
		{
			System.out.println("Cookies Test Passed");
		}
		else
		{
			System.out.println("Cookies Test Failed");
		}
		//close site
		chakri.close();
	}

}
