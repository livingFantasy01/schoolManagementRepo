package org.demo.randomquestions;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MeanMedianAndMode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum = sum + arr[i];
		}

		System.out.println(mean(n, sum));
		System.out.println(median(n, arr));
		System.out.println(mode(n, arr));
		
		sc.close();
	}
	
	private static double mean(int n, int sum) {
		BigDecimal bdc = new BigDecimal(sum/n);
		bdc = bdc.setScale(1,BigDecimal.ROUND_HALF_UP);
		return bdc.doubleValue();
	}
	
	private static double median(int n, int[] arr) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j++) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		BigDecimal bdc;
		if(n%2 == 0) {
			int temp = arr[n/2 - 1]+arr[n/2 + 1];
			bdc = new BigDecimal(temp/2);
		}else {
			bdc = new BigDecimal(arr[n/2 + 1] / 2);
		}
		bdc = bdc.setScale(1);
		return bdc.doubleValue();
	}
	
	private static int mode(int n,  int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			if(map.containsKey(arr[i])) {
				int val = map.get(arr[i]);
				val++;
				map.put(arr[i], val);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		
		int val = Integer.MAX_VALUE;
		int frequency = 0;
		
		Set<Integer> keys = map.keySet();
		
		for(int key : keys) {
			if(key < val && map.get(key) >= frequency) {
				val = key;
				frequency = map.get(key);
			}
		}
		
		return val;
	}

}
