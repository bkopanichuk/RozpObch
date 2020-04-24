package oop.lab4.Task2;

import javafx.print.Printer;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Garden garden = new Garden(10);
        NatureTread natureTread = new NatureTread(readWriteLock, garden);
        GardenerTread gardenerTread = new GardenerTread(readWriteLock, garden);
        PrinterThread print1 = new PrinterThread(readWriteLock, garden, true);
        PrinterThread print2 = new PrinterThread(readWriteLock, garden, false);

        natureTread.start();
        gardenerTread.start();
        print1.start();
        print2.start();
    }
}
