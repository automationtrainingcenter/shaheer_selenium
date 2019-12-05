package cookiehandling;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieDemo {
	/*
	 * to work with cookies we have use Options interface
	 */
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
		driver.manage().window().maximize();
		
		// get all the cookies and print on the console
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName()+"\t"+cookie.getValue()+"\t"+cookie.getDomain()+"\t"+cookie.getPath()+"\t"+cookie.getExpiry());
		}
		
		System.out.println("before deleting cookies "+cookies.size());
		driver.manage().deleteAllCookies();
		
		cookies = driver.manage().getCookies();
		
		System.out.println("after deleting cookies "+cookies.size());
		
		driver.close();
	}

}
