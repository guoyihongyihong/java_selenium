package wu.guo.one;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng1 {
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@Test
	public void test1() {
		System.out.println("test1");
	}

	@Test
	public void test2() {
		System.out.println("test2");
	}

	@Test
	public void test3() {
		System.out.println("test3");
	}

	@Test
	public void test4() {
		System.out.println("test4");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

}
