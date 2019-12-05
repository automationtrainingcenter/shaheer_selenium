package cookiehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieLogin {
	
	WebDriver driver;
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void storeCookieData() {
		Set<Cookie> cookies = driver.manage().getCookies();
		
		try {
			File file = new File(".//cookiedata//login.data");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String str = "";
			for(Cookie cookie : cookies) {
				str  += cookie.getName()+";"+cookie.getDomain()+";"+cookie.getPath()+";"+cookie.getValue()+";"+cookie.getExpiry()+"\n";
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
	
	public void loginWithOutCookies() throws InterruptedException {
		driver.findElement(By.cssSelector(".login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("sadhurla.keerthi@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("aadhya2016");
		driver.findElement(By.id("SubmitLogin")).click();
		storeCookieData();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		CookieLogin obj = new CookieLogin();
		obj.launchBrowser();
		obj.loginWithOutCookies();
		obj.closeBrowser();
	}

}
