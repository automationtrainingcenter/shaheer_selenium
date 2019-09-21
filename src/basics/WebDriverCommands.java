package basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommands {
	public static void main(String[] args) {
		/*
		 * this program explains methods of WebDriver interface
		 */
		// set the System property for chromedriver.exe path
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");

		// launch Chrome browser by giving object reference to the WebDriver interface
		WebDriver driver = new ChromeDriver();

		// get(String url) it accepts a string argument which is url of the application
		// we want to navigate
		driver.get("http://www.facebook.com");

		/*
		 * getTitle() returns String value which is title of the current web page title
		 * of the web page is inner text of the title tag in head tag. inner text is the
		 * text in between opening and closing tag
		 */
		String title = driver.getTitle();
		System.out.println("tilte of the page is " + title);
		/*
		 * getCurrentUrl() return string value which is url of the current web page
		 */
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current url of the page is " + currentUrl);

		/*
		 * getPageSource() returns string value which is complete source code of the
		 * current web page
		 */
		String pageSource = driver.getPageSource();
		System.out.println("page source code contains given text "
				+ pageSource.contains("Facebook helps you connect and share with the people in your life."));

		/*
		 * getWindowHandle() returns string value which is unique id of the browser
		 * window/ tab opened by the driver instance
		 */
		String windowHandle = driver.getWindowHandle();
		System.out.println("id of the browser window is " + windowHandle);

		/*
		 * getWindowHandles() returns a java.util.Set of String values which are unique
		 * ids of each and every window opened by the driver instance This method is
		 * used to switch the driver focus from one window to another window opened by
		 * driver instance
		 */
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());

		/*
		 * findElement(By arg) returns a WebElement interface reference this method will
		 * locate an element in the current web page based on the locating technique we
		 * specified using 'By' class and stores in a WebElement reference. If no
		 * element is present in the page with locating technique then this method will
		 * throw NoSuchElementException
		 */
		By id = By.id("u_0_m");
		WebElement firstNameEle = driver.findElement(id);
//		WebElement firstNameEle = driver.findElement(By.id("u_0_m"));

		/*
		 * findElements(By arg) returns a java.util.List of WebElement type this method
		 * will locate either zero or more elements in the current web page based on the
		 * locating technique we specified using 'By' class and store in
		 * List<WebElement>. if no element is present in the page with locating
		 * technique then this method will return a List of size 0.
		 */
		By tagName = By.tagName("input");
		List<WebElement> inputTags = driver.findElements(tagName);
		System.out.println("number of input tags are " + inputTags.size());

		/*
		 * close() which will close the current browser window
		 */
		driver.close();
		/*
		 * quit() which will close all the browser windows opened by the driver instance
		 */
		driver.quit();

	}

}
