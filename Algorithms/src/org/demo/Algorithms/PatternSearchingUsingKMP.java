package org.demo.Algorithms;

/*Time Complexity (n + m)  */

public class PatternSearchingUsingKMP {

	public static void main(String[] args) {
		String input = "abcabcddd";
		String pattern = "abc";

		System.out.println(patternSearch(input, pattern));

	}
	
	private static boolean patternSearch(String input, String pattern) {
		
		int inputLength = input.length();
		int patternLength = pattern.length();
		int[] lps = new int[patternLength];
		int i = 1, j = 0;
		
		while(i < patternLength) {
			if(pattern.charAt(i) == pattern.charAt(j)) {
				lps[i] = j+1;
				j++;
			}
			else {
				j = 0;
				if(pattern.charAt(i) == pattern.charAt(j)) {
					lps[i] = j+1;
				}
			}
			i++;	
		}
		
		i = 0; j = 0;
		
		while(i < inputLength && j < patternLength) {
			
			if(input.charAt(i) == pattern.charAt(j)) {
				j++;
				if(j == patternLength) {
					return true;
				}
			}
			else {
				if(j!= 0) {
				j = lps[j-1];
				}
				if(input.charAt(i) == pattern.charAt(j)) {
					j++;
				}
			}
			i++;
			
		}
		
		return false;
	}

}
