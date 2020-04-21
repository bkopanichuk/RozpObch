package oop.lab2.Task2;

import java.util.LinkedList;

public class Truck {
    private volatile LinkedList<Integer> cargo;

    Truck() {
        cargo = new LinkedList<>();
    }

    synchronized void addElement(Integer element) {
        cargo.add(element);
    }

    @Override
    synchronized public String toString() {
        return "Truck {\n" +
                " \t cargo = " + cargo +
                "\n }";
    }
}
