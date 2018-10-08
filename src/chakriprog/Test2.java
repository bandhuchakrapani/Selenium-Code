package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test2
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.ie.driver","D:\\softwaretesting\\iedriverserver.exe");
		InternetExplorerDriver chakri=new InternetExplorerDriver();
		chakri.get("http://www.google.co.in");
		Thread.sleep(5000);
		chakri.findElement(By.name("q")).sendKeys("gmail");
	}

}
