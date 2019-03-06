package com.alvin.springbootvue.util;

/**
 * @author: 尹宇
 * @mail yinyu@zving.com
 * @date:2019年3月4日
 */
public class StringUtil {
	public static String replaceEx(String str, String subStr, String reStr) {
		return replaceEx(str, subStr, reStr, false);
	}

	public static String replaceEx(String str, String subStr, String reStr, boolean ignoreCase) {
		if ((str == null) || (str.length() == 0) || (reStr == null)) {
			return str;
		}
		if ((subStr == null) || (subStr.length() == 0) || (subStr.length() > str.length())) {
			return str;
		}
		StringBuilder sb = null;
		int lastIndex = 0;
		for (;;) {
			int index = ignoreCase ? indexOfIgnoreCase(str, subStr, lastIndex) : str.indexOf(subStr, lastIndex);
			if (index < 0) {
				break;
			}
			if (sb == null) {
				sb = new StringBuilder();
			}
			sb.append(str.substring(lastIndex, index));
			sb.append(reStr);

			lastIndex = index + subStr.length();
		}
		if (lastIndex == 0) {
			return str;
		}
		sb.append(str.substring(lastIndex));
		return sb.toString();
	}

	public static int indexOfIgnoreCase(String text, String part, int fromIndex) {
		if (text == null) {
			return -1;
		}
		int plen = part.length();
		if (plen == 0) {
			return fromIndex;
		}
		int len = text.length();
		int max = len - plen;
		if (fromIndex > max) {
			return -1;
		}
		char first = Character.toLowerCase(part.charAt(0));
		for (int i = fromIndex; i <= max; i++) {
			if (Character.toLowerCase(text.charAt(i)) != first) {
				do {
					i++;
				} while ((i <= max) && (Character.toLowerCase(text.charAt(i)) != first));

			}
			if (i <= max) {
				int j = i + 1;
				int end = j + plen - 1;
				for (int k = 1; (j < end) && (Character.toLowerCase(text.charAt(j)) == Character.toLowerCase(part.charAt(k))); k++) {
					j++;

				}
				if (j == end) {
					return i;
				}
			}
		}
		return -1;
	}
}
