package logs_and_reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
/*
 * To work with logs using WebDriverEventListner use the following steps
 * 1. create a Listener class which will implement WebDriverEventListener interface
 * 2. create an Object of EventFiringWebDriver class object by giving WebDriver object reference
 * 3. create an Object of Listener class we created in step 1
 * 4. register listener class object with EventFiringWebDriver class object
 */

public class LogsDemo {

	static WebDriver wdriver;
	static EventFiringWebDriver driver;

	// open browser
	public static void openBrowser() {
		System.out.println("open browser test case started".toUpperCase());
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		wdriver = new ChromeDriver();
		// create an object of EventFiringWebDriver class
		driver = new EventFiringWebDriver(wdriver);
		// create an object of MyListner class
		MyListener listener = new MyListener();
		// register Mylistener class object to EventFiringWebDriver class object
		driver.register(listener);
		driver.get("http://primusbank.qedgetech.com/home.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("open browser test case ended".toUpperCase());
	}

	// login
	public static void login() {
		System.out.println("\n\nlogin test case started".toUpperCase());
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		System.out.println("login test case ended".toUpperCase());
	}

	// role creation with valid data
	public static void roleCreation() {
		System.out.println("\n\nrole creation test case started".toUpperCase());
		driver.findElement(By.cssSelector("a[href='Admin_Roles_details.aspx']")).click();
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys("newrolehahaha");
		driver.findElement(By.id("txtRDesc")).sendKeys("role descriptions");
		Select roleType = new Select(driver.findElement(By.id("lstRtypeN")));
		roleType.selectByVisibleText("E");
		driver.findElement(By.id("btninsert")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		if (text.toLowerCase().contains("new role")) {
			System.out.println("test case passed");
		} else {
			System.out.println("test case failed");
		}
		System.out.println("role creation test case ended".toUpperCase());
	}

	// logout
	public static void logout() {
		System.out.println("\n\nlogout test case started".toUpperCase());
		driver.findElement(By.cssSelector("a[href='http://primusbank.qedgetech.com']")).click();
		System.out.println("logout test case ended".toUpperCase());
	}

	// close browser
	public static void closeBrowser() {

		driver.close();
	}

	public static void main(String[] args) {
		openBrowser();
		login();
		roleCreation();
		logout();
		closeBrowser();
	}

}
