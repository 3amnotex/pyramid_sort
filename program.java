public class program {
    public static void main(String[] args) {
        int[] arr = { 36, 24, 13, 5, 18, 2, 48, 47, 9 };
        int n = arr.length;

        System.out.println("Исходный массив:");
        printArray(arr);

        heapSort(arr);

        System.out.println("\nОтсортированный массив:");
        printArray(arr);
    }

    // Функция для сортировки массива с использованием пирамиды
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение максимальной пирамиды (max heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлекаем элементы из пирамиды и сортируем массив
        for (int i = n - 1; i >= 0; i--) {
            // Обмен значениями корня (максимального элемента) и последнего элемента
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем heapify на уменьшенной пирамиде
            heapify(arr, i, 0);
        }
    }

    // Функция для преобразования поддерева с корнем в пирамиду с заданным корнем
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            // Обмен значениями корня и наибольшего элемента
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно применяем heapify к поддереву
            heapify(arr, n, largest);
        }
    }

    // Функция для вывода массива на экран
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
