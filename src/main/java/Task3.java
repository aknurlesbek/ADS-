import java.util.Scanner;

public class Task3 {
    public static int sumN(int n) {
        if (n == 1) return 1;
        return n + sumN(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumN(n));
    }
}