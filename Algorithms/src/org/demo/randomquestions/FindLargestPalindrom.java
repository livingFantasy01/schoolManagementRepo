package org.demo.randomquestions;

public class FindLargestPalindrom {

	public static void main(String[] args) {
		String s = "ababa";
		int length = s.length();
		System.out.println(largestPalindrom(s,length));

	}
	
	private static String largestPalindrom(String s, int length) {
		 
		String output = "";
		for(int i = 0; i < s.length(); i++) {
			
			int j = 0;
			int k = 0;
			
			while((i-j >= 0) && (i+k+1 < length) && s.substring(i-j, i+1).equals(s.substring(i, i+k+1))) {
				String temp = s.substring(i-j, i+k+1);
				//System.out.println(s.substring(i-j, i+1) + "   "+s.substring(i, i+k+1));
				if(temp.length() > output.length()) {
					output = temp;
				}
				j++;
				k++;
				System.out.println(i+ "    "+ s.substring(i-j, i+1));
				
			}
		}
		
		
		
		return output;
	}
	
	/*
	 * private static String largestPalindrom(String s) { String output = "";
	 * for(int i = 0; i < s.length(); i++) {
	 * 
	 * int x = i; int y = i;
	 * 
	 * while(x>0 && y<s.length() && s.substring(x, i+1).equals(s.substring(i, y+1)))
	 * { System.out.println("before "+i + " "+s.substring(x, i+1)+
	 * "   "+s.substring(i, y+1)); x--; y++; System.out.println("after "+ i +
	 * " "+s.substring(x, i+1)+ "   "+s.substring(i, y+1)); } }
	 * 
	 * return output; }
	 */

}
