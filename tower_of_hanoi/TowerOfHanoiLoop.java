package com.telran.berlin.algorithms.tower_of_hanoi;

import java.util.Stack;

public class TowerOfHanoiLoop extends TowerOfHanoi {

    TowerOfHanoiLoop(int numberOfDisks) {
        super(numberOfDisks);
    }

    public static void main(String[] args) {
        TowerOfHanoiLoop tower = new TowerOfHanoiLoop(4);
        tower.renewStacks();
        tower.towerOfHanoi(start, middle, end);
    }

    public void towerOfHanoi(Stack<Integer> start, Stack<Integer> middle, Stack<Integer> end) {
        int moves = (int) (Math.pow(2, numberOfDisks) - 1);
        if (numberOfDisks % 2 == 0) {
            Stack<Integer> temp = end;
            end = middle;
            middle = temp;
        }
        for (int i = 1; i <= moves; i++) {
            if (i % 3 == 1) {
                if ((!start.empty() && !end.empty() && (start.peek() < end.peek())) || end.empty()) {
                    end.push(start.pop());
                } else {
                    start.push(end.pop());
                }
            } else if (i % 3 == 2) {
                if ((!start.empty() && !middle.empty() && (start.peek() < middle.peek())) || middle.empty()) {
                    middle.push(start.pop());
                } else {
                    start.push(middle.pop());
                }
            } else if (i % 3 == 0) {
                if ((!middle.empty() && !end.empty() && (middle.peek() < end.peek())) || end.empty()) {
                    end.push(middle.pop());
                } else {
                    middle.push(end.pop());
                }
            }
            if (numberOfDisks % 2 == 0) {
                printTowerOfHanoi(start, end, middle);
            } else {
                printTowerOfHanoi(start, middle, end);
            }
        }
    }
}
