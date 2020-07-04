package org.demo.sortingTechniques;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = { 4, 6, 2, 1, 30 };
		System.out.print("Elements before sorting : ");
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		quickSort(arr, 0, arr.length - 1);

		System.out.print("Elements after sorting  : ");
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}

	}

	private static void quickSort(int[] arr, int l, int h) {

		if (l < h) {
			int pivotIndex = partition(arr, l, h);
			quickSort(arr, l, pivotIndex - l);
			quickSort(arr, pivotIndex,h);
		}

	}

	private static int partition(int[] arr, int l, int h) {
		int pivotIndex = l;
		if (l < h) {
			int pivot = arr[l];
			for(int i = 0; i < h; i++) {
				if(arr[i] < pivot) {
					int temp = arr[i];
					arr[i] = pivot;
					arr[pivotIndex] = temp;
					pivotIndex = i;
				}
			}
				
		}
		System.out.println(pivotIndex);
		return pivotIndex;

	}

}
