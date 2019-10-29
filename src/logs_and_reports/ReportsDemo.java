package logs_and_reports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.GenericHelper;
import utilities.ScreenshotHelper;

public class ReportsDemo {
	static WebDriver driver;
	static ExtentHtmlReporter reporter;
	static ExtentReports reports;
	static ExtentTest test;

	// open browser
	public static void openBrowser() {
		test = reports.createTest("open browser test");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/home.aspx");
		test.log(Status.INFO, "browser navigated to " + driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(Status.PASS, "test case passed");
	}

	// login
	public static void login() {
		test = reports.createTest("login test");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		test.log(Status.INFO, "located email field and typed Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		test.log(Status.INFO, "located password and typed Admin");
		driver.findElement(By.id("login")).click();
		test.log(Status.INFO, "locted click button and clicked");
		test.pass("test case passed");

	}

	// role creation with valid data
	public static void roleCreation() {
		test = reports.createTest("role creation test");
		driver.findElement(By.cssSelector("a[href='Admin_Roles_details.aspx']")).click();
		test.log(Status.INFO, "located roles button and clicked on it");
		driver.findElement(By.id("btnRoles")).click();
		test.log(Status.INFO, "located new roles button and clicked on it");
		driver.findElement(By.id("txtRname")).sendKeys("newrolehahaha");
		test.log(Status.INFO, "located new role and typed newrolehahaha");
		driver.findElement(By.id("txtRDesc")).sendKeys("role descriptions");
		test.log(Status.INFO, "located role description and typed role descriptions");
		Select roleType = new Select(driver.findElement(By.id("lstRtypeN")));
		roleType.selectByVisibleText("E");
		test.log(Status.INFO, "located roel type and selected option E");
		driver.findElement(By.id("btninsert")).click();
		test.log(Status.INFO, "located submit button and clicked");
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		test.log(Status.INFO, "alert came with text as " + text);
		alert.accept();
		if (text.toLowerCase().contains("new role123")) {
			System.out.println("test case passed");
			test.log(Status.PASS, "test case passed");
		} else {
			System.out.println("test case failed");
			// capture the screenshot
			String imgPath = ScreenshotHelper.captureScreenshot(driver, "screenshots", "rolecreation");
			System.out.println(imgPath);
			try {
				test.log(Status.FAIL, "test case failed" + test.addScreenCaptureFromPath(imgPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// logout
	public static void logout() {
		test = reports.createTest("logout test");
		driver.findElement(By.cssSelector("a[href='http://primusbank.qedgetech.com']")).click();
		test.log(Status.INFO, "located logout button and clicked");
		test.log(Status.PASS, "logout test passed");
	}

	// close browser
	public static void closeBrowser() {
		test = reports.createTest("close browser");
		test.log(Status.INFO, "close browser test");
		driver.close();
		test.log(Status.PASS, "close browser test passed");
	}

	public static void main(String[] args) {
		// create an object of Report format class i.e ExtentHtmlReporter
		reporter = new ExtentHtmlReporter(GenericHelper.getFilePath("reports", "report2.html"));
		// create an object of ExtentReports class object
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reporter.config().setDocumentTitle("Primus Bank");
		reporter.config().setTheme(Theme.DARK);
		openBrowser();
		login();
		roleCreation();
		logout();
		closeBrowser();
		reports.flush();
	}
}
