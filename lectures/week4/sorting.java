package week4;

import java.util.Arrays;

public class sorting {
	public static void main(String[] args) {
		int[] numbers = { 8, 2, 4, 1, 5 };

		System.out.println(Arrays.toString(numbers));

		// quickSort(numbers, 0, numbers.length - 1);
		numbers = mergeSort(numbers);

		System.out.println(Arrays.toString(numbers));

	}

	public static void quickSort(int[] arr, int low, int high) {
		// base case: arr is 1 or smaller
		// if low = high, array length is exactly 1
		// if low > high, array length is 0
		if (low >= high) {
			return;
		}

		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		int newPivotIndex = i + 1;
		quickSort(arr, low, newPivotIndex - 1);
		quickSort(arr, newPivotIndex + 1, high);
	}

	public static int[] mergeSort(int[] arr) {
		// Base case: 1- or 0-element arrays
		if (arr.length <= 1) {
			return arr;
		}

		int[] result = new int[arr.length];

		// split step
		// get the middle index with integer division (round down)
		int mid = arr.length / 2;
		// create array left from 0 to mid
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		// create array right from mid + 1 to length - 1
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);

		System.out.print("L: ");
		System.out.println(Arrays.toString(left));
		System.out.print("R: ");
		System.out.println(Arrays.toString(right));

		// Recursive case
		// call merge sort on array left
		left = mergeSort(left);
		// call merge sort on array right
		right = mergeSort(right);

		// iterate through left and right using a leftCounter and a rightCounter
		int l = 0;
		int r = 0;
		// merge step
		// if leftCounter = size of left && rightCounter = size of right: break;
		while (l < left.length && r < right.length) {
			// weave them into arr
			if (left[l] <= right[r]) {
				System.out.printf("%d < %d\n", left[l], right[r]);
				result[l + r] = left[l];
				System.out.println(Arrays.toString(result));
				l++;
			} else if (right[r] <= left[l]) {
				System.out.printf("%d > %d\n", left[l], right[r]);
				result[l + r] = right[r];
				System.out.println(Arrays.toString(result));
				r++;
			}
			// each time we add from left or right, increment its counter
		}

		// if either left or right finishes first, i still have to run the loop on the other.
		// if, for example, `left` is now exhausted, `l` will never be less than left.length again,
		// so the first while loop is skipped and only the `right` loop will run to exhaust `right`.
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
}
