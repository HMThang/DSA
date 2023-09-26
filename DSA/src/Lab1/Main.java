package Lab1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        MyArray array = new MyArray(arr);
        System.out.println(Arrays.toString(array.mirror()));
        int[] arr1 = {1, 3, 5, 1, 3, 7, 9, 8};
        MyArray array1 = new MyArray(arr1);
        System.out.println(Arrays.toString(array1.removeDuplicates()));
        int[] arr2 = {10, 11, 12, 13, 14, 16, 17, 19, 20};
        MyArray array2 = new MyArray(arr2);
        System.out.println(Arrays.toString(array2.getMissingValues()));
        int[] inputArray = {10, 11, 12, -1, 14, 10, 17, 19, 20};
        int k = 3;
        MyArray array3 = new MyArray(inputArray);
        System.out.println(Arrays.toString(array3.fillMissingValues(k, inputArray)));
    }

}
