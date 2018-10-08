package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 {

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
		// click compose
		chakri.findElement(By.xpath("//*[text()='Compose']")).click();
		Thread.sleep(5000);
		// filling mail
		chakri.findElement(By.name("to")).sendKeys("bandhusudhakar7@gmail.com");
		chakri.findElement(By.name("subjectbox")).sendKeys("Wishes");
		chakri.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Happy Independence Day\n This is automated message through chakrapani\n");
		Thread.sleep(5000);
		chakri.findElement(By.xpath("//*[contains(@data-tooltip,'Send')]")).click();
		Thread.sleep(5000);
		chakri.findElement(By.xpath("//div[contains(@aria-label,'Google Account')]")).click();
		Thread.sleep(5000);
		chakri.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//close site
		chakri.close();
	}

}
