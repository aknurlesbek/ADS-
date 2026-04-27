import java.util.Collections;
import java.util.PriorityQueue;

public class Task7 {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public Task7() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }

        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }

        return left.peek();
    }

    public static void main(String[] args) {
        Task7 medianFinder = new Task7();

        medianFinder.addNum(1);
        medianFinder.addNum(2);

        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(3);

        System.out.println(medianFinder.findMedian());
    }
}