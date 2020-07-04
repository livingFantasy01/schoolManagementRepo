package org.demo.randomquestions;

/*Find a number whose 2nd occurence index is minimum*/

public class FirstDuplicate {

	public static void main(String[] args) {

		int arr[] = {1,2,3,4,7,3,2};
		
		System.out.print("Input array  : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int minIndex = arr.length;
		int[] temp = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			if(temp[a-1] == a && (minIndex > i)) {
				minIndex = i;
			}else {
				temp[a-1] = arr[i];
			}
		}
		System.out.println();
		System.out.println("First Dupicate :"+arr[minIndex]);

	}

}
