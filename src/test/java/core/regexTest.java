package core;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.Assert;
import org.testng.annotations.Test;

public class regexTest {
	
	UseRegEx R = new UseRegEx();
	String pattern;
	String input; 
	int groupNumber;
	String payType;
	String REGEX;
	String INPUT_VALUE;
	String REPLACEMENT;
	String totalamount;
	
	@Test

	public void test_1() {
		String totalCents = "0.09";
		String respondeCode = "1";
		//String payType = "5";
		System.out.println(R.isTotalAmountCorrect(totalCents, respondeCode));
		Assert.assertTrue(R.isTotalAmountCorrect(totalCents, respondeCode));
		
	}
	
@Test
	
	public void test_3() {
		String entInput = "30";
		String found = "1";
		int groupNumber = 1;
		System.out.println(R.regExp(entInput, found, groupNumber));
		}

@Test

 public void test_4() {
	 
	 String regex = "[A-Z][a-z]{2}\\s[A-Z][a-z]{2}\\s[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}\\s[A-Z]{3}\\s[0-9]{4}";
	 String found = regex;
	 String entInput = "30";
	 System.out.println(R.regExp(entInput, found, groupNumber));
	
}


@Test

public void test_5() {
	
	 String REPLACEMENT = " ";
	 String INPUT_VALUE = "April 14 2017";
	 String REGEX = "[A-Z][a-z]{2}\\s[A-Z][a-z]{2}\\s[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}\\s[A-Z]{3}\\s[0-9]{4}";

	 System.out.println(R.replaceStringRegex(REPLACEMENT, REGEX, INPUT_VALUE));
	
}


@Test

public void test_6() {
	
	String regex = "[A-Z][a-z]{2}\\s[A-Z][a-z]{2}\\s[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}\\s[A-Z]{3}\\s[0-9]{4}";
	String input = "04 15 2017";
	int groupNumber = 0;
	boolean matches = regex.matches(input);
	assertThat(R.regExp(pattern, input, groupNumber(matches(regex))));

	 System.out.println(matches);
	
}




private void assertThat(String regExp) {
	// TODO Auto-generated method stub
	
}

private int groupNumber(Object matches) {
	// TODO Auto-generated method stub
	return 0;
}

private Object matches(String regex2) {
	// TODO Auto-generated method stub
	return null;
}



}

