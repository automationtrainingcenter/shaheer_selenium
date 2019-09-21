package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Navigation is an inner interface in WebDriver interface and this interface 
 * contains several methods to work with browser navigations like back, forward 
 * and refresh
 * 
 * WebDriver interface provides navigate() which returns Navigation interface reference
 * using that reference we can call methods of Navigation interface
 */

public class NavigationCommands {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// create Navigation interface reference
		Navigation nav = driver.navigate();
		
		// to(String url) : is used to navigate to a url which is specified as string arg
		nav.to("http://www.google.com");
		Thread.sleep(2000);
		
		// to(URL arg): is used to navigate to a url which is specified as URL class arg
		try {
			nav.to(new URL("http://www.gmail.com"));
		} catch (MalformedURLException e) {
			System.out.println("invalid url format");
		}
		
		Thread.sleep(2000);
		
		// back(): is used to navigate to the back page in browser history
		nav.back();
		Thread.sleep(2000);

		// forward(): is used to navigate to the front page in the browser history
		nav.forward();
		Thread.sleep(2000);
		
		// refresh(): is used to refresh the current web page
		nav.refresh();
		Thread.sleep(2000);
		
//		driver.get(driver.getCurrentUrl());
		
		driver.close();
		
	}

}
