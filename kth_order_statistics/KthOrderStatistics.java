package com.telran.berlin.algorithms.kth_order_statistics;

public class KthOrderStatistics {
    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 10, 9, 7, 12, 8, 2, 15};  // 1, 2, 4, 7, 8, 9, 10, 12, 15

        System.out.printf("3rd minimal element is %d ", array[kthOrderStatistics(array, 3)]);       // 4
        System.out.printf("\n4th minimal element is %d ", array[kthOrderStatistics(array, 4)]);     // 7
        System.out.printf("\n6th minimal element is %d ", array[kthOrderStatistics(array, 6)]);     // 9
        System.out.printf("\n9th minimal element is %d ", array[kthOrderStatistics(array, 9)]);     // 15

    }

    private static int kthOrderStatistics(int[] array, int key) {
        if (key > array.length) {
            throw new RuntimeException("Index is out of range " + key);
        }
        return kthOrderStatistics(array, 0, array.length - 1, key);
    }

    private static int kthOrderStatistics(int[] array, int startIdx, int endIdx, int key) {
        int pivot = partition(array, startIdx, endIdx);
        if (pivot == key - 1) {
            return pivot;
        }
        if (pivot < key - 1) {
            return kthOrderStatistics(array, pivot + 1, endIdx, key);
        }
        return kthOrderStatistics(array, startIdx, pivot - 1, key);
    }

    private static int partition(int[] array, int startIdx, int endIdx) {
        int pivot = array[startIdx];
        int j = startIdx;
        for (int i = startIdx + 1; i <= endIdx; i++) {
            if (array[i] < pivot) {
                j++;
                if (i != j) {
                    swap(array, i, j);
                }
            }
        }
        swap(array, startIdx, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
