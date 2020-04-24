package oop.lab3.Task3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pusher implements Runnable {
    private Random rnd = new Random();
    Semaphore componentsOnTable;
    volatile boolean[] table;
    Thread thread;

    Pusher(Semaphore comp, boolean[] table){
        componentsOnTable = comp;
        this.table = table;
        thread = new Thread(this);
        thread.start();
        System.out.println("Pusher started");
    }

    @Override
    public void run() {
        while (true) {
            int temp = rnd.nextInt(3);
            try {
                componentsOnTable.acquire();
                if (table[0] == false && table[1] == false && table[2] == false) {
                    if (temp == 0) {
                        table[0] = false;
                        table[1] = true;
                        table[2] = true;
                        System.out.println("Pusher is pushing paper and matches");
                    }
                    if (temp == 1) {
                        table[0] = true;
                        table[1] = false;
                        table[2] = true;
                        System.out.println("Pusher is pushing tobacco and matches");
                    }
                    if (temp == 2) {
                        table[0] = true;
                        table[1] = true;
                        table[2] = false;
                        System.out.println("Pusher is pushing tobacco and paper");
                    }
                }
                componentsOnTable.release();
                Thread.yield();

            } catch (InterruptedException e) {
                System.out.println("Pusher ends his work");
            }
        }
    }
}