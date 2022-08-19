package com.util;

public class NumToBaht {

	/** Creates a new instance of NumToBaht */
	public NumToBaht() {
	}

	private static char fristBaht, fristStang;

	private static String baht, stang;

	private static int bLen, sLen;

	private static StringBuffer word;

// to make sure str meet our format,
// this str should be converted from double number in the format of xxx.xx
// this class won't check format of the number.
	private static void getWord(String str) {
		StringBuffer txt = new StringBuffer();
		word = new StringBuffer();
		int idx = str.indexOf(".");

		if (idx == -1) {

			txt.append(str);
			// prevent error from unwanted (stupid) zeros such as 00000001234.25
			while (txt.length() > 1 && txt.charAt(0) == '0')
				txt.deleteCharAt(0);

			baht = txt.toString();
			fristBaht = baht.charAt(0);

			stang = "";

		} else {

			txt.append(str.substring(0, idx));
			// prevent error from unwanted (stupid) zeros
			while (txt.length() > 1 && txt.charAt(0) == '0')
				txt.deleteCharAt(0);

			baht = txt.toString();

			// make sure formatted number is xxx.xx before this
			stang = str.substring(idx + 1, str.length());

			fristBaht = baht.charAt(0);

			// if stang is only a digit we need to append zero , case value 1.5 -> 1.50
			if (stang.length() == 1)
				stang += "0";

			// remove unwanted zero , case value = x.0x so 01 is
			// \u0E2B\u0E19\u0E36\u0E48\u0E07 not \u0E40\u0E2D\u0E47\u0E14
			if (stang.charAt(0) == '0')
				stang = "" + stang.charAt(1);

		}

		bLen = baht.length();

		sLen = stang.length();
		if (fristBaht != '0') {
			int len = (baht.length() - 1) / 6;
			for (int i = 0; i <= len; i++) {
				if (i < len) {
					addBaht(baht.substring(0, baht.length() - ((len - i) * 6)));
					baht = baht.substring(baht.length() - ((len - i) * 6));
					for (int j = i; j < len; j++) {
						word.append("\u0E25\u0E49\u0E32\u0E19");
					}
				} else
					addBaht(baht);
			}

			word.append("\u0E1A\u0E32\u0E17");

		}
		if (sLen > 0 && stang.compareTo("0") != 0) {

			addBaht(stang);
			word.append("\u0E2A\u0E15\u0E32\u0E07\u0E04\u0E4C");
		} else {
			word.append("\u0E16\u0E49\u0E27\u0E19");
		}

	}// end getWord

	private static void addBaht(String str) {

		int countDown = str.length();

		int idxInc = 0;

		while (countDown > 0) {

			char g = str.charAt(idxInc);

			if (g != '0') {

				increBaht(g, countDown, idxInc);

			} // end if

			countDown--;

			idxInc++;

		} // end while

	} // end addBaht

	private static void increBaht(char g, int CounDown, int idx) {

		switch (g) {

		case '1':

			if (CounDown == 1 && idx > 0)

				word.append("\u0E40\u0E2D\u0E47\u0E14");

			else if (CounDown > 2 || CounDown == 1)

				word.append("\u0E2B\u0E19\u0E36\u0E48\u0E07");

			break;

		case '2':

			if (CounDown != 2)

				word.append("\u0E2A\u0E2D\u0E07");

			else

				word.append("\u0E22\u0E35\u0E48");

			break;

		case '3':
			word.append("\u0E2A\u0E32\u0E21");
			break;

		case '4':
			word.append("\u0E2A\u0E35\u0E48");
			break;

		case '5':
			word.append("\u0E2B\u0E49\u0E32");
			break;

		case '6':
			word.append("\u0E2B\u0E01");
			break;

		case '7':
			word.append("\u0E40\u0E08\u0E47\u0E14");
			break;

		case '8':
			word.append("\u0E41\u0E1B\u0E14");
			break;

		case '9':
			word.append("\u0E40\u0E01\u0E49\u0E32");
			break;

		}// end switch1

		switch (CounDown) {

		case 2:
			word.append("\u0E2A\u0E34\u0E1A");
			break;

		case 3:
			word.append("\u0E23\u0E49\u0E2D\u0E22");
			break;

		case 4:
			word.append("\u0E1E\u0E31\u0E19");
			break;

		case 5:
			word.append("\u0E2B\u0E21\u0E37\u0E48\u0E19");
			break;

		case 6:
			word.append("\u0E41\u0E2A\u0E19");
			break;

		}// end switch2

	}// end increWord

	public static String toBaht(String num) {
		getWord(num);
		return word.toString();

	}//

}
