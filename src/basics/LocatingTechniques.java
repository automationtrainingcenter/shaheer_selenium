package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingTechniques {
	/*
	 * findElement() -> is used to locate an element in the web page using locator
	 * information. If the element is not located using the given locator info this
	 * method throws NoSuchElementException.
	 */

	/*
	 * findElements() -> is used to locate multiple elements in the web page using
	 * locator information. This method returns a list of elements. if no element is
	 * not located then this method returns an empty list.
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		/*
		 * Selenium provides 8 ways to locate an element in the current web page These
		 * ways are available as static methods in By class. all these 8 methods in By
		 * class accepts a string argument and returns a By class reference
		 */
		

	}
}
