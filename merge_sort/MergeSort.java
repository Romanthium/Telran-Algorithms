package com.telran.berlin.algorithms.merge_sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = fillArray(1000, 1, 1000);
        System.out.printf("Unsorted array %s%n", Arrays.toString(arr));
        merge(arr, 0, arr.length - 1);
        System.out.printf("Sorted array %s", Arrays.toString(arr));
    }

    private static int[] fillArray(int n, int start, int end) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(start, end + 1);
        }
        return array;
    }

    public static void merge(int[] array, int startIdx, int endIdx) {
        if (array.length == 1) {
            return;
        }

        int midIdx = startIdx + (endIdx - startIdx) / 2;
        int[] leftArray = new int[midIdx + 1];
        int[] rightArray = new int[array.length - leftArray.length];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[i + midIdx + 1];
        }

        merge(leftArray, 0, leftArray.length - 1);
        merge(rightArray, 0, rightArray.length - 1);
        mergeSort(array, leftArray, rightArray, startIdx);

    }

    public static void mergeSort(int[] array, int[] leftArr, int[] rightArr, int startIdx) {
        int leftIdx = 0;
        int rightIdx = 0;
        int leftLength = leftArr.length;
        int rightLength = rightArr.length;
        int length = leftLength + rightLength;
        for (int i = startIdx; i < length; i++) {
            if (leftIdx >= leftLength) {
                array[i] = rightArr[rightIdx];
                rightIdx++;
            } else if (rightIdx >= rightLength) {
                array[i] = leftArr[leftIdx];
                leftIdx++;
            } else if (leftArr[leftIdx] <= rightArr[rightIdx]) {
                array[i] = leftArr[leftIdx];
                leftIdx++;
            } else {
                array[i] = rightArr[rightIdx];
                rightIdx++;
            }
        }
    }
}
