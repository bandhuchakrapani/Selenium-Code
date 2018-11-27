package chakriprog;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test101
{
	public static void main(String[] args)
	{
		// create a hashmap
		HashMap<String,String> pwds=new HashMap<String, String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Test Data size:");
		int noiteration=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noiteration;i++)
		{
			System.out.println("Enter PWD");
			String x=sc.nextLine();
			System.out.println("Enter PWD Criteria");
			String y=sc.nextLine();
			pwds.put(x,y);		}
		// create html report file
		ExtentReports er=new ExtentReports("GmailDDT.html",false);
		ExtentTest et=er.startTest("Gmail Pwd Testing");
		// data driven testing
		ChromeDriver chakri=null;
		for(Map.Entry<String,String> e:pwds.entrySet())
		{
			try
			{
				// Launch site
				System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
			
				chakri.get("http://www.gmail.com");
				WebDriverWait w=new WebDriverWait(chakri,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
				// Userid and click next
				chakri.findElement(By.name("identifier")).sendKeys("chakrapani078");
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
				chakri.findElement(By.xpath("//*[text()='Next']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
				chakri.findElement(By.name("password")).sendKeys(e.getKey());
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
				chakri.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(5000);
				// validations 
				if(e.getKey().length()==0 && chakri.findElement(By.xpath("(//*[contains(text(),'Enter a password')])[2]")).isDisplayed())
                {
	            et.log(LogStatus.PASS,"Blank PWD test passed");
                }
				else if(e.getValue().equalsIgnoreCase("Invalid") && chakri.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
                {
	            et.log(LogStatus.PASS,"Invalid PWD test passed");
                }
				else if(e.getValue().equalsIgnoreCase("Valid") && chakri.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
                {
					et.log(LogStatus.PASS,"Valid PWD test passed");
                }
				else 
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=chakri.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src,dest);
					et.log(LogStatus.FAIL,"UID test failed"+et.addScreenCapture(fname));
				}
				// close site
				chakri.close();
				}
			catch(Exception ex)
			{
				et.log(LogStatus.ERROR,ex.getMessage());
			 }
		}
		// save results
		er.endTest(et);
		er.flush();
	}

}
