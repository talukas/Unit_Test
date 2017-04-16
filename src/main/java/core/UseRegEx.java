package core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

import ru.yandex.qatools.allure.annotations.Step;

public class UseRegEx {
	
	public static final Logger LOG = Logger.getLogger(BaseUtil.class.getName());
	List<String> testInfoArrayText = new ArrayList<String>();
	/* This method return String from input (use regular expression) */
	@Step("Use 'regex' [{0}] to find in [{1}]")
	public String regExp(String pattern, String input, int groupNumber) {
		String found = null;
		int entInput = 30; // default

		if (input.length() <= entInput) {
			entInput = input.length();
		}

		try {
			Pattern currentDate = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
			Matcher regex = currentDate.matcher(input);
			if (regex.find()) {

				found = regex.group(groupNumber);
				// found = regex.group(0);
			} else {
				throw new IllegalStateException(
						"Can't find pattern [" + pattern + "] in [" + input.substring(0, entInput) + "]");
			}

		} catch (IllegalStateException | NullPointerException e) {
			LOG.error("Can't find in [" + input.substring(0, entInput) + "], use regex [" + pattern + "]");
		}

		if (input.length() <= 40) {
			LOG.info("Was found [" + found + "] in line [" + input.substring(0, entInput) + "]. Regex [" + pattern
					+ "]");
		}

		else {
			LOG.info("Was found [" + found + "] in line [" + input.substring(0, entInput) + "]. Regex [" + pattern
					+ "]");
		}

		return found;
		
	}

		protected String replaceStringRegex(final String REGEX, final String INPUT_VALUE, final String REPLACEMENT) {
		String cleanValue = null;

		if (INPUT_VALUE != null) {
			cleanValue = INPUT_VALUE.replaceAll("[^\\p{ASCII}]", "").trim().replaceAll(REGEX, REPLACEMENT);
		} else {
			LOG.warn("Can't clean string. String is Empty.");
		}

		return cleanValue;
	}

	//uniT
	@Step("Is total amount [{1}] correct? Payment type [{0}]")
	public boolean isTotalAmountCorrect(final String payType, final String totalamount) {

		int respondeCode = 0; // CODE - Ok
		int totalAmount = Integer.parseInt(replaceStringRegex("[.,]", totalamount, ""));

		float totalAmountF = Float.parseFloat(replaceStringRegex("[,]", totalamount, ""));

		float totalAmountCentsF = roundFloat(totalAmountF - ((int) totalAmountF));

		String totalCents = Float.toString(totalAmountCentsF);

		switch (totalCents) {
		// Auth declined
		case "0.01":
			respondeCode = 200;
			break;

		// Call Voice Oper
		case "0.02":
			respondeCode = 201;
			break;

		// Hold call
		case "0.03":
			respondeCode = 202;
			break;

		// Call Voice Oper
		case "0.04":
			respondeCode = 203;
			break;

		// Invalid Card No
		case "0.05":
			respondeCode = 204;
			break;

		// Invalid Exp Date
		case "0.06":
			respondeCode = 205;
			break;

		// Invalid ICA NO
		case "0.07":
			respondeCode = 206;
			break;

		// Invalid ABA NO
		case "0.08":
			respondeCode = 207;
			break;

		// Invalid PIN NO
		case "0.09":
			respondeCode = 208;
			break;

		// Invalid BANK MID
		case "0.10":
			respondeCode = 209;
			break;

		// Invalid BANK MID
		case "0.1":
			respondeCode = 209;
			break;

		// Invalid TERM NO
		case "0.11":
			respondeCode = 210;
			break;

		// Invalid AMOUNT
		case "0.12":
			respondeCode = 211;
			break;

		// Invalid STATE CD
		case "0.13":
			respondeCode = 212;
			break;

		// Invalid DECLINE
		case "0.14":
			respondeCode = 213;
			break;

		// CALL VOICE OPER
		case "0.15":
			respondeCode = 214;
			break;

		// LOST/STOLEN CARD
		case "0.16":
			respondeCode = 215;
			break;

		// INVALID PIN
		case "0.17":
			respondeCode = 216;
			break;

		// OVER CREDIT FLR
		case "0.18":
			respondeCode = 217;
			break;

		// REQUEST DENIED
		case "0.19":
			respondeCode = 218;
			break;

		// NOT ONLINE TO
		case "0.20":
			respondeCode = 220;
			break;

		// NOT ONLINE TO
		case "0.2":
			respondeCode = 220;
			break;

		// REQUEST DENIED
		case "0.21":
			respondeCode = 218;
			break;

		// REQUEST DENIED
		case "0.22":
			respondeCode = 218;
			break;

		// REQUEST DENIED
		case "0.23":
			respondeCode = 218;
			break;

		// REQUEST DENIED
		case "0.24":
			respondeCode = 218;
			break;

		// REQUEST DENIED
		case "0.25":
			respondeCode = 218;
			break;

		// DECLINED PER CARDHOLDER
		case "0.59":
			respondeCode = 777;
			break;

		// REQUEST DENIED
		case "0.92":
			respondeCode = 218;
			break;

		// REQUEST DENIED
		case "0.93":
			respondeCode = 218;
			break;

		// REQUEST DENIED
		case "0.94":
			respondeCode = 218;
			break;

		// REQUEST DENIED
		case "0.97":
			respondeCode = 218;
			break;

		// REQUEST DENIED
		case "0.98":
			respondeCode = 218;
			break;

		// REQUEST DENIED
		case "0.99":
			respondeCode = 218;
			break;

		default:
			respondeCode = 0; // Ok
			// String msg = "Unknown Cents [" + totalCent + "]";
			// LOG.info(msg);
			// throw new IllegalArgumentException(msg);
		}

		/**
		 * FOR VISA ONLY $1.69 returns AVS=Y on manual entry $19.58 returns a D
		 * in the Auth Code - VISA ONLY >$999,999.99 INVALID AMOUNT $98.26-98.91
		 * PSERV=N; Downgrade Reason = NP - VISA ONLY
		 */
		if ((((totalAmount == 169 || totalAmount == 1958) || (totalAmount >= 9826 && totalAmount <= 9891))
				&& payType.equalsIgnoreCase("5")) || totalAmount > 999_999_99) {
			respondeCode = 1; // 1- it's NOT OK
		}


		LOG.info("Amount [" + totalamount + "]$. Tampa code [" + respondeCode + "]. Must be [0]");

		
		uploadToList(testInfoArrayText , "Tampa code [" + respondeCode + "] for amount [" + totalamount + "]");

		return respondeCode == 0;
	}
	
	public static synchronized void uploadToList(List<String> list, final String... args) {

		if (list != null && args.length != 0) {

			StringBuilder sb = new StringBuilder(100);

			for (int i = 0; i <= args.length - 1; ++i) {

				// if (args[i] != null && !args[i].isEmpty() && args[i] != " ")
				// {
				if (args[i] != null) {
					sb.append(args[i].trim());

					// Print comma separator value (csv)
					if (i != args.length - 1) {
						sb.append(",");
					}
				} else {
					LOG.warn("Was empty element in the array.");
				}
			}
			LOG.info("Upload data to List. Capacity String Builder [" + sb.capacity() + "]");
			list.add(sb.toString());
		} else {
			LOG.warn("Nothing was uploaded to the List. Size collection [" + list.size() + "]");
		}
	}

	private float roundFloat(float f) {
		// TODO Auto-generated method stub
		return 0;
	}


}
