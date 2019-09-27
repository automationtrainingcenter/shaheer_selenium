package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBosDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate fruits list box
		WebElement fruitsEle = driver.findElement(By.id("multiple-select-example"));

		// create Select class object
		Select fruitsSelect = new Select(fruitsEle);

		// print the type of fruit select tag i.e. either drop down list or list box
		if (fruitsSelect.isMultiple()) {
			System.out.println("fruit select is a list box");
		} else {
			System.out.println("fruit select is a drop down list");
		}

		// select an option based on index number
		fruitsSelect.selectByIndex(2);
		Thread.sleep(1000);

		// select an option based on value attribute
		fruitsSelect.selectByValue("apple");
		Thread.sleep(1000);
		
		// get all the selected options and print on console
		List<WebElement> allSelectedOptions = fruitsSelect.getAllSelectedOptions();
		for (WebElement option : allSelectedOptions) {
			System.out.println(option.getText());
		}

		// select an option based on visisble text
		fruitsSelect.selectByVisibleText("Orange");
		Thread.sleep(1000);

		// deSelectAll() is used to deselect all the selected options
//		fruitsSelect.deselectAll();
//		Thread.sleep(1000);
		
		// deselectByIndex(int arg) is used to deselect an optino based on index
		fruitsSelect.deselectByIndex(0);
		Thread.sleep(2000);
		
		// deselect an option based on value attribute value using deselectByValue(String arg)
		fruitsSelect.deselectByValue("peach");
		Thread.sleep(2000);
		
		// deselect an option based on visible text i.e. inner text using
		// deselectByVisibleText(String arg)
		fruitsSelect.deselectByVisibleText("Orange");
		Thread.sleep(2000);

		driver.close();
	}

}
