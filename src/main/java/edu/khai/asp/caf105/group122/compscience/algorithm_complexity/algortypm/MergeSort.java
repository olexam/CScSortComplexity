package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;// Java program for Merge Sort

public class MergeSort implements SortAlgorithm {

    void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        for (int i = 0; i < n1; ++i) lArr[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) rArr[j] = arr[m + 1 + j];

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }

    void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    @Override
    public void sort(int[] arr, int length) {
        sort(arr, 0, length - 1);
    }
}