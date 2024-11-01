package edu.khai.asp.caf105.group122.compscience.algorithm_complexity;

import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.BinarySort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.BubbleSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.GnomeSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.HeapSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.InsertionSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.IntroSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.JavaSystem;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.MergeSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.QuickSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.SelectionSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.ShellSort;
import edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm.SortAlgorithm;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Random;

@State(Scope.Benchmark)
public class ExecutionPlan {

    static Random rand = new Random();
    int[] array = randomDataAsArray(55000);
    int[] sortedArray = new int[55000];

    SortAlgorithm buble = new BubbleSort();
    SortAlgorithm selection = new SelectionSort();
    SortAlgorithm quick = new QuickSort();
    SortAlgorithm merge = new MergeSort();
    SortAlgorithm insertion = new InsertionSort();
    SortAlgorithm shell = new ShellSort();
    SortAlgorithm java = new JavaSystem();
    SortAlgorithm gnome = new GnomeSort();
    SortAlgorithm heap = new HeapSort();
    SortAlgorithm intro = new IntroSort();
    SortAlgorithm binary = new BinarySort();

    @Param({ "1000", "2000", "3000", "5000", "8000", "13000", "21000", "34000", "55000" })
    public int samples;

    public static void copyData(int[] source, int[] target, int size) {
        System.arraycopy(source, 0, target, 0, size);
    }

    public static int[] randomDataAsArray(int size) {
        int[] integers = new int[size];
        for (int i = 0; i < size; i++) {
            integers[i] = rand.nextInt(Integer.MAX_VALUE);
        }
        return integers;
    }

    @Setup(Level.Iteration)
    public void setUp() {
        copyData(array, sortedArray, samples);
    }
}
