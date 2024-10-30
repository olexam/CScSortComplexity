package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;

public class ShellSort implements SortAlgorithm {

    public void sort(int[] arr, int length) {

        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }
}
