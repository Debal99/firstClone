package validui.testcases;

import org.testng.annotations.*;

public class CheckTestng {
	
	
	P p1 = new P();

	@BeforeSuite
	public void bs() {
		System.out.println("bs");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("bt");
	}
	
	@BeforeClass
	public void bc() {
		System.out.println("bc");
	}
	
	@BeforeMethod
	public void bm(){
		System.out.println("bm");
	}
	
	
	@Test
	public void m1() {
		System.out.println("inside method m1 ==>"+P.i);
		p1.p1();
	}
	
	@Test
	public void m2() {
		System.out.println("inside method m2 ===> "+P.i);
		p1.p1();
	}
	
	@AfterMethod
	public void am(){
		System.out.println("am");
	}
	
	
	@AfterClass
	public void ac() {	
		System.out.println("ac");
	}	
	
	@AfterTest
	public void at() {
		System.out.println("at");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("as");
	}

}
