package utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {
	private static String getTimeStamp() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(" dd_MMM_yy HH-mm-ss");
		return df.format(date);
	}
	
	private static String getPath(String folderName, String fileName) {
		String rootFolder = System.getProperty("user.dir");
		return rootFolder + File.separator + folderName + File.separator + fileName+getTimeStamp()+".png";
	}

	// helper method to capture the screenshot
	public static void captureScreenshot(WebDriver driver, String folderName, String fileName) {
		// type cast webdriver object reference to TakesScreenshot interface reference
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File desImg = new File(getPath(folderName, fileName));
		try {
			BufferedImage bi = ImageIO.read(srcImg);
			ImageIO.write(bi, "png", desImg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
