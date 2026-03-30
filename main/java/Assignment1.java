import java.util.Scanner;

public class Assignment1 {

    // Problem 1: minimum of array
    public static int findMin(int[] arr, int n) {
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // ✅ Problem 2: average of array (АККУРАТНО)
    public static double findAverage(int[] arr, int n) {
        int sum = sumArray(arr, n); // используем вспомогательную функцию
        return (double) sum / n;
    }

    // рекурсивная сумма (по лекции)
    public static int sumArray(int[] arr, int n) {
        if (n == 0) return 0; // base case
        return arr[n - 1] + sumArray(arr, n - 1); // recursion
    }

    // Problem 3: prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        return checkPrime(n, 2);
    }

    public static boolean checkPrime(int n, int i) {
        if (i * i > n) return true;
        if (n % i == 0) return false;
        return checkPrime(n, i + 1);
    }

    // Problem 4: factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Problem 5: fibonacci
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Problem 6: power
    public static long power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    // Problem 7: reverse array
    public static void printReverse(int[] arr, int n) {
        if (n == 0) return;
        System.out.print(arr[n - 1] + " ");
        printReverse(arr, n - 1);
    }

    // Problem 8: digits
    public static boolean isAllDigits(String s, int index) {
        if (index == s.length()) return true;
        if (!Character.isDigit(s.charAt(index))) return false;
        return isAllDigits(s, index + 1);
    }

    // Problem 9: binomial
    public static int binomial(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }

    // Problem 10: GCD
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Problem 11: sum of squares
    public static int sumOfSquares(int n) {
        if (n == 1) return 1;
        return n * n + sumOfSquares(n - 1);
    }

    // Problem 12: sum of array
    public static int sumOfArray(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + sumOfArray(arr, n - 1);
    }

    // Problem 13: sum of integers
    public static int sumOfIntegers(int n) {
        if (n == 1) return 1;
        return n + sumOfIntegers(n - 1);
    }

    // Problem 14: sum of powers
    public static long sumOfPowers(int b, int n) {
        if (n == 0) return 1;
        return power(b, n) + sumOfPowers(b, n - 1);
    }

    // ✅ Problem 15: permutations (ЧИСТО ПО ЛЕКЦИИ)
    public static void permutations(String str) {
        permute(str, "");
    }

    public static void permute(String str, String result) {
        // base case
        if (str.length() == 0) {
            System.out.println(result);
            return;
        }

        // divide & conquer
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            String remaining = str.substring(0, i) + str.substring(i + 1);

            permute(remaining, result + current);
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 1};
        int n = 4;
        int[] t = {1, 4, 6, 2};
        int a=4;

        System.out.println("Problem 1: " + findMin(arr, arr.length));
        System.out.println("Problem 2: " + findAverage(arr, arr.length));

        System.out.print("Problem 3: ");
        if (n <= 1) {
            System.out.println("Neither");
        } else if (isPrime(n)) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }

        System.out.println("Problem 4: " + factorial(5));
        System.out.println("Problem 5: " + fibonacci(17));
        System.out.println("Problem 6: " + power(2, 10));

        System.out.print("Problem 7: ");
        printReverse(t, t.length);
        System.out.println();

        System.out.println("Problem 8: " + isAllDigits("123456", 0));
        System.out.println("Problem 9: " + binomial(7, 3));
        System.out.println("Problem 10: " + gcd(32, 48));
        System.out.println("Problem 11: " + sumOfSquares(4));
        System.out.println("Problem 12: " + sumOfArray(arr, arr.length));
        System.out.println("Problem 13: " + sumOfIntegers(5));
        System.out.println("Problem 14: " + sumOfPowers(4, 3));

        System.out.println("Problem 15:");
        permutations("AB");
    }
}