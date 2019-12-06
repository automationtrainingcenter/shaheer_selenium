package cookiehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookieLogin {

	WebDriver driver;
	WebDriverWait wait;
	
	public void storeCookieData(String fileName) {
		Set<Cookie> cookies = driver.manage().getCookies();
		try {
			File file = new File(".//cookiedata//"+fileName);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String str = "";
			for (Cookie cookie : cookies) {
				str += cookie.getName() + ";" + cookie.getDomain() + ";" + cookie.getPath() + ";" + cookie.getValue()
						+ ";" + cookie.getExpiry() + "\n";
			}
			bw.write(str);
			bw.flush();
			fw.flush();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadCookies(String fileName) throws Exception {
		File file = new File(".//cookiedata//"+fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			String[] values = line.split(";");
//			Wed Dec 25 12:45:16 IST 2019 -- E MMM dd HH:mm:ss z yyyy
			SimpleDateFormat format = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
			Date expiry = format.parse(values[4]);
			Cookie cookie = new Cookie(values[0], values[3], values[1], values[2], expiry);
			line = br.readLine();
			driver.manage().addCookie(cookie);
		}

		// navigate to the user home page url
		driver.get("http://automationpractice.com/index.php?controller=my-account");
	}


	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
	}

	public void closeBrowser() {
		driver.close();
	}

	
	public void login() throws InterruptedException {
		driver.findElement(By.cssSelector(".login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("sadhurla.keerthi@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("aadhya2016");
		driver.findElement(By.id("SubmitLogin")).click();
		storeCookieData("login.data");
	}
	
	// add a product to the cart
	public void addProductToCart() {
		// click on logo button
		driver.findElement(By.cssSelector("#header_logo img")).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("img[title *= 'T-shirts']"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title = 'Add to cart']"))).click();
		storeCookieData("cart.data");
	}
	
	// verify previously added product is there in cart or not
	public void cartContainsProducts() {
		try {
			loadCookies("cart.data");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public static void main(String[] args) throws Exception {
		CookieLogin obj = new CookieLogin();
		obj.launchBrowser();
		obj.cartContainsProducts();
		obj.closeBrowser();
//		obj.login();
//		obj.storeCookieData("login.data");
//		obj.loadCookies("cart.data");
//		Thread.sleep(3000);
//		obj.closeBrowser();
		
//		obj.addProductToCart();
	}

}
