package com.telran.berlin.algorithms.tower_of_hanoi;

import java.util.Stack;

public class TowerOfHanoiRecursive extends TowerOfHanoi {

    public static void main(String[] args) {
        TowerOfHanoiRecursive tower = new TowerOfHanoiRecursive(4);
        tower.renewStacks();
        tower.towerOfHanoi(tower.getNumberOfDisks(), start, middle, end);
    }

    TowerOfHanoiRecursive(int numberOfDisks) {
        super(numberOfDisks);
    }

    public void towerOfHanoi(int numberOfDisks, Stack<Integer> start, Stack<Integer> end, Stack<Integer> middle) {
        if (numberOfDisks == 1) {
            end.push(start.pop());
        } else {
            towerOfHanoi(numberOfDisks - 1, start, middle, end);
            end.push(start.pop());
            towerOfHanoi(numberOfDisks - 1, middle, end, start);
        }
    }
}
