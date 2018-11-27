package chakriprog;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test92
{
	public void finalize()
	{
		System.out.println("Testing completed");
	}
	public static void main(String[] args) throws Exception
	{
		Test92 obj=new Test92();
		obj=null;
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.google.co.in");
		Thread.sleep(5000);
		//finalize method can run automatically
		System.gc();
	
	}

}
