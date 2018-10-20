package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Test49 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("https://www.youtube.com");
		chakri.manage().window().maximize();
		// wait for page ready
		WebDriverWait w=new WebDriverWait(chakri,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		// search video(swd)
		chakri.findElement(By.id("search")).sendKeys("naam hai tera- remix (aap ka suroor) - himesh reshammiya");
		chakri.findElement(By.xpath("(//button[@aria-label='Search'])[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@aria-label,'Naam Hai Tera- Remix (Aap Ka Suroor)')])[1]")));
		chakri.findElement(By.xpath("(//*[contains(@aria-label,'Naam Hai Tera- Remix (Aap Ka Suroor)')])[1]")).click();
		//skip ad(sikuli)
		Thread.sleep(10000);
        Screen s=new Screen();
        if(s.exists("skipad.png")!=null)
        {
        	s.click("skipad.png");
        }
        //pause video sikulix
        s.mouseMove(200,200); //pointer on video body
        s.click("pause.png"); 
        
        // play video(sikulix)
        Thread.sleep(5000);
        s.mouseMove(200,200);//pointer on video body
        s.click("play.png");
        Thread.sleep(5000);
         //decrease volume
        s.mouseMove(200,200); //pointer on video body
        s.click("sound.png");
        Match e=s.find("volume.png");
        int x=e.getX();
        int y=e.getY();
        Location l1=new Location(x-50,y);
        s.dragDrop(e, l1);
        Thread.sleep(5000);
        // increase volume
        Location l2=new Location(x-50,y);
        s.dragDrop(e, l2);
        Thread.sleep(5000);
        
        s.mouseMove(200,200); //pointer on video body
        s.click("maximize.png"); 
        // close site
        chakri.close();
	   }
}
