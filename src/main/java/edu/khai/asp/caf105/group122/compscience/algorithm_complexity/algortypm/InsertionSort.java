package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;

public class InsertionSort implements SortAlgorithm {

    void _sort(int[] arr, int length)
    {
        for (int i = 1; i < length; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    @Override
    public void sort(int[] a, int length) {
        _sort(a, length);
    }
}
