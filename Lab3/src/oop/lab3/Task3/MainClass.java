package oop.lab3.Task3;

import java.util.concurrent.Semaphore;

public class MainClass {


    public static void main(String[] args) {
        boolean tobacco = false;
        boolean paper = false;
        boolean matches = false;
        boolean[] table = {tobacco,paper,matches};
        Semaphore componentsOnTable = new Semaphore(1);

        SmokerA A = new SmokerA(componentsOnTable, table);
        SmokerB B = new SmokerB(componentsOnTable, table);
        SmokerC C = new SmokerC(componentsOnTable, table);
        Pusher P = new Pusher(componentsOnTable, table);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        A.thread.interrupt();
        B.thread.interrupt();
        C.thread.interrupt();
        P.thread.interrupt();

    }
}
