package com.telran.berlin.algorithms.tower_of_hanoi;

import java.util.Stack;

public class TowerOfHanoi {
    protected static Stack<Integer> start = new Stack<>();
    protected static Stack<Integer> middle = new Stack<>();
    protected static Stack<Integer> end = new Stack<>();

    protected int numberOfDisks;

    TowerOfHanoi(int numberOfDisks) {
        if (numberOfDisks> 0) {
            this.numberOfDisks = numberOfDisks;
        }
    }

    public int getNumberOfDisks() {
        return numberOfDisks;
    }

    public void renewStacks() {
        middle.clear();
        end.clear();
        for (int i = numberOfDisks; i > 0 ; i--) {
            start.push(i);
        }
    }

    public void printTowerOfHanoi(Stack<Integer> start, Stack<Integer> middle, Stack<Integer> end) {
        System.out.print("Start ");
        for (int s : start) {
            System.out.print(s + " ");
        }
        System.out.print("\b\nMiddle ");
        for (int m : middle) {
            System.out.print(m + " ");
        }
        System.out.print("\b\nEnd ");
        for (int e : end) {
            System.out.print(e + " ");
        }
        System.out.println("\b\n");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
