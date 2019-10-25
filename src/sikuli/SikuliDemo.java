package sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utilities.BrowserHelper;
import utilities.GenericHelper;
/*
 * To automate windows based screen we have to use sikuli
 * download sikuli jar file from the official sikuli webisite i.e. http://sikulix.com/
 * In Sikuli we have mainly two classes one is Screen class and other one is Pattern class
 * Sikuli works based on visual image matching technology
 * that means what ever we want to automate please take an image of that element
 * Create Pattern class object for every image we captured by giving it's path
 * Create Screen class object which contains all the method to automate your elements
 * using element images
 * 
 */

public class SikuliDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://smallpdf.com/word-to-pdf");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.titleContains("Convert"))) {
			WebElement choosefile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Choose file']")));
			choosefile.click();
			// fileName
			Pattern fileName = new Pattern(GenericHelper.getFilePath("images", "filenname.PNG"));
			// openButton
			Pattern openButton = new Pattern(GenericHelper.getFilePath("images", "open.PNG"));
			// create Screen class object
			Screen screen = new Screen();
			sleep(2000);
			try {
				screen.find(fileName);
				screen.type(fileName,"E:\\SMIT\\Software Testing Syllabus.doc");
				screen.find(openButton).click();
				sleep(5000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeBrowser();
//			System.out.println("this is \"important\"");
		}
	}

}
