package com.util;

import java.util.List;

public class ConvertUtil {

	/**
	 * 
	 * @param maxlen (Size of data)
	 * @param data
	 * @return String (00001,00013,...)
	 */
	public static String getZeroSpare(int maxlen, String data) {
		String spare = "";
		if (data.length() < maxlen) {
			for (int i = 0; i < maxlen - data.length(); i++) {
				spare = spare + "0";
			}
		}
		return spare + data;
	}

	/**
	 * 
	 * @param filename (file_name.png, file_name.pdf, ...)
	 * @return String (png, zip, pdf,...)
	 */
	public static String getFileSuffix(String filename) {
		String suffix = "";
		int pos = filename.lastIndexOf('.');
		if (pos > 0 && pos < filename.length() - 1) {
			suffix = filename.substring(pos + 1);
		}
		return suffix;
	}

	/**
	 * 
	 * @param file (file_name.png, file_name.pdf, ...)
	 * @return String (view = open image file, download = download other file)
	 */
	public static String getMimeType(String file) {
		String mimetype = "";
		if (file != null && !file.equals("")) {
			if (getFileSuffix(file).equalsIgnoreCase("png")) {
				mimetype = "view";
			} else if (getFileSuffix(file).equalsIgnoreCase("jpg")) {
				mimetype = "view";
			} else if (getFileSuffix(file).equalsIgnoreCase("jpeg")) {
				mimetype = "view";
			} else if (getFileSuffix(file).equalsIgnoreCase("gif")) {
				mimetype = "view";
			} else {
				mimetype = "download";
			}
		}
		return mimetype;
	}

	/**
	 * 
	 * @param ids  (List of id)
	 * @param type (Integer.class or String.class)
	 * @return String ('1','2','3' or 1,2,3)
	 */
	@SuppressWarnings("rawtypes")
	public static String getArray2SqlIn(List ids, Class type) {
		String sql = "";

		if (Integer.class.equals(type)) { // Integer
			for (Object obj : ids) {
				int id = (Integer) obj;
				sql += id + ",";
			}

			sql = sql.substring(0, sql.length() - 1);
		} else if (String.class.equals(type)) { // String
			for (Object obj : ids) {
				String id = (String) obj;
				sql += "'" + id + "',";
			}

			sql = sql.substring(0, sql.length() - 1);
		}

		return sql;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static String hqlLikeString(String data) {
		if (data != null && !data.equals("")) {
			return data.trim();
		} else {
			return "%";
		}
	}

	public static boolean checkEncoding(String encode) {
		boolean result = false;
		try {
			byte[] bs = "1".getBytes();
			String str = new String(bs, encode.toLowerCase());

			if (str.equals("1"))
				result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	public static String convertByte2String(long bytes, int unit) {
		// int unit = 1024;
		if (bytes < unit)
			return bytes + " B";
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = "kMGTPE".charAt(exp - 1) + "";
		return String.format("%.1f %s", bytes / Math.pow(unit, exp), pre);
	}

	public static double percent(double value, double total) {
		if (total > 0) {
			return (value / total) * 100;
		} else {
			return 0.00;
		}
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		if (factor > 0) {
			value = value * factor;
			long tmp = Math.round(value);
			return (double) tmp / factor;
		} else {
			return 0;
		}
	}

	public static String unicode2Ascii(String unicode) {
		if (unicode != null) {
			StringBuffer ascii = new StringBuffer(unicode);
			int code;

			for (int i = 0; i < unicode.length(); i++) {
				code = unicode.charAt(i);

				if ((0xE01 <= code) && (code <= 0xE5B)) {
					ascii.setCharAt(i, (char) (code = 0xD60));
				}
			}

			return ascii.toString();
		} else {
			return "";
		}
	}

	public static String ascii2Unicode(String ascii) {
		if (ascii != null) {
			StringBuffer unicode = new StringBuffer(ascii);
			int code;

			for (int i = 0; i < ascii.length(); i++) {
				code = ascii.charAt(i);

				if ((0xA1 <= code) && (code <= 0xFB)) {
					unicode.setCharAt(i, (char) (code + 0xD60));
				}
			}

			return unicode.toString();
		} else {
			return "";
		}
	}

	public static boolean checkDigit(String pinid) {
		boolean result = false;
		if (pinid != null && pinid.length() == 13) {
			int n = 0;
			for (int i = 0; i <= 11; i++) {
				n += Integer.parseInt(pinid.substring(i, i + 1)) * (13 - i);
			}

			int digi = (11 - n % 11) % 10;

			if (pinid.substring(12, 13).equals(String.valueOf(digi)))
				result = true;
		}

		return result;
	}

	public static boolean checkDigitGCode(String pinid) {
		boolean result = false;

		if (pinid != null && pinid.length() == 13) {

			String gCode = pinid.substring(0, 12);
			String gDigit = pinid.substring(12, 13);

			String code;
			int sumTotal = 0;
			int sum = 0;
			int digit;
			for (int i = 1, j = 2; i < 12; i++, j++) {
				Integer y = (13 - i);
				code = gCode.substring(i, j);
				sum = Integer.parseInt(code) * y;
				sumTotal += sum;
			}

			digit = (11 - (sumTotal % 11)) % 10;

			if (gDigit.equals(String.valueOf(digit))) {
				result = true;
			}
		}

		return result;
	}

	private static char[][] numthai = { { '1', '\u0e51' }, { '2', '\u0e52' }, { '3', '\u0e53' }, { '4', '\u0e54' },
			{ '5', '\u0e55' }, { '6', '\u0e56' }, { '7', '\u0e57' }, { '8', '\u0e58' }, { '9', '\u0e59' },
			{ '0', '\u0e50' } };

	public static String arabicToThai(String input) {
		String test = "";
		if (input != null) {
			for (int i = 0; i < input.length(); i++) {
				char check = input.charAt(i);
				for (int j = 0; j < numthai.length; j++) {
					if (check == numthai[j][0]) {
						check = numthai[j][1];
					}
				}
				test += check;
			}
		}
		return test;
	}
	
	public static String thaiToArabic(String input) {
		String test = "";
		if (input != null) {
			for (int i = 0; i < input.length(); i++) {
				char check = input.charAt(i);
				for (int j = 0; j < numthai.length; j++) {
					if (check == numthai[j][1]) {
						check = numthai[j][0];
					}
				}
				test += check;
			}
		}
		return test;
	}

}
