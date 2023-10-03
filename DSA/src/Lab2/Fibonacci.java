package lab2;

public class Fibonacci {
    public static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return getFibonacci(n - 2) + getFibonacci(n - 1);
    }

    public static void printFibonacci(int n) {
        if (n == 0) {
            return;
        }
        printFibonacci(n - 1);
        System.out.print(getFibonacci(n) + " ");
    }

    public static void main(String[] args) {
        printFibonacci(7);
    }
}
