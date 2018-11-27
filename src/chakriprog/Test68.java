package chakriprog;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test68 {

	public static void main(String[] args) throws Exception
	{
		// get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mobile number");
		String mbno=sc.nextLine();
		System.out.println("Enter criteria");
		String mbnoc=sc.nextLine();
		System.out.println("Enter password");
		String pwd=sc.nextLine();
		System.out.println("Enter password criteria");
		String pwdc=sc.nextLine();
		// launch site 
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();
		chakri.get("http://www.way2sms.com");
		WebDriverWait w=new WebDriverWait(chakri,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		// do login
		chakri.findElement(By.name("mobileNo")).sendKeys(mbno);
		chakri.findElement(By.name("password")).sendKeys(pwd);
		chakri.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
		chakri.switchTo().alert().accept();
		w.until(temp-> chakri.executeScript("return document.readyState;").equals("complete"));
		// validations
		if(mbno.length()==0 && chakri.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
		{
			System.out.println("Blank mobile no: Test passed");
		}
		else if(mbno.length()<10 && chakri.findElement(By.xpath("(//*[contains(text(),'Enter valid mobile number')])[1]")).isDisplayed())
				{
		           System.out.println("wrong size mobile no: Test passed");
	            }
		else if(pwd.length()==0 && chakri.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed())
				{
			System.out.println("blank password test passed");
				}
		else if(mbnoc.equals("invalid") && chakri.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
         {
			System.out.println("Invalid mbno: test passed");
		}
		else if(pwdc.equals("invalid") && chakri.findElement(By.xpath("(//*[contains(text(),Try Again')])[1]")).isDisplayed())
		{
			System.out.println("invalid pwd test passed");
		}
		else if(mbnoc.equals("valid") && pwdc.equals("valid") && chakri.findElement(By.xpath("//*[text()=SendSMS']")).isDisplayed())
		{
			System.out.println("valid data test passed");
		}
		else
		{
			SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			Date d=new Date();
			String fname=sf.format(d)+".png";
			File src=chakri.getScreenshotAs(OutputType.FILE);
			File dest=new File(fname);
			FileHandler.copy(src,dest);
			System.out.println("Login Test Failed");
		}
		// close site
		chakri.close();	
		}
	}

