package org.demo.randomquestions;

public class SparseArrays {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int[] matchingStrings(String[] strings, String[] queries) {
			int stringsLen = strings.length;
			int queriesLen = queries.length;
			int[] output = new int[queriesLen];
			
			for(int i = 0 ; i < queriesLen; i++) {
				String query = queries[i];
				int count = 0;
				for(int j = 0 ; j < stringsLen; j++) {
					if(strings[j].equals(query)) {
						count++;
					}
				}
				output[i] = count;
			}
			
			return output;
    }
	
	
}
