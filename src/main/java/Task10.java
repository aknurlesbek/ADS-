public class Task10 {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        Task10 obj = new Task10();

        for (int i = 0; i <= 10; i++) {
            if (obj.isPowerOfTwo(i)) {
                System.out.println(i + " is a power of two");
            } else {
                System.out.println(i + " is not a power of two");
            }
        }

        System.out.println("-------------------");

        for (int i = 10; i <= 32; i += 2) {
            if (obj.isPowerOfTwo(i)) {
                System.out.println(i + " is a power of two");
            } else {
                System.out.println(i + " is not a power of two");
            }
        }
    }
}