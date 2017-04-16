package core;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.testng.Assert;

public class BaseUtilTest {

	BaseUtil b = new BaseUtil();
	String expire;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test

	public void test_1() {
		expire = null;
		System.out.println(convertStringArrayToObject(b.monthYearParsExpire(expire)));
		b.monthYearParsExpire(expire);
		assertNull(convertStringArrayToObject(b.monthYearParsExpire(expire)));
	}


	@Test
	public void test_2() {
		exception.expect(NullPointerException.class);
		expire = "";
		System.out.println(convertStringArrayToObject(b.monthYearParsExpire(expire)));
		b.monthYearParsExpire(expire);
		assertNull(convertStringArrayToObject(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_3() {

		expire = "226";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("February - 022026", instanceOf(String.class));
		Assert.assertEquals("February - 022026", convertStringArrayToString(b.monthYearParsExpire(expire)));

	}

	@Test
	public void test_4() {

		try {
			expire = "12";
			b.monthYearParsExpire(expire);
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), containsString("Unknown Expired [12] for credit card"));}
	}

	@Test
	public void test_5() {

		expire = "126";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("January - 012026", instanceOf(String.class));
		Assert.assertEquals("January - 012026", convertStringArrayToString(b.monthYearParsExpire(expire)));

	}

	@Test
	public void test_6() {

		expire = "0326";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("March - 032026", instanceOf(String.class));
		Assert.assertEquals("March - 032026", convertStringArrayToString(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_7() {

		expire = "0426";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("April - 042026", instanceOf(String.class));
		Assert.assertEquals("April - 042026", convertStringArrayToString(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_8() {

		expire = "0526";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("May - 052026", instanceOf(String.class));
		Assert.assertEquals("May - 052026", convertStringArrayToString(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_9() {

		expire = "0626";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("June - 062026", instanceOf(String.class));
		Assert.assertEquals("June - 062026", convertStringArrayToString(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_10() {

		expire = "0726";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("July - 072026", instanceOf(String.class));
		Assert.assertEquals("July - 072026", convertStringArrayToString(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_11() {

		expire = "0826";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("August - 082026", instanceOf(String.class));
		Assert.assertEquals("August - 082026", convertStringArrayToString(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_12() {

		expire = "0926";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("September - 092026", instanceOf(String.class));
		Assert.assertEquals("September - 092026", convertStringArrayToString(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_13() {

		expire = "1026";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("October - 102026", instanceOf(String.class));
		Assert.assertEquals("October - 102026", convertStringArrayToString(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_14() {

		expire = "1126";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(expire)));

		assertNotNull(b.monthYearParsExpire(expire));
		assertThat("November - 112026", instanceOf(String.class));
		Assert.assertEquals("November - 112026", convertStringArrayToString(b.monthYearParsExpire(expire)));
	}

	@Test
	public void test_15() {

		String monthExpireParsed = "December - 12 ";
		// System.out.println(convertStringArrayToString(b.monthYearParsExpire(monthExpireParsed)));

		assertNotNull(b.monthYearParsExpire(monthExpireParsed));
		assertThat("December - 122026", instanceOf(String.class));
		Assert.assertEquals("December - 122026", convertStringArrayToString(b.monthYearParsExpire(monthExpireParsed)));
	}

	@Test
	public void test_16() {

		try {
			expire = "1326";
			b.monthYearParsExpire(expire);
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), containsString("Unknown Month [13]"));
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

	public String convertStringArrayToString(String[] strArr) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr)
			sb.append(str);
		return sb.toString();
	}
	
	private Object convertStringArrayToObject(String[] monthYearParsExpire) {
		// TODO Auto-generated method stub
		return null;

}
	}
