package edu.khai.asp.caf105.group122.compscience.algorithm_complexity;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 2)
@BenchmarkMode(Mode.SingleShotTime)
@Measurement(iterations = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BM {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void BubbleSort(ExecutionPlan executionPlan) {
        executionPlan.getAlgorithm(0).sort(executionPlan.sortedArray, executionPlan.samples);
    }

    @Benchmark
    public void SelectionSort(ExecutionPlan executionPlan) {
        executionPlan.getAlgorithm(1).sort(executionPlan.sortedArray, executionPlan.samples);
    }

    @Benchmark
    public void MergeSort(ExecutionPlan executionPlan) {
        executionPlan.getAlgorithm(2).sort(executionPlan.sortedArray, executionPlan.samples);
    }

    @Benchmark
    public void InsertionSort(ExecutionPlan executionPlan) {
        executionPlan.getAlgorithm(3).sort(executionPlan.sortedArray, executionPlan.samples);
    }

    @Benchmark
    public void GnomeSort(ExecutionPlan executionPlan) {
        executionPlan.getAlgorithm(4).sort(executionPlan.sortedArray, executionPlan.samples);
    }

    @Benchmark
    public void ShellSort(ExecutionPlan executionPlan) {
        executionPlan.getAlgorithm(5).sort(executionPlan.sortedArray, executionPlan.samples);
    }

    @Benchmark
    public void QuickSort(ExecutionPlan executionPlan) {
        executionPlan.getAlgorithm(6).sort(executionPlan.sortedArray, executionPlan.samples);
    }

    @Benchmark
    public void JavaSystem(ExecutionPlan executionPlan) {
        executionPlan.getAlgorithm(7).sort(executionPlan.sortedArray, executionPlan.samples);
    }

}