package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownListDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate day drop down list 
		WebElement dateEle = driver.findElement(By.id("day"));
		
		// create Select class object to select an date
		Select dateSelect = new Select(dateEle);
		
		// get the default selected date using getFirstSelectedOption()
		WebElement defaultDateEle = dateSelect.getFirstSelectedOption();
		System.out.println("default date is "+defaultDateEle.getText());
		
		// select an option based on index using selectByIndex(int index)
		dateSelect.selectByIndex(12);
		Thread.sleep(1000);
		
		// locate month drop down list
		WebElement monthEle = driver.findElement(By.id("month"));
		
		// create a Select class object to select a month
		Select monthSelect = new Select(monthEle);
		
		// get the default month
		String defaultMonth = monthSelect.getFirstSelectedOption().getText();
		System.out.println("default month is "+defaultMonth);
		
		// select an option based on value attribute value using selectByValue(String arg)
		monthSelect.selectByValue("6");
		Thread.sleep(1000);
		
		// locate year drop down list
		WebElement yearEle = driver.findElement(By.id("year"));
		
		// create Select class object to select a year
		Select yearSelect = new Select(yearEle);
		
		// get the default year 
		String defaultYear = yearSelect.getFirstSelectedOption().getText();
		System.out.println("default year is "+defaultYear);
		
		// select an option based on visible test i.e. inner text of option tag using
		// selectByVisisbleText(String arg)
		yearSelect.selectByVisibleText("2002");
		Thread.sleep(1000);
		
		// get how many year options are there
		List<WebElement> yearOptions = yearSelect.getOptions();
		System.out.println("number of year options avilable are "+yearOptions.size());
		
		driver.close();
		
	}

}
