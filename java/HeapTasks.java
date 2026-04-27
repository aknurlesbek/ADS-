public class HeapTasks {

    // Heapify (Max Heap)
    public static void heapify(int[] arr, int n, int i) {

        int largest = i;           // текущий элемент
        int left = 2 * i + 1;      // левый ребенок
        int right = 2 * i + 2;     // правый ребенок

        // если левый больше
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // если правый больше
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // если не корень — меняем и продолжаем
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest); // рекурсия
        }
    }

    // вывод массива
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {4, 10, 3, 5, 1};

        System.out.println("До heapify:");
        printArray(arr);

        // вызываем heapify для корня
        heapify(arr, arr.length, 0);

        System.out.println("После heapify:");
        printArray(arr);
    }
}