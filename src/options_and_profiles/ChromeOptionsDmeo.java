package options_and_profiles;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.BrowserHelper;

/*
 * chrome extensions are available in below folder in windows os
 * C:\Users\%USERNAME%\AppData\Local\Google\Chrome\User Data\Default\Extensions
 * 
 * Choose the extension and get the complete path with the version.
 * Copy the path and paste it into Chrome Pack Extension window to get the .crx extension file
 * Create a File class object with .crx file path
 * Use this File class objects in ChromeOptions class addExtensions method
 */

public class ChromeOptionsDmeo {
	
	public static void main(String[] args) {
//		openBrowser("chrome", "http://www.facebook.com");
		File chroPathExt  = new File("C:\\Users\\Uday Surya\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\glcimepnljoholdmjchkloafkggfoijh\\2.1.35_0.crx");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(chroPathExt);
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
	}

}
