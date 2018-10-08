package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test12 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		Thread.sleep(5000);
		// switch to frame
		chakri.switchTo().frame("iframeResult");
		// click on try it 
		chakri.findElement(By.xpath("//*[text()='Try it']")).click();
		// close alert
		chakri.switchTo().alert().dismiss();
		//close site
		chakri.close();
	}

}
