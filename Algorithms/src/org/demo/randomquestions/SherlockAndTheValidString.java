package org.demo.randomquestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SherlockAndTheValidString {

	public static void main(String[] args) {
		
	}
	
	static String isValid(String s) {
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(!map.containsKey(ch)) {
				map.put(s.charAt(i), 1);
			}else {
				int temp = map.get(ch);
				temp++;
				map.put(ch, temp);
			}
			
		}
		Set<Character> keys = map.keySet();
		int count = 0;
		int out = 0;
		for(char ch : keys) {
			int freq = map.get(ch);
			if(count == 0) {
				count = freq;
			}else {
				if(count != freq)
					out++;
			}
		}
		
		if(out == 1)
	
    }

}
