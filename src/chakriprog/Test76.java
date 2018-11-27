package chakriprog;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test76
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();
		chakri.get("http://www.gmail.com");
		chakri.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(chakri,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		// login with valid data
		chakri.findElement(By.name("identifier")).sendKeys("chakrapani078");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		chakri.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		chakri.findElement(By.name("password")).sendKeys("bandhuchakri");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		chakri.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[4]")));
		//chakri.findElement(By.xpath("//*[@class='bBe']")).click();
		//get expected count of mails in page
		int enoam=0;
		do
		{
			//get count of mails in page
			WebElement mbt=chakri.findElement(By.xpath("(//table)[4]"));
			List<WebElement> mails=mbt.findElements(By.tagName("tr"));
			int nomp=mails.size();
			//add count of mails in current page to total count
			enoam=enoam+nomp;
			// go to next page
			try
			{
				if(chakri.findElement(By.xpath("//*[@data-tooltip='Older']")).getAttribute("aria-label").equals("true"))
				{
					break; //terminate from loop
				}
			}
			catch(Exception ex)
			{
				chakri.findElement(By.xpath("//*[data-tooltip='Older']")).click();
				Thread.sleep(2000);
			}				
			}
		while(2>1);  // infinite loop
		{
			String temp=chakri.findElement(By.xpath("(//*[@data-tooltip='Newer'])/preceding::span[1]")).getText();
			int anoam=Integer.parseInt(temp);
			// validation
			System.out.println(enoam+" "+anoam );
			if(enoam==anoam)
			{
				System.out.println("Gmail count test passed");
		
			}
			else
			{
				System.out.println("Gmail count test failed");
			}
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Google Account'])[1]")));
				chakri.findElement(By.xpath("(//*[text()='Google Account'])[1]")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
				chakri.findElement(By.linkText("Sign out")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
				//close site
				chakri.close();
	       }
		}
}
