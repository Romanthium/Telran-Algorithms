package com.telran.berlin.algorithms.hw20220830;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(1071,462)); // 21
        System.out.println(gcd(462,1071)); // 21
    }

    public static int gcd(int a, int b) {
        int temp = 0;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
