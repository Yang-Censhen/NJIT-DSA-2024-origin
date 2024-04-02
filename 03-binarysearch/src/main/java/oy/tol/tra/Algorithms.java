package oy.tol.tra;

public class Algorithms {
    private Algorithms() {
        // Empty
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static <T> void reverse(T[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            T temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T target, T[] array, int fromIndex, int toIndex) {
        int left = fromIndex;
        int right = toIndex;
        while (left <= right) {
            int middle = (left + right) / 2;
            int cmp = array[middle].compareTo(target);
            if (cmp == 0) {
                return middle;
            } else if (cmp < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> void fastSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int head, int tail) {
        if (head < tail) {
            int pivotIndex = partition(array, head, tail);
            quickSort(array, head, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, tail);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int head, int tail) {
        T pivot = array[tail];
        int i = head - 1;
        for (int j = head; j < tail; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                T tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        T tmp = array[i + 1];
        array[i + 1] = array[tail];
        array[tail] = tmp;
        return i + 1;
    }
}