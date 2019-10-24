package screenshots;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import utilities.BrowserHelper;
import utilities.GenericHelper;

public class AlertScreenCaptureDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		// locate alert button and click on it which will open an alert on the page
		driver.findElement(By.id("alertbtn")).click();
		// now we got an alert capture the screenshot of the alert
		// In java we have Robot class which contains createScreenCapture()
		// create Robot class object
		try {
			Robot r = new Robot();
			Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(size);
			BufferedImage bi = r.createScreenCapture(rect);
			File destImg = new File(GenericHelper.getFilePath("screenshots", "alertscreen.png"));
			ImageIO.write(bi, "png", destImg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// handle the alert
		driver.switchTo().alert().accept();
		// close browser
		closeBrowser();
		
	}

}
