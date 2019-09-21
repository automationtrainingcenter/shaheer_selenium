package basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowserDemo {
	public static void main(String[] args) {
		// to launch any browser create BrowserDriver class object
		// to launch chrome browser create ChromeDriver class object
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		// here . represents project root folder
		ChromeDriver driver = new ChromeDriver();
		// open google application 
		driver.get("http://www.google.com");
		
		System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
		// to launch the firefox browser create FirefoxDriver class object
		FirefoxDriver fdriver  = new FirefoxDriver();
		// open facebook application
		fdriver.get("http://www.facebook.com");
	}

}
