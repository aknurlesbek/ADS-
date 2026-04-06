import java.util.Scanner;

public class Task5 {
    public static void reverseNumbers(Scanner sc, int n) {
        if (n == 0) return;

        int x = sc.nextInt();
        reverseNumbers(sc, n - 1);
        System.out.print(x + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        reverseNumbers(sc, n);
    }
}