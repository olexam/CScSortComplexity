package edu.khai.asp.caf105.group122.compscience.algorithm_complexity;

import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.BubbleSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.GnomeSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.InsertionSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.JavaSystem;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.MergeSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.QuickSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.SelectionSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.ShellSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.SortAlgorithm;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Main {

    static Random rand = new Random();

    public static void main(String[] args) throws IOException {
        var sizes = new int[]{
                2_500,
                2_500,
                2_500,
                2_500,
                2_500,
                2_500,
                1000,
                2_000,
                3_000,
                5_000,
                8_000,
                13_000,
                21_000,
                34_000,
                55_000};
        int maxLength = Arrays.stream(sizes).max().getAsInt();

        int[] array = randomDataAsArray(maxLength);
        int[] sortedArray = new int[maxLength];

        var algos = new SortAlgorithm[]{
                new BubbleSort(),
                new SelectionSort(),
                new MergeSort(),
                new InsertionSort(),
                new GnomeSort(),
                new ShellSort(),
                new QuickSort(),
                new JavaSystem()};

        System.out.print("Samples\t");

        for (SortAlgorithm algorythm : algos) {
            System.out.print(algorythm.getClass().getSimpleName() + "\t");
        }
        System.out.println();

        for (int size : sizes) {
            System.out.print(size + "\t");
            for (SortAlgorithm algorithm : algos) {
                copyData(array, sortedArray, size);
                var measure = measure(() -> algorithm.sort(sortedArray, size));
                System.out.printf("%.2f\t", measure / 1_000_000d);
            }
            System.out.println();
        }
    }

    private static void copyData(int[] source, int[] target, int size) {
        System.arraycopy(source, 0, target, 0, size);
    }

    private static long measure(Runnable callable) {
        Instant start = Instant.now();
        callable.run();
        Instant end = Instant.now();
        return Duration.between(start, end).toNanos();
    }

    private static int[] randomDataAsArray(int size) {
        int[] integers = new int[size];
        for (int i = 0; i < size; i++) {
            integers[i] = rand.nextInt(Integer.MAX_VALUE);
        }
        return integers;
    }
}