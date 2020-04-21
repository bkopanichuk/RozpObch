package oop.lab2.Task2;

import java.util.Queue;

public class Ivanov implements Runnable {
    private Thread thread;
    private Stock stock;
    private volatile Queue buffer;
    private Petrov petrov;

    Ivanov(Stock stock, Queue<Integer> buffer, Petrov petrov) {
        this.stock = stock;
        this.buffer = buffer;
        this.petrov = petrov;
        thread = new Thread(this, "Ivanov");
        thread.start();
    }

    public void run() {
        while (!stock.isEmpty()) {
            synchronized (buffer) {
                buffer.add(stock.getStuff());
                System.out.println("From stock to buffer");
            }
//            try { //
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        petrov.stop();
    }
}
