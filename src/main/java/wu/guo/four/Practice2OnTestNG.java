package wu.guo.four;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Practice2OnTestNG {
	private ParseProperties data;
	private ParseProperties locator;

	@Parameters(value = { "data", "locator" })
	@Test
	public void test(String da, String loc) {
		data = new ParseProperties(System.getProperty("user.dir") + da);
		locator = new ParseProperties(System.getProperty("user.dir") + loc);
		System.out.println(data.getValue("username"));
		System.out.println(locator.getValue("username"));
	}

}
