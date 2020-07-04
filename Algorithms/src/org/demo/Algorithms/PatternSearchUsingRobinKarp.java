package org.demo.Algorithms;

public class PatternSearchUsingRobinKarp {

	private static final int BASE = 3;

	public static void main(String[] args) {
		String input = "abcdaaa";
		String pattern = "aaa";

		int inputLength = input.length();
		int patternLength = pattern.length();

		System.out.println(patternSearch(input, pattern, inputLength, patternLength));

	}

	private static boolean patternSearch(String input, String pattern, int inputLength, int patternLength) {
		if (inputLength == patternLength) {
			return patternMatcher(input, pattern);
		} else {
			int patternHash = calculateHash(pattern);
			int subStringHash = 0;
			int i = 0;
			while (i < (inputLength - patternLength + 1)) {
				String temp = input.substring(i, i+patternLength);
				if (subStringHash == 0) {
					subStringHash = calculateHash(temp);
					if ((patternHash == subStringHash) && patternMatcher(temp, pattern))
						return true;

				}else {
					subStringHash = calculateNextHash(i - 1, i + patternLength-1, patternLength, subStringHash, input);
					if ((patternHash == subStringHash) && patternMatcher(temp, pattern))
						return true;
				}
				i++;
			}

		}

		return false;
	}

	private static int calculateHash(String str) {
		int hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = (int) (hash + str.charAt(i) * Math.pow(BASE, i));
		}
		return hash;
	}

	private static int calculateNextHash(int oldIndex, int newIndex, int patternLength, int hash, String str) {
		int newHash = hash;
		newHash = (newHash - str.charAt(oldIndex)) / BASE;
		newHash = (int) (newHash + str.charAt(newIndex) * Math.pow(BASE, patternLength - 1));
		return newHash;

	}

	private static boolean patternMatcher(String str1, String str2) {
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != (str2.charAt(i)))
				return false;
		}
		return true;
	}

}
