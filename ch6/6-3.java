public class Main3 {
    public static void quick_sort(int[] array, int start, int end) {
        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && array[left] <= array[pivot]) {
                left++;
            }
            while (right > start && array[right] >= array[pivot]) {
                right--;
            }
            if (left > right) {
                int tmp = array[right];
                array[right] = array[pivot];
                array[pivot] = tmp;
            }
            else {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }

        quick_sort(array, start, right - 1);
        quick_sort(array, right + 1, end);
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quick_sort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
