package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;

public class BubbleSort implements SortAlgorithm {

    void _sort(int[] arr, int length){
        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    @Override
    public void sort(int[] a, int length) {
        _sort(a,length);
    }
}
