package org.demo.sortingTechniques;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { 4, 6, 2, 1, 30 };
		System.out.print("Elements before sorting : ");
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		mergeSort(arr, 0, arr.length - 1);
		
		System.out.print("Elements after sorting  : ");
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

	static void mergeSort(int[] arr, int l, int h) {

		if (l < h) {
			int m = (l + h) / 2;

			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, h);
			merge(arr, l, h, m);
		}
	}

	static void merge(int[] arr, int l, int h, int m) {

		int a = m - l + 1;
		int b = h - m;

		int[] tempArr1 = new int[a];
		int[] tempArr2 = new int[b];

		for (int i = 0; i < a; ++i)
			tempArr1[i] = arr[l + i];
		for (int j = 0; j < b; ++j)
			tempArr2[j] = arr[m + 1 + j];

		int i = 0, j = 0;
		int k = l;

		while (i < a && j < b) {

			if (tempArr1[i] < tempArr2[j]) {
				arr[k] = tempArr1[i];
				i++;
			} else {
				arr[k] = tempArr2[j];
				j++;
			}
			k++;

		}

		while (i < a) {
			arr[k] = tempArr1[i];
			i++;
			k++;
		}

		while (j < b) {
			arr[k] = tempArr2[j];
			j++;
			k++;
		}
	}

}
