package org.demo.randomquestions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MorganAndAString {

	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\TESTDATA\\morgan.txt"));
System.out.println("here'");
        int t = Integer.parseInt(args[0]);
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String a = args[1];

            String b =args[2];

            String result = morganAndString(a, b);
            bufferedWriter.write(result);
            bufferedWriter.close();
System.out.println("done");
        }

       

        //scanner.close();
    }
	
	static String morganAndString(String a, String b) {
		String finalString = "";
		int i = 0;
		int j = 0;
		int aLength = a.length();
		int bLength = b.length();
		
		while(i < aLength && j < bLength) {
			if(a.charAt(i) > b.charAt(j)) {
				finalString = finalString + b.charAt(j);
				j++;
			}
			else {
				finalString = finalString + a.charAt(i);
				i++;
			}
		}
		
		if(i < aLength)
			finalString = finalString + a.substring(i,aLength);
		if(j < bLength)
			finalString = finalString + b.substring(j,bLength);
		
		return finalString;

    }

}
