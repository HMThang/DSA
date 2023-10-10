package Lab3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelper(target, 0);
	}

	public int recursiveLinearSearchHelper(int target, int index) {
		if (index == array.length) {
			return -1;
		} else if (array[index] == target) {
			return index;
		}
		return recursiveLinearSearchHelper(target, index + 1);

	}

	public int iterativeBinarySearch(int target) {
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public int recursiveBinarySearch(int target) {
		Arrays.sort(array);
		return recursiveBinarySearchHelper(target, 0, array.length - 1);
	}

	public int recursiveBinarySearchHelper(int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (array[mid] == target) {
			return mid;
		} else if (array[mid] > target) {
			return recursiveBinarySearchHelper(target, left, mid - 1);
		} else {
			return recursiveBinarySearchHelper(target, mid + 1, right);
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		MyArray arr = new MyArray(array);
		System.out.println(arr.iterativeLinearSearch(9));
		System.out.println(arr.recursiveLinearSearch(9));
		System.out.println(arr.iterativeBinarySearch(9));
		System.out.println(arr.recursiveBinarySearch(9));
	}
}
