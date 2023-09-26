package Lab1;

import java.util.Arrays;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    //Method mirror that outputs the contents of an array in a
    //reverse order like a mirror
    //Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
    public int[] mirror() {
        int n = array.length;
        int[] result = new int[n * 2];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
            result[n * 2 - i - 1] = array[i];
        }
        return result;
    }

    public int[] countDuplicates() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
        }
        return new int[array.length - count];
    }

    public int[] removeDuplicates() {
        int result[] = countDuplicates();
        boolean[] check = new boolean[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (!check[i]) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] == array[i]) {
                        check[j] = true;
                    }
                }
                result[index++] = array[i];
            }
        }
        return result;
    }

    public int[] countMissingValues() {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] > 1) {
                count++;
            }
        }
        return new int[count];
    }

    public int[] getMissingValues() {
        Arrays.sort(array);
        int[] result = countMissingValues();
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] > 1) {
                result[index++] = array[i] - 1;
            }
        }
        return result;
    }

    public int[] fillMissingValues(int k, int[] inputArray) {
        if (k <= 0 || inputArray == null || inputArray.length == 0) {
            return new int[0];
        }

        int n = inputArray.length;
        int[] outputArray = new int[n];

        for (int i = 0; i < n; i++) {
            if (inputArray[i] == -1) {
                int sum = 0;
                int count = 0;

                // tính toán k lần các phần tử phía trước phần tử đang xét
                for (int j = Math.max(0, i - k); j < i; j++) {
                    if (j >= 0 && inputArray[j] != -1) {
                        sum += inputArray[j];
                        count++;
                    }
                }
                // tính toán k lần các phần tử phía sau phần tử đang xét
                for (int j = i + 1; j <= Math.min(i + k, n - 1); j++) {
                    if (j < n && inputArray[j] != -1) {
                        sum += inputArray[j];
                        count++;
                    }
                }

                // Tính toán trung bình cộng của phần tử đang xét
                if (count > 0) {
                    outputArray[i] = sum / count;
                } else {
                    outputArray[i] = -1;
                }
            } else {
                // Nếu phần tử không bị mất đi(khác -1) thì giữ nguyên
                outputArray[i] = inputArray[i];
            }
        }

        return outputArray;
    }

}
