package wu.guo.six;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wu.guo.four.ParseProperties;

public class HomeWork6 {

	protected static WebDriver ffwb;
	private FirefoxProfile firefoxprofile;
	private String projectpath = System.getProperty("user.dir");
	private ParseProperties data = new ParseProperties((projectpath)
			+ "\\tool\\test.properties");

	@BeforeClass
	public void startFireFox() {
		File firebug = new File(projectpath + "/tool/firebug-1.12.1-fx.xpi");
		File firepath = new File(projectpath + "/tool/firepath-0.9.7-fx.xpi");
		firefoxprofile = new FirefoxProfile();
		try {
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firepath);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs",
					"true");
			firefoxprofile.setPreference("extensions.firebug.currentVersion",
					"1.12.1");
			ffwb = new FirefoxDriver(firefoxprofile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void serachMerchandise() {
		LoginPage loginpage = new LoginPage(ffwb);
		HomePage homepage = new HomePage(ffwb);

		loginpage.navigate(data.getValue("url"));
		loginpage.setUserName(data.getValue("username"));
		loginpage.setPassWord(data.getValue("password"));
		loginpage.login();

		Assert.assertEquals(homepage.hometab.isDisplayed(), true);
	}

}
