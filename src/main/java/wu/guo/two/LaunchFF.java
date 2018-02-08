package wu.guo.two;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchFF {
	private WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");// ��ȡ����·��

	@BeforeClass
	public void startFirefox() throws IOException {
		File firebug = new File(projectpath + "/tool/firebug-1.12.1-fx.xpi");
		File firepath = new File(projectpath + "/tool/firepath-0.9.7-fx.xpi");
		firefoxprofile = new FirefoxProfile();

		firefoxprofile.addExtension(firepath);//��ʵ�����������һ����չ
		firefoxprofile.addExtension(firebug);
		firefoxprofile
				.setPreference("webdriver.accept.untrusted.certs", "true"); // ��������֤��
		firefoxprofile.setPreference("extensions.firebug.currentVersion",
				"1.12.1");// ����firebug
		firefoxprofile.setPreference("network.proxy.type", 0); // ���ô���
		firefoxprofile.setPreference("network.proxy.http", "10.1.1.0");
		firefoxprofile.setPreference("network.proxy.http_port", 3128);

		ffwb = new FirefoxDriver(firefoxprofile);
	}

	@Test
	public void searchOnBaidu() {
		ffwb.get("http://www.baidu.com");
		System.out.print(Locator.username1);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
