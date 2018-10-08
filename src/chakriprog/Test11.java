package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test11 {
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.mercurytravels.co.in");
		Thread.sleep(5000);
		// Validate radiobutton
		chakri.findElement(By.partialLinkText("Flights")).click();
		Thread.sleep(5000);
		try
		{
			WebElement e=chakri.findElement(By.name("tripType"));
			if(e.isDisplayed())
			{
				System.out.println("Displayed");
				if(e.isEnabled())
				{
					System.out.println("Enabled");
				
					if(e.isSelected())
					{
						System.out.println("Selected");
					}
					else
					{
						System.out.println("Not Selected");
					}
				}
				else
				{
					System.out.println("Disabled");
				}
			}
			else
			{
				System.out.println("Hidden");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		// close site
		chakri.close();
				
			}
		
		
	}

