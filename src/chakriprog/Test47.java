package chakriprog;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test47 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();
		//Launch gmail
		chakri.get("http://www.gmail.com");
		chakri.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(chakri,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		chakri.findElement(By.name("identifier")).sendKeys("chakrapani078");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		chakri.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		chakri.findElement(By.name("password")).sendKeys("bandhuchakri");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		chakri.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		// click compose
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
		chakri.findElement(By.xpath("//*[text()='Compose']")).click();
		Thread.sleep(5000);
		// filling mail
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
		chakri.findElement(By.name("to")).sendKeys("chakrapani078@gmail.com");
		chakri.findElement(By.name("subjectbox")).sendKeys("Wishes");
		chakri.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Happy Birthday sir\n This is automated message through chakrapani\n");
		Thread.sleep(5000);
		chakri.findElement(By.xpath("//*[@name='Filedata']/preceding::div[2]")).click();
		// automate file upload window (Java Robot)
		Thread.sleep(10000);// file upload 
		StringSelection x=new StringSelection("C:\\Users\\Chakri Mittu\\Pictures\\Chakri Images\\2013-10-13 21.24.20.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		// click +
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	    // wait until file upload
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='vq']")));
		// wait until file upload complete
		w.until(ExpectedConditions.attributeContains(By.xpath("//*[@class='vq']"), "role", "button"));
		chakri.findElement(By.xpath("//*[contains(@data-tooltip,'Send')]")).click();
		Thread.sleep(5000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Message sent')]")));
		chakri.findElement(By.xpath("//*[@id='gb']/div[2]/div[3]/div/div[2]/div/a")).click();
		Thread.sleep(5000);
		chakri.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//close site
		chakri.close();

	}

}
