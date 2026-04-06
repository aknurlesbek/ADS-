import java.util.Scanner;

public class Task8 {
    public static void generate(int[] arr, int index, int n, int k) {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[index] = i;
            generate(arr, index + 1, n, k);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        generate(arr, 0, n, k);
    }
}