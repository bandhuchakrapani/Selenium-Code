package chakriprog;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Test69 {

	public static void main(String[] args) throws Exception 
	{
		// file html file
		ExtentReports er = new ExtentReports("Google Login Result.html", false);
		ExtentTest et = er.startTest("Gmail Login Test");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Id");
		String userid = sc.nextLine();
		System.out.println("Enter User Id Criteria");
		String useridc = sc.nextLine();
		String pwd = "";
		String pwdc = " ";
		if(useridc.equals("valid"))
		{
		System.out.println("Enter Password");
		pwd = sc.nextLine();
		System.out.println("Enter Password Criteria");
		pwdc = sc.nextLine();
		// Launch gmail site
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();
		chakri.get("http://www.gmail.com");
		chakri.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(chakri,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		// Userid Testing
		chakri.findElement(By.name("identifier")).sendKeys(userid);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		chakri.findElement(By.xpath("//*[text()='Next']")).click();
		chakri.findElement(By.name("password")).sendKeys(pwd);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		chakri.findElement(By.xpath("//*[text()='Next']")).click();
		Test69 obj=new Test69();  //object for current class
		if(userid.length()==0)
		{
		try
		{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enter an email or phone number']")));
		et.log(LogStatus.PASS, "Blank UserID Test Case PASS");
		}
		catch(Exception e)
		{
		String x = obj.screenshot(chakri);
		et.log(LogStatus.FAIL, "Blank User Id FAILED" + e.getMessage() +
		et.addScreenCapture(x));
		}
		}
		else if(useridc.equals("invalid"))
		{
		try
		{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Google Account')])[2]"))).isDisplayed();
		et.log(LogStatus.PASS, "Invalid User ID Test Case PASS");
		}
		catch(Exception ex)
		{
		String x = obj.screenshot(chakri);
		et.log(LogStatus.FAIL, "Invalid User Id FAILED" + ex.getMessage() +
		et.addScreenCapture(x));
		}
		}
		else
		{
		try
		{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		et.log(LogStatus.PASS, "Valid User ID Test Case PASS");
		chakri.findElement(By.name("password")).sendKeys(pwd);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));

		chakri.findElement(By.xpath("//*[text()='Next']")).click();
		if(pwd.length()==0)
		{
		try
		{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enter a password']")));
		et.log(LogStatus.PASS, "Blank Password Test Case PASS");
		}
		catch(Exception e)
		{
		String x = obj.screenshot(chakri);
		et.log(LogStatus.FAIL, "Blank Password Test Case FAILED" + e.getMessage() +
		et.addScreenCapture(x));
		}
		}
		else if(pwdc.equals("invalid"))
		{
		try
		{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Wrong password')]")));
        et.log(LogStatus.PASS, "Inavlid password Test Passed");
	    }
		catch(Exception e)
		{
		String x = obj.screenshot(chakri);
		et.log(LogStatus.FAIL, "Invalid Password Test Case FAILED" + e.getMessage() +et.addScreenCapture(x));
		}
		}
		else
		{
		try
		{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Compose')]")));
		et.log(LogStatus.PASS, "Valid Password Test Case PASS");
		}
		catch(Exception e)
		{
		String x = obj.screenshot(chakri);
		et.log(LogStatus.FAIL, "Valid Password Test Case FAILED" + e.getMessage() +et.addScreenCapture(x));
		}
		}
		}
		catch(Exception e)
		{
		String x = obj.screenshot(chakri);
		et.log(LogStatus.FAIL, "Valid UserID Test Case FAILED" + e.getMessage() +
		et.addScreenCapture(x));
		}
		}
		
		// Close site
		chakri.close();
		// Save Files
		er.endTest(et);
		er.flush();
		}
	}
	private String screenshot(ChromeDriver chakri) throws Exception
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy-mm-hh-ss");
		Date d = new Date();
		String sc = sdf.format(d)+".png";
		File src = chakri.getScreenshotAs(OutputType.FILE);
		File dest= new File(sc);
		FileHandler.copy(src, dest);
		return sc;
	
	}
}