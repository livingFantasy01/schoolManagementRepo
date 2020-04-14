package org.demo.randomquestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringFunctionCalculation {

	public static void main(String[] args) {

		String input = "aaaaaa";
		//String input = "aaaaaa";
		int maxCount = 1;
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				map.put(input.substring(i, j), 0);
			}

		}

		Set<String> keys = map.keySet();

		for (String key : keys) {
			int count = findTotalOccurences(input, key);
			
			if ((count * key.length()) > maxCount) {
				maxCount = count * key.length();
				System.out.println(key + "  " + count);
			}
		}

		System.out.println(maxCount);

	}

	private static int findTotalOccurences(String input, String subString) {

		int tempCount = 0;
		int inputLength = input.length();
		int subStringLength = subString.length();
		int[] lps = new int[subStringLength];
		int i = 1, j = 0;

		while (i < subStringLength) {
			if (subString.charAt(i) == subString.charAt(j)) {
				lps[i] = j + 1;
				j++;
			} else {
				j = 0;
				if (subString.charAt(i) == subString.charAt(j)) {
					lps[i] = j + 1;
				}
			}
			i++;
		}

		i = 0;
		j = 0;
		int startIndex = 0;
		while (i < inputLength) {
			if (input.charAt(i) == subString.charAt(j)) {
				j++;
				if (j == subStringLength) {
					tempCount++;
					j = 0;
					i = startIndex++;
				}
			} else {
				/*
				 * if (j != 0) { j = lps[j - 1]; }
				 */
				if (input.charAt(i) == subString.charAt(j)) {
					j++;
				}
				startIndex++;
			}
			i++;
		}
		return tempCount;
	}
}
