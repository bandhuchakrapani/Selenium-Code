package chakriprog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Test5
{
	public static void main(String[] args)
	{
	System.setProperty("webdriver.chrome.driver","D:\\softwaretesting\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	// launching site
	driver.get("http://newtours.demoaut.com");
	// registration page
    driver.findElement(By.linkText("REGISTER")).click();
	driver.findElement(By.name("firstName")).sendKeys("Chakrapani");
	driver.findElement(By.name("lastName")).sendKeys("Bandhu");
	driver.findElement(By.name("phone")).sendKeys("1235014789");
	driver.findElement(By.name("userName")).sendKeys("chakrapani078@gmail.com");
	driver.findElement(By.name("address1")).sendKeys("hyderguda");
	driver.findElement(By.name("address2")).sendKeys("attapur");
	driver.findElement(By.name("city")).sendKeys("hyderabad");
	driver.findElement(By.name("state")).sendKeys("telangana");
	driver.findElement(By.name("postalCode")).sendKeys("500048");
	// drop-down 
	WebElement e=driver.findElement(By.name("country"));
	Select s=new Select(e);
	s.selectByVisibleText("INDIA");
	// further elements
	driver.findElement(By.name("email")).sendKeys("chakrapani078@gmail.com");
	driver.findElement(By.name("password")).sendKeys("chakri@1201");
	driver.findElement(By.name("confirmPassword")).sendKeys("chakri@1201");
	driver.findElement(By.name("register")).click();
	// close site
	driver.close();
	}
}


