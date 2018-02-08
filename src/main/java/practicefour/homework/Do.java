package practicefour.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import wu.guo.four.ParseProperties;
import wu.guo.four.Wait;

public class Do {
	private WebDriver driver;
	private ParseProperties locator = new ParseProperties(
			System.getProperty("user.dir") + "\\tool\\locators.properties");
	private Wait waiter;

	public Do(WebDriver driver) {
		this.driver = driver;
		waiter = new Wait(driver);
	}

	/**
	 * 查找某个元素
	 * 
	 * @param locatorname
	 * @return
	 */
	public WebElement what(String locatorname) {
		return driver.findElement(By.xpath(locator.getValue(locatorname)));
	}
	
	
	/**
	 * 查找多个元素
	 * @param locatorname
	 * @return
	 */
	public List<WebElement> whats(String locatorname) {
		return driver.findElements(By.xpath(locator.getValue(locatorname)));
	}
	
	/**
	 * 元素存在
	 * @param locatorname
	 */
	public void waitForElementPresent(String locatorname) {
		waiter.waitForElementPresent(locator.getValue(locatorname));
	}
	
	public void waitForElementIsEnable(String locatorname){
		waiter.waitForElementIsEnable(locator.getValue(locatorname));
	}
	
	public void waitFor(long timeout){
		waiter.waitFor(timeout);
	}

}
