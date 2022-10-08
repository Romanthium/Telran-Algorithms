package com.telran.berlin.algorithms.quick_sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

class Quicksort {
    public static void main(String[] args) {
        int[] array = fillArray(1000, 1, 1000);
        System.out.printf("Unsorted array %s%n", Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.printf("Sorted array %s%n", Arrays.toString(array));
    }

    private static int[] fillArray(int n, int start, int end) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(start, end + 1);
        }
        return array;
    }

    private static void quickSort(int[] array, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        int pivot = partition(array, startIdx, endIdx);
        quickSort(array, startIdx, pivot - 1);
        quickSort(array, pivot + 1, endIdx);
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