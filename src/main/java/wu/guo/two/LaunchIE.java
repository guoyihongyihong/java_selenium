package wu.guo.two;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class LaunchIE {
	
	private static WebDriver iewb = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void startIE(){
		System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer32.exe"); 
		caps = DesiredCapabilities.internetExplorer();
		
		//定义IEDriverServer使用IE的启动API的功能
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		
		//在IEDriverServer启动时，定义忽略浏览器保护模式设置的功能。设置此功能将使您的测试不稳定且难以调试。
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);   
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");		
        caps.setCapability("ignoreZoomSetting", true);
        iewb = new InternetExplorerDriver(caps);
        
	}
	

	
	@Test
	public void searchOnBaidu(){	
		iewb.manage().window().maximize();
		iewb.get("http://www.baidu.com");
	}
	
	@AfterClass
	public void releaseIEDriver(){
		iewb.close();
		iewb.quit();
	}
	
}
