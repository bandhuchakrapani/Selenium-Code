package chakriprog;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test51 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://www.google.co.in");
		chakri.manage().window().maximize();
		ExtentReports er=new ExtentReports("path.html,true");
		ExtentTest et=er.startTest("Title for test");
		//Take current date and time as filename
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
		String fname=f.format(d)+".png";
		// get screenshot
		File src=chakri.getScreenshotAs(OutputType.FILE);
		File dest=new File(fname);
		FileHandler.copy(src, dest);
		// attach to extent reports html file
		et.log(LogStatus.FAIL,"Title Test failed"+ et.addScreenCapture(fname));
		
		
	}

}
