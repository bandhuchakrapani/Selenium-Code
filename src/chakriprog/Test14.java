package chakriprog;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test14 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();
		//Launch gmail
		chakri.get("http://www.gmail.com");
		Thread.sleep(5000);
		chakri.findElement(By.name("identifier")).sendKeys("chakrapani078");
		chakri.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		chakri.findElement(By.name("password")).sendKeys("bandhuchakri");
		chakri.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		// get count of mails in mailbox table
		List<WebElement> rl=chakri.findElements(By.xpath("(//table)[4]/tbody/tr"));
		int x=rl.size();
		System.out.println(x);
		List<WebElement> cl=rl.get(0).findElements(By.tagName("td"));
		int y=cl.size();
		System.out.println(y);
		//do logout
		chakri.findElement(By.xpath("//div[contains(@aria-label,'Google Account')]")).click();
		Thread.sleep(5000);
		chakri.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//close site
		chakri.close();
		

	}

}
