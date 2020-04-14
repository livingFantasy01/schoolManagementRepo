package org.demo.randomquestions;

import java.util.Date;

public class StringFunctionUsingRobinKarp {
	
	private static final int BASE = 1;

	public static void main(String[] args) {
		
		String input = "aacbbabbabbbbbaaaaaaabbbbcacacbcabaccaabbbcaaabbccccbbbcbccccbbcaabaaabcbaacbcbaccaaaccbccbcaacbaccbaacbbabbabbbbbaaaaaaabbbbcacacbcabaccaabbbcaaabbccccbbbcbccccbbcaabaaabcbaacbcbaccaaaccbccbcaacbaccbaacbbabbabbbbbaaaaaaabbbbcacacbcabaccaabbbcaaabbccccbbbcbccccbbcaabaaabcbaacbcbaccaaaccbccbcaacbaccbaacbbabbabbbbbaaaaaaabbbbcacacbcabaccaabbbcaaabbccccbbbcbccccbbcaabaaabcbaacbcbaccaaaccbccbcaacbaccbaacbbabbabbbbbaaaaaaabbbbcacacbcabaccaabbbcaaabbccccbbbcbccccbbcaabaaabcbaacbcbaccaaaccbccbcaacbaccb";
		System.out.println(new Date());
		int maxCount = 0;
		int inputLength = input.length();
		
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				String temp = input.substring(i, j);
				int count = patternSearch(input, temp, inputLength, temp.length());
				 count = count*temp.length();
				if((count) > maxCount) {
					maxCount = count;
				}
			}

		}
		
		System.out.println(maxCount);
		System.out.println(new Date());
		
	}

	private static int  patternSearch(String input, String pattern, int inputLength, int patternLength) {
		int count = 0;
		if (inputLength == patternLength) {
			boolean flag = patternMatcher(input, pattern);
			if(flag)
				count++;
		} else {
			int patternHash = calculateHash(pattern);
			int subStringHash = 0;
			int i = 0;
			while (i < (inputLength - patternLength + 1)) {
				String temp = input.substring(i, i + patternLength);
				if (subStringHash == 0) {
					subStringHash = calculateHash(temp);
					if ((patternHash == subStringHash) && patternMatcher(temp, pattern))
							count++;

				} else {
					subStringHash = calculateNextHash(i - 1, i + patternLength - 1, patternLength, subStringHash,
							input);
					if ((patternHash == subStringHash) && patternMatcher(temp, pattern))
							count++;
				}
				i++;
			}

		}

		return count;
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
