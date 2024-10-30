package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;// Java Program to implement Gnome Sort

public class GnomeSort implements SortAlgorithm {
    void _sort(int[] arr, int length)
    {
        int index = 0;
        while (index < length) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                int temp = 0;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }

    @Override
    public void sort(int[] a, int length) {
        _sort(a, length);
    }
}
