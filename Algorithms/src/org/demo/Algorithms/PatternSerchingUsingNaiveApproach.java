package org.demo.Algorithms;

/*Time Complexity (n x m)  */

public class PatternSerchingUsingNaiveApproach {

	public static void main(String[] args) {
		String input = "aaabca";
		String pattern = "abc";

		System.out.println(patternSearch(input, pattern));

	}

	private static boolean patternSearch(String input, String pattern) {

		int j = 0, k = 0;
		int inputLength = input.length();
		int patternLength = pattern.length();
		for (int i = 0; i < input.length(); i++) {
			j = i;
			k = 0;
			while (j < inputLength && k < patternLength) {
				if (input.charAt(j) == pattern.charAt(k)) {

					if (k == patternLength - 1) {
						return true;
					}
					j++;
					k++;
				} else {
					break;
				}
			}

		}

		return false;
	}

}
