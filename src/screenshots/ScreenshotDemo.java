package screenshots;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import utilities.BrowserHelper;
import utilities.GenericHelper;

public class ScreenshotDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		/*
		 * Selenium provides getScreenshotAs() in TakesScreenshot interface
		 * this interface is implemented by RemoteWebDriver class which is the implementation 
		 * class of WebDriver class
		 * so to call getScreenshotAs() simply type cast WebDriver object reference to TakesScreenshot
		 * reference 
		 */
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(GenericHelper.getFilePath("screenshots", "amazon.png"));
//		try {
//			BufferedImage bi = ImageIO.read(srcImg);
//			ImageIO.write(bi, "png", destImg);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// using apache commons io jar file
//		try {
//			FileUtils.copyFile(srcImg, destImg);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// from selenium 3.6 to save the image we can use FileHandler class
		try {
			FileHandler.copy(srcImg, destImg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeBrowser();
	}

}
