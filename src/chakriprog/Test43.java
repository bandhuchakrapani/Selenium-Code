package chakriprog;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class Test43 {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your text\n");
		String x=sc.nextLine();
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeOptions oo=new ChromeOptions();
		oo.addArguments("--use-fake-ui-for-media-stream=1");
		ChromeDriver chakri=new ChromeDriver(oo);	
		// launch site
		chakri.get("https://www.google.com");
		chakri.manage().window().maximize();
		// wait for page ready
		WebDriverWait w=new WebDriverWait(chakri,40);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		// click on mic icon
		chakri.findElement(By.id("gsri_ok0")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("spchb")));
		// send voice
		System.setProperty("mbrola.base","D:\\\\softwaretesting\\\\mbr301d");
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();
		//close site
		chakri.close();

	}

}
