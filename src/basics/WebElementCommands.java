package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();

		// locate first name field
		WebElement firstNameEle = driver.findElement(By.name("firstname"));

		// send some data to the first name ele
		// sendKeys(CharSequence arg) is used to type some data in a text field and text
//		area. This method will send data character by character.
		firstNameEle.sendKeys("sunshine");
		Thread.sleep(2000);

//		driver.findElement(By.name("firstname")).sendKeys("sunshine");

		// click() is used to click on an element
		WebElement femaleRadio = driver.findElement(By.cssSelector("input[value='1']"));
		femaleRadio.click();
		Thread.sleep(2000);
	
		
		// clear() is used to clear existing data in the text field or text area.
		firstNameEle.clear();
		
		// submit() is used to submit a form to the server if that form submit button is
//		implemnted using <input> tag
		// locating email filed and submitting form
		WebElement emailEle = driver.findElement(By.id("email"));
		
//		emailEle.submit();
		
		// getText() is used to retrieve inner text of the given element
		// locate signup button
		WebElement signUpEle = driver.findElement(By.name("websubmit"));
		String signUpEleInnerText = signUpEle.getText();
		System.out.println(signUpEleInnerText);
		
		// getAttribute(String attName) returns a string value which is 
		// value of the given attribute name
		String emailTypeAttrValue = emailEle.getAttribute("type");
		System.out.println("email type attribute = "+emailTypeAttrValue);
		
		String firstNameClassAttValue = firstNameEle.getAttribute("class");
		System.out.println("first name class attribute = "+firstNameClassAttValue);
		
		// getTagName() returns a string value which is name of the tag of given element
		String signUpTagname = signUpEle.getTagName();
		System.out.println("tag name of sign up ele is "+signUpTagname);
		
		// getCssValue(String cssPropName) returns a string value which is 
		// value of the given css property name
		String borderRadiusofSingUpEle = signUpEle.getCssValue("border-radius");
		System.out.println("border-radius of singup ele = "+borderRadiusofSingUpEle);
		
		String borderColorOfEmailEle = emailEle.getCssValue("border-color");
		System.out.println("border color of email ele = " +borderColorOfEmailEle);
		
		// getSize(): returns Dimension class object i.e. height and width of the given element
		Dimension size = firstNameEle.getSize();
		System.out.println("first name ele height = "+size.getHeight()+" and width = "+size.getWidth());
		
		//getLocation(): returns Point class object i.e. x and y coordinate 
		// values of the given element in a current web page
		Point emailLoc = emailEle.getLocation();
		System.out.println("email elmenet is at x = "+emailLoc.getX()+" and at y = "+emailLoc.getY());
		
		Point signupLoc = signUpEle.getLocation();
		System.out.println("signup element is at x = "+signupLoc.getX()+" and at y = "+signupLoc.getY());
		
		// isDisplayed() returns true if given element is visible on the web page
		boolean emailDispalyed = emailEle.isDisplayed();
		System.out.println("email element is dispalyed "+emailDispalyed);
		
		boolean reEnterEmailDispalyed = driver.findElement(By.name("reg_email_confirmation__")).isDisplayed();
		System.out.println("reenter email address is displayed "+reEnterEmailDispalyed);
		
		
		// isEnabled() returns true if given elmenet is in enable or active mode
		boolean singUpEnabled = signUpEle.isEnabled();
		System.out.println("sign up element is enabled "+singUpEnabled);
		
		// isSelected() return true if given option of drop down list, list box,
		// radio button or check box is selected
		boolean femaleRadioSelected = femaleRadio.isSelected();
		System.out.println("female radio button is selected "+femaleRadioSelected);
		
		boolean maleRadioSelected = driver.findElement(By.cssSelector("input[value='2']")).isSelected();
		System.out.println("male radio button is selected "+maleRadioSelected);
		
		Thread.sleep(2000);
		driver.close();
	}

}
