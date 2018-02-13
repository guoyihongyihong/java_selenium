package wu.guo.four;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice1OnTestNG {

	@Parameters(value = "TestData")
	@Test
	public void test(String testData1) {
		ParseProperties pp = new ParseProperties(System.getProperty("user.dir")
				+ testData1);
		System.out.println(pp.getValue("url"));
		System.out.println(pp.getValue("username"));
		System.out.println(pp.getValue("password"));
		Assert.assertEquals("q".equals("q"), true);
	}

}
