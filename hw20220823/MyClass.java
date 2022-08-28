package com.telran.berlin.algorithms.hw20220823;

//Solve and define space complexity.
//Find the element that appears once in a sorted array.
//Given a sorted array in which all elements occur twice (one after the other) and one element appears only once.

public class MyClass {
    public static void main(String args[]) {
        int[] arr = {-1,-1,3,3,4,4,15,15,25,68,68};    // arr[] = 1

        for (int i = 0; i < arr.length; i += 2) {   // int i = 1
            if(arr[i] != arr[i+1]) {
                System.out.println(arr[i]);
                break;
            }
        }
        // S(A) = 1 + 1 = 1
    }
}
