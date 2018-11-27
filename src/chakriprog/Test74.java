package chakriprog;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test74 {

	public static void main(String[] args) throws Exception
	{
		ExtentReports er=new ExtentReports("Googleres.html",false);
		ExtentTest et=er.startTest("Gmail results title Testing");
		//Get data from keyboard 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();
		chakri.get("http://www.google.co.in");
		chakri.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(chakri,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		chakri.findElement(By.name("q")).sendKeys(x,Keys.ESCAPE);
		chakri.findElement(By.name("btnK")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
		// validations
		while(2>1)
		{
			String t=chakri.getTitle();
			if(!t.contains(x))
			{
				// get screenshot
		   SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		   Date d=new Date();
		   String fname=sf.format(d)+".png";
		   File src=chakri.getScreenshotAs(OutputType.FILE);
		   File dest=new File(fname);
		   FileHandler.copy(src,dest);
		  et.log(LogStatus.FAIL, "Google title test failed"+et.addScreenCapture(fname));
		  //terminate from loop
		  break;
			}
			// go to homepage
			try
			{
				if(chakri.findElement(By.xpath("//*[text()='Next']")).isDisplayed())
				{
					chakri.findElement(By.xpath("//*[text()='Next']")).click();
				}
			}
			catch(Exception ex)
			{
				et.log(LogStatus.PASS, "Google test passed");
				break; //terminate from infinite loop 
			}
		}
		// close site
		chakri.close();
		//save results
		er.endTest(et);
		er.flush();		
	}

}
