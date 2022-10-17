package com.telran.berlin.algorithms.substring_search;

import java.util.Arrays;

public class SubstringSearch {
    public static void main(String[] args) {
//        String s = "avada kedavra";
//        System.out.println(Arrays.toString(prefixFunction(s)));   // test for prefixFunction
        String text = "aaatgaacgaaaaacgatctgt";
        String substring = "acga";
        int startIdx = 0;
        while (true) {
            startIdx = substringSearch(text, substring, startIdx);  // 6 - index (7 - position)
            if (startIdx == -1) break;
            System.out.println(startIdx++);
        }
    }

    public static int[] prefixFunction(String text) {
        int stringSize = text.length();
        int[] pf = new int[stringSize];
        int j = 0;
        int i = 1;
        while (i < stringSize) {
            if (text.charAt(i) == text.charAt(j)) {
                pf[i] = j + 1;
                j++;
                i++;
            } else {
                if (j == 0) {
                    pf[i] = 0;
                    i++;
                } else {
                    j = pf[j - 1];
                }
            }
        }
        return pf;
    }

    public static int substringSearch(String text, String substring, int startIdx) {
        int[] pf = prefixFunction(text);
        int i = startIdx;
        int j = 0;
        while (j < substring.length()) {
            if (text.charAt(i) == substring.charAt(j)) {
                i++;
                j++;
            } else {
                if (i >= text.length() - 1) return -1;
                if (j == 0) {
                    i++;
                } else {
                    j = pf[j - 1];
                }
            }
        }
        return i - j;   // for position instead of index add 1 (+1)
    }
}
