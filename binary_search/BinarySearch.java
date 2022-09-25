package com.telran.berlin.algorithms.binary_search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    protected int[] array;
    protected int numberOfElements;

    BinarySearch(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int[] fillingAndSortingArray() {
        Random rand = new Random();
        int[] array = new int[numberOfElements];
        for (int i = 0; i < numberOfElements - 1; i++) {
            array[i] = rand.nextInt(1000);
        }
        Arrays.sort(array);
        return array;
    }
}
