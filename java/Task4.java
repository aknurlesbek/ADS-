import java.util.Arrays;

public class Task4 {
    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char task : tasks) {
            count[task - 'A']++;
        }

        Arrays.sort(count);

        int maxFrequency = count[25] - 1;
        int idleSlots = maxFrequency * n;

        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(count[i], maxFrequency);
        }

        if (idleSlots > 0) {
            return tasks.length + idleSlots;
        }

        return tasks.length;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        System.out.println("Minimum time: " + leastInterval(tasks, n));
    }
}