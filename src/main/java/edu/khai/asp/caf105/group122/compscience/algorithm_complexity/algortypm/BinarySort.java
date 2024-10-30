package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;

public class BinarySort implements SortAlgorithm {

    static int binarySearch(int[] a, int item, int low,
                            int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item == a[mid])
                return mid + 1;
            else if (item > a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    @Override
    public void sort(int[] a, int len) {
        int i, loc, j, selected;

        for (i = 1; i < len; ++i) {
            j = i - 1;
            selected = a[i];

            loc = binarySearch(a, selected, 0, j);

            while (j >= loc) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = selected;
        }
    }
}