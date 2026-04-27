import java.util.Collections;
import java.util.PriorityQueue;

public class Task1 {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (x != y) {
                maxHeap.add(y - x);
            }
        }

        if (maxHeap.isEmpty()) {
            return 0;
        }

        return maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};

        System.out.println("Last stone weight: " + lastStoneWeight(stones));
    }
}