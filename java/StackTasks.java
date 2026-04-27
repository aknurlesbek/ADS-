import java.util.ArrayList;

public class StackTasks {

    // 1. создание стека
    public static ArrayList<Double> createStack() {
        return new ArrayList<Double>();
    }

    // 2. добавление элемента в стек
    public static void addElement(ArrayList<Double> stack, double value) {
        stack.add(value);
    }

    // 3. удаление элемента из стека
    public static void removeElement(ArrayList<Double> stack) {
        if (!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
        } else {
            System.out.println("Стек пуст");
        }
    }

    // 4. вывод стека на экран
    public static void printStack(ArrayList<Double> stack) {
        if (stack.isEmpty()) {
            System.out.println("Стек пуст");
        } else {
            for (int i = stack.size() - 1; i >= 0; i--) {
                System.out.print(stack.get(i) + " ");
            }
            System.out.println();
        }
    }

    // 5. очистка стека
    public static void clearStack(ArrayList<Double> stack) {
        stack.clear();
    }

    // 6. метод is_empty
    public static boolean isEmpty(ArrayList<Double> stack) {
        return stack.isEmpty();
    }

    // Удалить числа, меньшие среднего арифметического
    public static void removeLessThanAverage(ArrayList<Double> stack) {
        if (stack.isEmpty()) return;

        double sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }

        double average = sum / stack.size();

        ArrayList<Double> newStack = new ArrayList<Double>();

        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) >= average) {
                newStack.add(stack.get(i));
            }
        }

        stack.clear();

        for (int i = 0; i < newStack.size(); i++) {
            stack.add(newStack.get(i));
        }
    }

    public static void main(String[] args) {

        ArrayList<Double> stack = createStack();

        addElement(stack, 2.5);
        addElement(stack, 7.0);
        addElement(stack, 1.5);
        addElement(stack, 9.0);
        addElement(stack, 4.0);

        System.out.println("Созданный стек:");
        printStack(stack);

        System.out.println("Удаление элемента:");
        removeElement(stack);
        printStack(stack);

        System.out.println("Проверка пустоты:");
        System.out.println(isEmpty(stack));

        System.out.println("Удаление меньше среднего:");
        removeLessThanAverage(stack);
        printStack(stack);

        System.out.println("Очистка:");
        clearStack(stack);
        printStack(stack);
    }
}