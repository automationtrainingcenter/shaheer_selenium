package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManagementCommands {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		/*
		 * In WebDriver interface we have manage() which return Options interface
		 * reference In Options interface we have window() which returns Window
		 * interface reference
		 * 
		 * Window interface contains several methods to manage browser
		 * 
		 */
		// create Options interface reference
		Options manage = driver.manage();
		// create Window interface reference
		Window window = manage.window();

		/*
		 * getSize(): returns Dimension class object i.e. the height and width of the
		 * browser window. Dimension class contains two methods getWidth() returns width
		 * of the browser window and getHeight() returns height of the browser window.
		 */
		Dimension size = window.getSize();
		System.out.println("window width = " + size.getWidth() + " height = " + size.getHeight());

		/*
		 * getPosition(): returns position of the browser window from top left corner of
		 * the screen as a Point class object. Point class contains two methods, getX()
		 * returns x axis position and getY() returns Y asix position.
		 */
		Point position = window.getPosition();
		System.out.println("window is at x = " + position.getX() + " and at y = " + position.getY());

		// maximize(): which will maximizes the browser window
		window.maximize();
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// fullScreen(): which will full screen(F11 mode) the browser window
		window.fullscreen();
		Thread.sleep(3000);

		/*
		 * setSize(Dimestion arg): set the size of the browser window to the specified
		 * width and height using Dimension class object
		 */
//		Dimension dim = new Dimension(450, 300);
//		window.setSize(dim);
		window.setSize(new Dimension(450, 300));
		Thread.sleep(3000);
		/*
		 * setPosition(Point arg): set the position of the browser window from the top
		 * left corner of the screen using Point class object
		 */
		window.setPosition(new Point(550, 350));
		Thread.sleep(3000);

		driver.close();

	}

}
