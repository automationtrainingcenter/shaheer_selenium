package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiFramesHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/SSTS/shaheer/selenium_concepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		
		// now driver focus is in main page
		// automate frame 4 which is an inner frame of frame 3
		// first switch driver focus to frame 3 then switch frame 4
		driver.switchTo().frame("fthree");
		// now driver focus is in frame 3
		// switch to frame 4
		driver.switchTo().frame(0);
		// now focus is in frame 4 locate search course text field and type some data
		driver.findElement(By.xpath("(//input[@name='search'])[2]")).sendKeys("python");
		Thread.sleep(4000);
		
		
		// now focus is in frame 4
		// automate frame 3 which is a parent frame of frame4
		// switch driver focus from frame 4 to frame 3 using parentFrame()
		driver.switchTo().parentFrame();
		// now the focus is in frame3
		driver.findElement(By.id("click")).click();
		Thread.sleep(4000);
		
		
		// automate frame 2
		// now focus is in frame3 
		// to switch focus from frame 3 to frame 2, first switch driver focus to main page using
		// defaultContent() then switch to frame 2 using frame()
		driver.switchTo().defaultContent();
		// now focus is in main page
		driver.switchTo().frame("ftwo");
		// now focus is in frame 2
		driver.findElement(By.linkText("selenium official site")).click();
		Thread.sleep(4000);
		
		
		// automate frame 1
		// now focus is in frame 2
		// to switch focus from frame 2 to frame 1, first switch driver focus to main page using 
		// defaultContent() and then switch to frame 1 using frame()
		driver.switchTo().defaultContent();
		// now focus is in main page
		driver.switchTo().frame("fone");
		// now focus is in frame 1
		driver.findElement(By.cssSelector("input[placeholder='Enter name']")).sendKeys("sunshine");
		Thread.sleep(4000);
		
		// automate main page
		// now focus is in frame 1
		// switch the focus to main page using defaultContent()
		driver.switchTo().defaultContent();
		// now focus is in main page
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(4000);
		
		driver.quit();
		
		
		
		
		
	}

}
