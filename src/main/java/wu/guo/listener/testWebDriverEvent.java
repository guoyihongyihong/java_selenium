package wu.guo.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class testWebDriverEvent {
	/*
	 * @FindBys({
	 * 
	 * @FindBy(),
	 * 
	 * @FindBy() })
	 */
	@FindAll({ @FindBy(), @FindBy() })
	private WebElement web = null;

	public static void main(String[] args) throws Exception {

		WebDriver driver = new FirefoxDriver();
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(
				driver);
		MyEventListener myEventListener = new MyEventListener();
		eventFiringWebDriver.register(myEventListener);

		eventFiringWebDriver.get("http://www.baidu.com");
		System.out.println("-------");
		eventFiringWebDriver.get("http://www.qq.com");
		eventFiringWebDriver.navigate().back();

		Thread.sleep(3000);

		eventFiringWebDriver.findElement(By.id("su")).click();

		driver.quit();
	}

}
