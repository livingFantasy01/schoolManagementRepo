package org.demo.randomquestions;

/*You have a sorted array of integers. Write a function that returns a sorted array
containing the square of those integers.

Input : -10000 <= n <=10000 
*/
public class SortedSquaredArray {

	public static void main(String[] args) {
	
		int arr[] = {-9,-7,-6,-1, 2, 5, 8};
		
		System.out.print("Input array  : ");
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
		
		int i = 0, j = arr.length-1, k = arr.length-1;
		int[] output = new int[arr.length];
		
		int temp = 0;
		while(i <= j) {
			if(Math.abs(arr[i]) >= Math.abs(arr[j])) {
				temp = arr[i];
				
				output[k] = temp*temp;
				i++;
			}else {
				temp = arr[j];
				output[k] = temp*temp;
				j--;
			}
			k--;
		}
		System.out.println();
		System.out.print("Output array : ");
		for (int x = 0; x < output.length; x++) {
			System.out.print(output[x] + " ");
		}

	}

}
