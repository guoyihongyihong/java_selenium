package wu.guo.five;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wu.guo.four.Wait;

public class TestCase implements Locators {
	private WebDriver ffwb = null;
	private String projectPath = System.getProperty("user.dir");
	private FirefoxProfile firefoxProfile = null;
	private Wait wait = null;

	@BeforeClass
	public void startFirfox() {
		File firebug = new File(projectPath + "/tool/firebug-1.12.1-fx.xpi");
		File firePath = new File(projectPath + "/tool/firepath-0.9.7-fx.xpi");
		firefoxProfile = new FirefoxProfile();
		try {
			firefoxProfile.addExtension(firePath);
			firefoxProfile.addExtension(firebug);
			firefoxProfile.setPreference("webdriver.accept.untrusted.certs",
					"true");
			firefoxProfile.setPreference("extensions.firebug.currentVersion",
					"2.0.19");
			ffwb = new FirefoxDriver(firefoxProfile);
			wait = new Wait(ffwb);
			ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ffwb.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeIframe() {
		ffwb.get("http://jqueryui.com/slider/");
		wait.waitForElementPresent(JQUERYHOME);
		ffwb.switchTo().frame(ffwb.findElement(By.xpath(SLIDERIFRAME)));// ÇÐ»»µ½iframe
		Point initialPoint = ffwb.findElement(By.xpath(SLIDER)).getLocation();
		System.out.println(initialPoint);

		Actions dragger = new Actions(ffwb);
		dragger.dragAndDropBy(ffwb.findElement(By.xpath(SLIDER)),
				initialPoint.getX() + 569, initialPoint.getY()).build()
				.perform();

		initialPoint = ffwb.findElement(By.xpath(SLIDER)).getLocation();
		System.out.println(initialPoint);
		wait.waitFor(5000);

		ffwb.switchTo().defaultContent();
		ffwb.findElement(By.xpath(DRAGGABLE)).click();
		wait.waitFor(3000);
	}
	
	


	@AfterClass
	public void releaseFFDriver() {
		ffwb.quit();
	}
}
