package com.telran.berlin.algorithms.sum_of_two_numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] arr1 = {-1, 2, 5, 8};
        int[] arr2 = {-3, -1, 0, 2, 6};
        int[] arr3 = {2, 4, 5};
        int[] arr4 = {-2, -1, 1, 2};

        int[][] arrays = {arr1, arr2, arr3, arr4};
        int[] keys = {7, 5, 8, 0};

        check(arrays, keys);

    }

    public static void check(int[][] arrays, int[] keys) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < keys.length; j++) {
                System.out.println("array " + Arrays.toString(arrays[i]) + ", key " + keys[j] + ", " + Arrays.toString(sumOfTwoNumPointers(arrays[i], keys[j])));
            }
        }
    }

    public static int[] sumOfTwoNumNaive(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == key) {
                    return new int[]{array[i], array[j]};
                } else if (array[i] + array[j] > key) {
                    break;
                }
            }
        }
        return new int[0];
    }

    public static int[] sumOfTwoNumPointers(int[] array, int key) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == key) {
                return new int[]{array[i], array[j]};
            }
            if (array[i] + array[j] < key) {
                i++;
            } else {
                j--;
            }
        }
        return new int[0];
    }

    public static int[] sumOfTwoNumSet(int[] array, int key) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int searchNum = key - array[i];
            if (set.contains(searchNum)) {
                return new int[]{searchNum, array[i]};
            }
            set.add(array[i]);
        }
        return new int[0];
    }
}
