package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingTechniques {
	/*
	 * findElement() -> is used to locate an element in the web page using locator
	 * information. If the element is not located using the given locator info this
	 * method throws NoSuchElementException.
	 */

	/*
	 * findElements() -> is used to locate multiple elements in the web page using
	 * locator information. This method returns a list of elements. if no element is
	 * not located then this method returns an empty list.
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		/*
		 * Selenium provides 8 ways to locate an element in the current web page These
		 * ways are available as static methods in By class. all these 8 methods in By
		 * class accepts a string argument and returns a By class reference
		 */

		/*
		 * id(String arg) : returns a By class reference it is used to locate an element
		 * using it's id attribute value.
		 */
		By idLoc = By.id("email");
		WebElement emailEle = driver.findElement(idLoc);
//		WebElement emailEle = driver.findElement(By.id("email"));

		/*
		 * name(String arg) : it is used to locate an element using it's name attribute
		 * value.
		 */
		By nameLoc = By.name("firstname");
		WebElement firstNameEle = driver.findElement(nameLoc);

		/*
		 * linkText(String arg): is used to locate a link using link text, link text is
		 * the inner text of the <a> tag inner text means the text in between opening
		 * and closing tag linktext means the text in between <a> and </a>
		 */
		By linkTextLoc = By.linkText("Forgotten account?");
		WebElement forgottenAccountLink = driver.findElement(linkTextLoc);

		/*
		 * partialLinkText(String arg): is used to locate a link using part of the link
		 * text instead of complete link text
		 */
		By partialLinkTextLoc = By.partialLinkText("Create a");
		WebElement createAPageLink = driver.findElement(partialLinkTextLoc);

		/*
		 * cssSelector(String arg): is used to locate any element using any attribute
		 * value syntax: tagName[att_name = 'att_value']
		 */
		By cssSelectorLoc = By.cssSelector("input[value='1']");
		WebElement femaleRadioBtn = driver.findElement(cssSelectorLoc);

		/*
		 * xpath(String arg): is also used to locate any element using any attribute
		 * value syntax: //tagName[@att_name = 'att_value']
		 */
		By xpathLoc = By.xpath("//input[@value='2']");
		WebElement maleRadioBtn = driver.findElement(xpathLoc);

		/*
		 * className(String arg) : is used to locate either single or multiple elements
		 * using class name of the element.we have to use any one class name in
		 * className() argument, we are not allowed to used multiple class names in
		 * className() argument
		 */
		By classNameLoc = By.className("inputtext");
		List<WebElement> textfields = driver.findElements(classNameLoc);
		System.out.println("number of text fields = "+textfields.size());

		/*
		 * tagName(String arg): is used to locate either single or multiple elements
		 * using name of the tag.
		 */
		
		By tagNameLoc = By.tagName("a");
		List<WebElement> links = driver.findElements(tagNameLoc);
		
		System.out.println("number of links = "+links.size());
		
		//close the browser
		driver.close();
	}
}
