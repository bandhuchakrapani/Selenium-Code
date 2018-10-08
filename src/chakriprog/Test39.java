package chakriprog;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test39 {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word\n");
		String x=sc.nextLine();
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		// launch site
		chakri.get("https://angularjs.org");
		chakri.manage().window().maximize();
		// wait for page ready
		WebDriverWait w=new WebDriverWait(chakri,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='yourName']")));
		chakri.findElement(By.xpath("//*[@ng-model='yourName']")).sendKeys(x);
		w.until(ExpectedConditions.textToBePresentInElement(By.xpath("(//*[contains(text(),'Hello')])[2]"),"Hello"+x+"!"));
		//close site
		chakri.close();

	}

}
