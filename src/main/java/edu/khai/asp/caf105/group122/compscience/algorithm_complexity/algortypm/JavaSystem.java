package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;

import java.util.Arrays;

public class JavaSystem implements SortAlgorithm {
    @Override
    public void sort(int[] a, int length) {
        Arrays.sort(a, 0, length);
    }
}
