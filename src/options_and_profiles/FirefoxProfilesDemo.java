package options_and_profiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FirefoxProfilesDemo {
	/*
	 * Profile is a File where Firefox saves your personal information such as bookmarks, 
	 * passwords, and user preferences. 
	 * Multiple Firefox profiles can exist, each containing a separate set of preferences.
	 * When starting Firefox in Selenium WebDriver, it starts new "anonymous" profile.
	 * 
	 * to open profiles in firefox browser type about:profiles
	 * create the profiles with extensions and preferences you want
	 * and launch firefox browser using this profile as bellow

	 */
	public static void main(String[] args) {
		ProfilesIni profilesIni = new ProfilesIni();
		FirefoxProfile fprofile = profilesIni.getProfile("myAutProfile");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fprofile);
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(options);
	}

}
