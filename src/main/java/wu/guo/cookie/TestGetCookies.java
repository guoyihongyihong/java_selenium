package wu.guo.cookie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGetCookies {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://172.16.1.168:9442/UI/account/Login.aspx");
		Thread.sleep(3000);
		
		WebElement userName = driver.findElement(By.id("txtAcc"));
		userName.clear();
		userName.sendKeys("think");
		
		WebElement pwd = driver.findElement(By.id("txtPwd"));
		pwd.clear();
		pwd.sendKeys("think@123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		File cookieFile = new File(System.getProperty("user.dir") + "\\tool\\zhongkong.txt");
		cookieFile.delete();
		
		cookieFile.createNewFile();
		FileWriter fileWriter = new FileWriter(cookieFile);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		for(Cookie cookie : driver.manage().getCookies()){
			bufferedWriter.write(cookie.getName() + ";"
					+ cookie.getValue() + ";"
					+ cookie.getDomain() + ";"
					+ cookie.getPath() + ";"
					+ cookie.getExpiry() + ";"
					+ cookie.isSecure());
			bufferedWriter.newLine();
		}
		
		bufferedWriter.flush();
		bufferedWriter.close();
		fileWriter.close();
		driver.quit();
	}
}
