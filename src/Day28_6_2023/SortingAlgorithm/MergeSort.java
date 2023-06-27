package Day28_6_2023.SortingAlgorithm;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {8, 2, 5, 3, 4, 7, 12, 1, 11};
        mergeSort(array);
    }

    public static void print(int[] Array) {
        for (int i : Array) {
            System.out.print(i);
        }
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) {
            return;
        }
        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        int i = 0;
        int j = 0;
        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0; // Index for the left subarray
        int j = 0; // Index for the right subarray
        int k = 0; // Index for the merged array

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy the remaining elements from the left subarray (if any)
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy the remaining elements from the right subarray (if any)
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
