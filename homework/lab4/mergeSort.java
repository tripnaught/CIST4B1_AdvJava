package lab4;

import java.util.Arrays;

public class mergeSort {
	public static void main(String[] args) {
		int[] arraySizes = { 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000 };

		for (int arraySize : arraySizes) {
			System.out.printf("Size %d\n", arraySize);
			int[] arr = generateArray(arraySize, false);
			long start = System.nanoTime();
			arr = mSort(arr);
			long end = System.nanoTime();
			printDuration(start, end);
		}

		System.out.println("\n================================================\n");
		
		for (int arraySize : arraySizes) {
			System.out.printf("Size %d (Sorted)\n", arraySize);
			int[] arr = generateArray(arraySize, true);
			long start = System.nanoTime();
			arr = mSort(arr);
			long end = System.nanoTime();
			printDuration(start, end);
		}
	}

	public static int[] mSort(int[] arr) {
		// Base case: 1- or 0-element arrays
		if (arr.length <= 1) {
			return arr;
		}

		
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		
		left = mSort(left);
		right = mSort(right);
		
		int[] result = new int[left.length + right.length];

		int l = 0;
		int r = 0;

		while (l < left.length && r < right.length) {
			if (left[l] <= right[r]) {
				result[l + r] = left[l];
				l++;
			} else if (right[r] <= left[l]) {
				result[l + r] = right[r];
				r++;
			}
		}

		while (l < left.length) {
			result[l + r] = left[l];
			l++;
		}

		while (r < right.length) {
			result[l + r] = right[r];
			r++;
		}

		return result;
	}

	public static int[] generateArray(int size, boolean shouldSort) {
		int[] result = new int[size];

		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;

		for (int i = 0; i < size; i++) {
			result[i] = (int) ((Math.random() * (max - min)) + min);
		}

		if (shouldSort) {
			result = mSort(result);
		}

		return result;
	}

	public static void printDuration(long start, long end) {
		long durationNanoseconds = end - start;
		double durationMilliseconds = ((double) durationNanoseconds / 1_000_000L);
		System.out.printf("Time taken: \u001b[33m%f\u001b[39m ms.\n", durationMilliseconds);
	}
}
