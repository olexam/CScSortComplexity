package edu.khai.asp.caf105.group122.compscience.algorithm_complexity.algortypm;

public class IntroSort implements SortAlgorithm {

    private int[] arr;

    private void swap(int[] arr1, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr1[j];
        arr1[j] = temp;
    }

    private void maxHeap(int i, int heapN, int begin) {
        int temp = arr[begin + i - 1];
        int child;

        while (i <= heapN / 2) {
            child = 2 * i;

            if (child < heapN
                    && arr[begin + child - 1] < arr[begin + child])
                child++;

            if (temp >= arr[begin + child - 1])
                break;

            arr[begin + i - 1] = arr[begin + child - 1];
            i = child;
        }
        arr[begin + i - 1] = temp;
    }

    private void heapify(int begin, int end, int heapN) {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(i, heapN, begin);
    }

    private void heapSort(int begin, int end) {
        int heapN = end - begin;
        heapify(begin, end, heapN);

        for (int i = heapN; i >= 1; i--) {
            swap(arr, begin, begin + i);
            maxHeap(1, i, begin);
        }
    }

    private void insertionSort(int left, int right) {

        for (int i = left; i <= right; i++) {
            int key = arr[i];
            int j = i;

            while (j > left && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
    }

    private int findPivot(int a1, int b1, int c1) {
        int max = Math.max(Math.max(arr[a1], arr[b1]), arr[c1]);
        int min = Math.min(Math.min(arr[a1], arr[b1]), arr[c1]);
        int median = max ^ min ^ arr[a1] ^ arr[b1] ^ arr[c1];
        if (median == arr[a1])
            return a1;
        if (median == arr[b1])
            return b1;
        return c1;
    }

    private int partition(int low, int high) {

        int pivot = arr[high];

        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void sortData(int begin, int end, int depthLimit) {
        if (end - begin > 16) {
            if (depthLimit == 0) {

                this.heapSort(begin, end);
                return;
            }

            depthLimit = depthLimit - 1;
            int pivot = findPivot(begin,
                    begin + ((end - begin) / 2) + 1,
                    end);
            swap(arr, pivot, end);

            int p = partition(begin, end);

            sortData(begin, p - 1, depthLimit);
            sortData(p + 1, end, depthLimit);
        } else {
            insertionSort(begin, end);
        }
    }

    @Override
    public void sort(int[] a, int len) {
        arr = a;
        int depthLimit = (int) (2 * Math.floor(Math.log(len) / Math.log(2)));

        sortData(0, len - 1, depthLimit);
    }
}