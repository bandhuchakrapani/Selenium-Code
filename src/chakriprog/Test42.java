package chakriprog;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test42 {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Text");
		String x=sc.nextLine();
		// convert text into voice
		System.setProperty("mbrola.base", "D:\\softwaretesting\\mbr301d");
	    VoiceManager vm=VoiceManager.getInstance();
	    Voice v=vm.getVoice("mbrola_us1"); 
        v.allocate();
        v.speak(x);
        v.deallocate();
	}

}
