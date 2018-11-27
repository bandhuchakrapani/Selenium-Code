package chakriprog;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test77 {

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
		int enourm=0;
		do
		{
		// get count of mails in current page
			WebElement mbt=chakri.findElement(By.xpath("(//table)[4]/tbody"));
			List<WebElement> mails=mbt.findElements(By.tagName("tr"));
			int nomp=mails.size();
			for(int i=1;i<=nomp;i++)
			{
				WebElement e=chakri.findElement(By.xpath("(//table)[4]/tbody/tr["+i+"]/td[5]/div[1]"));
				chakri.executeScript("var v=arguments[0].textContent;window.alert(v);",e);
		        String x=chakri.switchTo().alert().getText();
		        chakri.switchTo().alert().dismiss();
				if(x.contains("unread"))
				{
					enourm=enourm+1;
				}
				Thread.sleep(1000);
			}
			// go to next page
			try
			{
				if(chakri.findElement(By.xpath("//*[@data-tooltip='Older']")).getAttribute("aria-disabled").equals("true"));
				{
					break; // if it is last page terminate
				}
			}
			catch(Exception ex)
			{
				chakri.findElement(By.xpath("//*[@data-tooltip='Older']")).click();
				Thread.sleep(10000); // to load next mail box
			}
		}
		while(2>1);
			System.out.println(enourm);
			//Get actual count of unread mails
			String a=chakri.findElement(By.xpath("//*[contains(@data-tooltip,'Inbox')]")).getAttribute("data-tooltip");
			String b=a.substring(7, a.length()-1);
			int anourm=Integer.parseInt(b);
			// validation
if(enourm==anourm)
{
	System.out.println("unread mails count test passed");
		}
else
{
	System.out.println("unread mails count test failed");
}
// do logout
w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Google Account'])[1]")));
chakri.findElement(By.xpath("(//*[text()='Google Account'])[1]")).click();
w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
chakri.findElement(By.linkText("Sign out")).click();
w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
//close site
chakri.close();

	}

}
