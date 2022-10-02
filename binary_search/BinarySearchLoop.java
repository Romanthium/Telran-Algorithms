package com.telran.berlin.algorithms.binary_search;

public class BinarySearchLoop extends BinarySearch {
    public BinarySearchLoop(int numberOfElements) {
        super(numberOfElements);
    }

    public static void main(String[] args) {
        BinarySearchLoop bs = new BinarySearchLoop(100000);
        bs.array = bs.fillingAndSortingArray();

        long startTime = System.currentTimeMillis();
        System.out.println("Key found at index " + bs.binarySearchLoop(bs.array, 0, bs.array.length - 1, 456));
        long endTime = System.currentTimeMillis();
        System.out.println("Running time for " + bs.getClass().getSimpleName() + " is " + (endTime - startTime) + " ms");
    }

    public int binarySearchLoop(int[] array, int leftIdx, int rightIdx, int key) {
        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;

            if (array[midIdx] == key) {
                return midIdx;
            } else if (array[midIdx] < key) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }
        }
        return -1;
    }
}
