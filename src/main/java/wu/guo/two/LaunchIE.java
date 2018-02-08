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
		
		//����IEDriverServerʹ��IE������API�Ĺ���
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		
		//��IEDriverServer����ʱ������������������ģʽ���õĹ��ܡ����ô˹��ܽ�ʹ���Ĳ��Բ��ȶ������Ե��ԡ�
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
