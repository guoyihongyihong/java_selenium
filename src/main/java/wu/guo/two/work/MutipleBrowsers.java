package wu.guo.two.work;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import wu.guo.two.launch.Browsers;
import wu.guo.two.launch.BrowsersType;

public class MutipleBrowsers {

	private WebDriver driver = null;
	private Browsers browser = null;

	@Parameters({"platform"})
	@BeforeMethod(groups="browsers")
	public void inital(String platform) {
		if ("FF".equals(platform)) {
			browser = new Browsers(BrowsersType.firefox);
		} else if ("chrome".equals(platform)) {
			browser = new Browsers(BrowsersType.chrome);
		} else {
			browser = new Browsers(BrowsersType.ie);
		}
		driver = browser.driver;
	}

	@Test(groups = "submodule1")
	public void submodule1() {
		driver.get("http://www.baidu.com");
		System.out.println("---testSubModule1--");
	}

	@Test(groups = "submodule2")
	public void submodule2() {
		driver.get("http://www.bing.com");
		System.out.println("---testSubModule2--");
	}

	@Test(groups = "submodule3")
	public void submodule3() {
		driver.get("http://www.so.com/");
		System.out.println("---testSubModule3--");
	}

	@Test(groups = "submodule4")
	public void submodule4() {
		driver.get("http://www.oracle.com/");
		System.out.println("---testSubModule4--");
	}

	@AfterMethod(groups = "browsers")
	public void release() {
		driver.quit();
	}
}
