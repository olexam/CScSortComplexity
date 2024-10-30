package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;

public class HeapSort implements SortAlgorithm {

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    @Override
    public void sort(int[] a, int len) {

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(a, len, i);
        }

        for (int i = len - 1; i > 0; i--) {

            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, i, 0);
        }
    }
}