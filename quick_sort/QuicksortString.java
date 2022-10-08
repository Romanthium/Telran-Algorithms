package com.telran.berlin.algorithms.quick_sort;

public class QuicksortString {
    public static void main(String[] args) {
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        System.out.println(str);
        str = quickSortString(str);
        System.out.println(str);
    }

    private static String quickSortString(String str) {
        char[] chars = str.toCharArray();
        quickSort(chars, 0, chars.length - 1);

        String s = new String(chars);
        return s;
    }

    private static void quickSort(char[] chars, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        int pivot = partition(chars, startIdx, endIdx);
        quickSort(chars, startIdx, pivot - 1);
        quickSort(chars, pivot + 1, endIdx);
    }

    private static int partition(char[] chars, int startIdx, int endIdx) {
        char pivot = chars[startIdx];
        int j = startIdx;
        for (int i = startIdx + 1; i <= endIdx; i++) {
            if (chars[i] < pivot) {
                j++;
                if(i != j) {
                    swap(chars, i, j);
                }
            }
        }
        swap(chars, startIdx, j);
        return j;
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
