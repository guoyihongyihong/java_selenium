package wu.guo.one;

import org.testng.annotations.Test;

public class Testng3 {
	
	@Test(groups="submodule1")
	public void testSubModule1() {
		System.out.println("Testng3.testSubModule1()");
	}
	
	@Test(groups="submodule2")
	public void testSubModule2() {
		System.out.println("Testng3.testSubModule2()");
	}
	
	@Test(groups="submodule3")
	public void testSubModule3() {
		System.out.println("Testng3.testSubModule3()");
	}
	
	@Test(groups={"submodule3","submodule2"})
	public void testSubModele4() {
		System.out.println("Testng3.testSubModele4()");
	}

}
