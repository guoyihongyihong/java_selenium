package wu.guo.listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyEventListener extends AbstractWebDriverEventListener {

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After navigate To  " + url);
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("MyEventListener.afterNavigateBack()" + driver.getCurrentUrl());
	}
	
	public void afterClickOn(WebElement webElement, WebDriver driver){
		System.out.println("After Click on " + webElement.getText());
	}
}
