package Lab4;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    maxIndex = j;
                }
            }
            swap(array, i, maxIndex);
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length == 1) {
            return;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static int[] QuickSort(int[] array, int start, int end, int pivotChoice) {
        if (end - start + 1 <= 1) {
            return array;
        }
        int pivotIndex;
        if (pivotChoice == 0) {
            pivotIndex = getPivot_First(array, start, end);
        } else if (pivotChoice == 1) {
            pivotIndex = getPivot_Last(array, start, end);
        } else if (pivotChoice == 2) {
            pivotIndex = getPivot_MedianOfThree(array, start, end);
        } else if (pivotChoice == 3) {
            pivotIndex = getPivot_Random(array, start, end);
        } else {
            // Xử lý lựa chọn pivot không hợp lệ
            return array;
        }
        swap(array, pivotIndex, end);
        int pivot = array[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (array[i] > pivot) {
                swap(array, i, left);
                left++;
            }
        }
        array[end] = array[left];
        array[left] = pivot;
        QuickSort(array, start, left - 1, pivotChoice);
        QuickSort(array, left + 1, end, pivotChoice);
        return array;
    }

    private static int getPivot_MedianOfThree(int[] array) {
        return getPivot_MedianOfThree(array, 0, array.length - 1);
    }

    private static int getPivot_First(int[] array) {
        return getPivot_First(array, 0, array.length - 1);
    }

    private static int getPivot_Last(int[] array) {
        return getPivot_Last(array, 0, array.length - 1);
    }

    private static int getPivot_Random(int[] array) {
        return getPivot_Random(array, 0, array.length - 1);
    }

    private static int getPivot_MedianOfThree(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (array[left] > array[mid]) {
            swap(array, left, mid);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[mid] > array[right]) {
            swap(array, mid, right);
        }
        return mid;
    }

    private static int getPivot_First(int[] array, int left, int right) {
        return left;
    }

    private static int getPivot_Last(int[] array, int left, int right) {
        return right;
    }

    private static int getPivot_Random(int[] array, int left, int right) {
        Random rand = new Random();
        return rand.nextInt(right - left + 1) + left;
    }

    public static void main(String[] args) {
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //  selectionSort(array);
        //  bubbleSort(array);
        //  insertionSort(array);
        //  mergeSort(array);
        QuickSort(array, 0, array.length - 1, 3);
        System.out.println(Arrays.toString(array));
    }
}
