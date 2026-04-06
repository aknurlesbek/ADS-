import java.util.ArrayList;

public class QueueTasks {

    public static ArrayList<Integer> createQueue() {
        return new ArrayList<Integer>();
    }

    public static void addElement(ArrayList<Integer> queue, int value) {
        queue.add(value);
    }

    public static void removeElement(ArrayList<Integer> queue) {
        if (!queue.isEmpty()) {
            queue.remove(0);
        } else {
            System.out.println("Очередь пуста");
        }
    }

    public static void printQueue(ArrayList<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
        } else {
            for (int i = 0; i < queue.size(); i++) {
                System.out.print(queue.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void clearQueue(ArrayList<Integer> queue) {
        queue.clear();
    }

    public static boolean isEmpty(ArrayList<Integer> queue) {
        return queue.isEmpty();
    }

    public static void removeEvenNumbers(ArrayList<Integer> queue) {
        ArrayList<Integer> newQueue = new ArrayList<Integer>();

        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) % 2 != 0) {
                newQueue.add(queue.get(i));
            }
        }

        queue.clear();

        for (int i = 0; i < newQueue.size(); i++) {
            queue.add(newQueue.get(i));
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> queue = createQueue();

        System.out.println("Создание очереди:");
        printQueue(queue);

        System.out.println("Добавление элементов в очередь:");
        addElement(queue, 2);
        addElement(queue, 5);
        addElement(queue, 8);
        addElement(queue, 3);
        addElement(queue, 10);
        printQueue(queue);

        System.out.println("Удаление элемента:");
        removeElement(queue);
        printQueue(queue);

        System.out.println("Проверка пустоты:");
        System.out.println(isEmpty(queue));

        System.out.println("Удаление четных чисел:");
        removeEvenNumbers(queue);
        printQueue(queue);

        System.out.println("Очистка очереди:");
        clearQueue(queue);
        printQueue(queue);

        System.out.println("Проверка после очистки:");
        System.out.println(isEmpty(queue));
    }
}