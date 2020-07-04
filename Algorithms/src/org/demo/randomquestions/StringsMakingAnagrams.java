package org.demo.randomquestions;

public class StringsMakingAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");
		System.out.println(count);
	}

	static int makeAnagram(String a, String b) {
		int count = 0;
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };

		for (int i = 0; i < arr.length; i++) {
			int aCount = 0;
			int bCount = 0;
			for (int j = 0; j < a.length(); j++) {

				if (arr[i] == a.charAt(j))
				{
					aCount++;
				}
			}
			for (int j = 0; j < b.length(); j++) {

				if (arr[i] == b.charAt(j))
				{
					bCount++;
				}

			}
			
			
				if(aCount > bCount)
					count = count + (aCount-bCount);
				else if(aCount < bCount)
					count = count + (bCount-aCount);
					
		}
		
		
		return count;
	}

}
