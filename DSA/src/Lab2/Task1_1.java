package lab2;

public class Task1_1 {
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) Math.pow(-1, n + 1) * n + getSn1(n - 1);
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		return getSn2(n - 1) * factorial(n);
	}

	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) (getSn3(n - 1) * Math.pow(n, 2));
	}

	public static double getSn4Help(int n) {
		if (n == 0) {
			return 1;
		}
		return Math.pow(getSn4Help(n - 1), 2);
	}

	public static double getSn4(int n) {
		if (n == 0) {
			return 0;
		}
		return getSn4(n - 1) + 1 / getSn4Help(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(getSn1(5));
		System.out.println(getSn2(4));
		System.out.println(factorial(1));
	}
}
