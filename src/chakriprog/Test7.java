package chakriprog;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test7 {

	public static void main(String[] args) throws InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the browser name\n");
		String x=sc.nextLine();
		
		WebDriver driver=null;
		if(x.equals("chrome"))
				{
			System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
			driver=new ChromeDriver();	
				}
		else if(x.equals("ie"))
				{
				System.setProperty("webdriver.ie.driver","D:\\softwaretesting\\iedriverserver.exe");
		        driver=new InternetExplorerDriver();
	             }
	else if(x.equals("firefox"))
			{
		System.setProperty("webdriver.gecko.driver", "D:\\softwaretesting\\geckodriver.exe");
		driver=new FirefoxDriver();
			}
	else if(x.equals("opera"))
			{
		OperaOptions oo=new OperaOptions();
		oo.setBinary("C:\\Users\\Chakri Mittu\\AppData\\Local\\Programs\\Opera\\55.0.2994.37\\opera.exe");
	    System.setProperty("webdriver.opera.driver", "D:\\softwaretesting\\operadriver_win64\\operadriver.exe");
	    OperaDriver opera=new OperaDriver(oo);
			}	
	else 
	{
		System.out.println("Unknown Browser");
		System.exit(0);
		//close site
		driver.close();
	}
		}
}
  

