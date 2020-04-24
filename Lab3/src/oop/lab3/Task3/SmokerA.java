package oop.lab3.Task3;

import java.util.concurrent.Semaphore;

public class SmokerA implements Runnable {
    Thread thread;
    Semaphore componentsOnTable;
    volatile boolean[] table;

    SmokerA(Semaphore comp, boolean[] table){
        componentsOnTable = comp;
        this.table = table;
        thread = new Thread(this);
        thread.start();
        System.out.println("SmokerA started");
    }

    public void run() {
        while (true) {
            try {
                componentsOnTable.acquire();
                if (table[0] && table[1] && !table[2]){
                    System.out.println("SmokerA закрутил и закурил");
                    Thread.sleep(500);
                    table[0] = false;
                    table[1] = false;
                    table[2] = false;
                    componentsOnTable.release();
                    Thread.yield();
                } else {
                    componentsOnTable.release();
                    Thread.yield();
                }
            } catch (InterruptedException e) {
                System.out.println("SmokerA ends his work");
            }
        }
    }
}
