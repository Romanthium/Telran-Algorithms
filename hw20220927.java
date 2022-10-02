package com.telran.berlin.algorithms;

import com.telran.berlin.algorithms.merge_sort.MergeSort;

public class hw20220927 {
    public static void main(String[] args) {
        int[] array1 = {100, 112, 256, 349, 770};
        int[] array2 = {72, 86, 113, 119, 265, 445, 892};
        int[] resultArr = new int[array1.length + array2.length];
        MergeSort.mergeSort(resultArr, array1, array2);
        printElemAtPosition(resultArr, 7);
    }

    private static void printElemAtPosition(int[] array, int k) {
        System.out.printf("Element at Key %s is %s", k, array[k - 1]);
    }
}
