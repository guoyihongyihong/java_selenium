package wu.guo.cookie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.tree.ExpandVetoException;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAddCookies {
	public static BufferedReader bufferedReader;

	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://172.16.1.168:9442/UI/account/Login.aspx");

		File cookieFile = new File(System.getProperty("user.dir")
				+ "\\tool\\zhongkong.txt");
		bufferedReader = new BufferedReader(new FileReader(cookieFile));
		String line;

		while ((line = bufferedReader.readLine()) != null) {
			StringTokenizer stringTokenizer = new StringTokenizer(line);
			while (stringTokenizer.hasMoreElements()) {
				//System.out.println(stringTokenizer.nextToken());
				//ASP.NET_SessionId;zj0knipbvlg2ncaqy42k1miq;172.16.1.168;/;null;false
				String info = stringTokenizer.nextToken();
				String[] infos = info.split(";");
				String name = infos[0];
				String value = infos[1];
				String domain = infos[2];
				String path = infos[3];
		
				Date expiry = null;
				String dt;
				if (!(dt = infos[4]).equals("null")) {
					expiry = new Date(dt);
				}
				boolean isSecure = new Boolean(infos[5])
						.booleanValue();
				Cookie cookie = new Cookie(name, value, domain, path, expiry,
						isSecure);
				driver.manage().addCookie(cookie);
			}
		}
		driver.get("http://172.16.1.168:9442/UI/account/Login.aspx");
	}

}
