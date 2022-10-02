package com.telran.berlin.algorithms.binary_search;

public class BinarySearchRecursion extends BinarySearch {
    public BinarySearchRecursion(int numberOfElements) {
        super(numberOfElements);
    }

    public static void main(String[] args) {
        BinarySearchRecursion bs = new BinarySearchRecursion(100000);
        bs.array = bs.fillingAndSortingArray();

        long startTime = System.currentTimeMillis();
        System.out.println("Key found at index " + bs.binarySearchRecursion(bs.array, 0, bs.array.length - 1, 456));
        long endTime = System.currentTimeMillis();
        System.out.println("Running time for " + bs.getClass().getSimpleName() + " is " + (endTime - startTime) + " ms");
    }

    public int binarySearchRecursion(int[] arr, int leftIdx, int rightIdx, int key) {
        if (rightIdx >= leftIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;  // ------------

            if (arr[midIdx] == key) {
                return midIdx;
            }

            if (arr[midIdx] > key) {
                return binarySearchRecursion(arr, leftIdx, midIdx - 1, key);
            }
            return binarySearchRecursion(arr,  midIdx + 1, rightIdx, key);
        }
        return -1;
    }
}
