package wu.guo.one;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testng2 {
	@BeforeSuite
	public void beforesuite() {
		System.out.println("Testng2.beforesuite()");
	}
	
	@BeforeClass
    public void beforeClass(){
    	System.out.println("beforeClass");
    }
    
    @BeforeMethod
    public void beforeMethod(){
    	System.out.println("beforeMethod");
    }
    
    @Test
    public void aFastTest(){
    	System.out.println("practice2:aFastTest");
    }
    
    @Test
    public void bSlowTest(){
    	System.out.println("practice2:bSlowTest");
    }
    

    
    @AfterMethod
    public void afterMethod(){
    	System.out.println("afterMethod");
    }
    
    @AfterClass
    public void afterClass(){
    	System.out.println("afterClass");
    }
    
    @AfterSuite
    public void afterSuit() {
    	System.out.println("Testng2.afterSuit()");
    }

}
