package core;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.Assert;

public class BaseUtilTest {
	
	BaseUtil b = new BaseUtil();
	
	@Test

	public void test_1()
	{
		String expire = null;
		
		System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertFalse(b.monthYearParsExpire(expire));	
	}


	@Test
	public void test_2()
	{
		String expire = "";
		
		System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertFalse(b.monthYearParsExpire(expire));	
	}
	
	
	@Test
	public void test_3() {

		String expire = "206";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));	
	}
	

	@Test 
    public void test_4() {
		
		try {
			String expire = "12";
			b.monthYearParsExpire(expire);}
		catch (Exception e) {	
		assertThat(e.getMessage(), is ("Unknown Expired [12] for credit card"));
		}
		}
	

	@Test
	public void test_5() {

		String expire = "0126";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));	
	}
	
	@Test
	public void test_6() {

		String expire = "0326";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));	
	}
	
	@Test
	public void test_7() {

		String expire = "0426";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));
	}
	
	@Test
	public void test_8() {

		String expire = "0526";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));
	}

	@Test
	public void test_9() {

		String expire = "0626";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));
	}

	@Test
	public void test_10() {

		String expire = "0726";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));
	}

	@Test
	public void test_11() {

		String expire = "0826";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));
	}

	@Test
	public void test_12() {

		String expire = "0926";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));
	}

	@Test
	public void test_13() {

		String expire = "1026";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));
	}

	@Test
	public void test_14() {
		
		String expire = "1126";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));
	}
	
	
	@Test
	public void test_15() {

		
		String expire = "January - 1";
		//System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));
		
		assertTrue(b.monthYearParsExpire(expire));
	}


	@Test
	public void test_16() {
		
		try {
			
			String expire = "1326";
			b.monthYearParsExpire(expire);}
		catch (Exception e) {	
		assertThat(e.getMessage(), is ("Unknown Month [13]"));			
		}
	}

	@Test
	public void test_17() {
		
		String tmp = null;

		Assert.assertFalse(b.isParamUseful(tmp));
	}

	@Test
	public void test_18() {
		
		String tmp = "Ja";

		Assert.assertTrue(b.isParamUseful(tmp));
	}
	
	@Test
	public void test_19() {
		
		String tmp = " ";

		Assert.assertFalse(b.isParamUseful(tmp));
	}
	
	
	@Test
	public void test_20() {
		
		String tmp = "";

		Assert.assertFalse(b.isParamUseful(tmp));
	}
	
	
		public String
		convertStringArrayToString(String[] strArr) {
		StringBuilder sb = new StringBuilder();
		for(String str : strArr) sb.append(str);
		return sb.toString();
	}
		
		private void assertFalse(String[] monthYearParsExpire) {
			// TODO Auto-generated method stub
		}
		
		private void assertTrue(String[] monthYearParsExpire) {
			// TODO Auto-generated method stub	
		}
	
}

