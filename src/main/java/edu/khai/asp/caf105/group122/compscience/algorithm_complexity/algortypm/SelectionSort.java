package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;

public class SelectionSort implements SortAlgorithm {

    void _sort(int[] arr, int length){
        for (int i = 0; i < length - 1; i++) {

            int minIdx = i;

            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIdx]) {

                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    @Override
    public void sort(int[] a, int length) {
        _sort(a, length);
    }
}