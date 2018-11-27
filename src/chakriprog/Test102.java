package chakriprog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test102
{
	public static void main(String[] args) throws Exception
	{
		// open text file for data reading
		File f=new File("way2smstestdata.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		// create html report file
		ExtentReports er=new ExtentReports("W2SDDT.html",false);
		ExtentTest et=er.startTest("way2sms login Testing");
		// data driven testing
		ChromeDriver chakri=null;
		String l="";
		while((l=br.readLine())!=null)
		{
			String[] p=l.split(",");
			try
			{
				// Launch site
				System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
			    chakri=new ChromeDriver();
				chakri.get("http://www.way2sms.com");
				WebDriverWait w=new WebDriverWait(chakri,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
				// do login
				chakri.findElement(By.name("mobileNo")).sendKeys(p[0]);
				chakri.findElement(By.name("password")).sendKeys(p[2]);
				chakri.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
				Thread.sleep(5000);
				if(p[0].length()==0 && chakri.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank mobile no: Test passed");
				}
				else if(p[0].length()<10 && chakri.findElement(By.xpath("(//*[contains(text(),'Enter valid mobile number')])[1]")).isDisplayed())
						{
					et.log(LogStatus.PASS,"wrong size mobile no: Test passed");
			            }
				else if(p[2].length()==0 && chakri.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed())
						{
					et.log(LogStatus.PASS,"blank password test passed");
						}
				else if(p[1].equals("invalid") && chakri.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
		         {
					et.log(LogStatus.PASS,"Invalid mbno: test passed");
				}
				else if(p[1].equals("invalid") && chakri.findElement(By.xpath("(//*[contains(text(),Try Again')])[1]")).isDisplayed())
				{
					et.log(LogStatus.PASS,"invalid pwd test passed");
				}
				else if(p[1].equals("valid") && p[3].equals("valid") && chakri.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"valid data test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=chakri.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src,dest);
				 et.log(LogStatus.FAIL,"Login Test Failed"+et.addScreenCapture(fname));
				}
				// close site
				chakri.quit();;	
				}
			catch(Exception ex)
			{
				chakri.quit();
				et.log(LogStatus.ERROR,ex.getMessage());
			}
		}
		// save results and close text files
		br.close();
		fr.close();
		er.endTest(et);
		er.flush();
	}
}



		