package sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utilities.GenericHelper;

public class SikuliDemoOne {
	public static void main(String[] args) {
		Pattern chrome = new Pattern(GenericHelper.getFilePath("images", "chrome.PNG"));
		Pattern addressBar = new Pattern(GenericHelper.getFilePath("images", "addressbar.PNG"));
		Pattern email = new Pattern(GenericHelper.getFilePath("images", "email.PNG"));
		Pattern password = new Pattern(GenericHelper.getFilePath("images", "password.PNG"));
		Pattern login = new Pattern(GenericHelper.getFilePath("images", "login.PNG"));
		Pattern close = new Pattern(GenericHelper.getFilePath("images", "close.PNG"));
		
		Screen screen = new Screen();
		try {
			screen.find(chrome).click();
			Thread.sleep(2000);
			screen.find(addressBar).type("http://www.facebook.com"+Key.ENTER);
			Thread.sleep(5000);
			screen.find(email);
			screen.type(email, "sunshine");
			screen.find(password);
			screen.type(password, "selenium");
			Thread.sleep(2000);
			screen.find(login).click();
			Thread.sleep(3000);
			screen.find(close).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
