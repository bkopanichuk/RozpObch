package oop.lab5.Task1;

public class Barrier {
    public int arrived = 0;
    public int threadCount = 0;
    public int unarrived = 0;

    public synchronized void register() {
        //System.out.println("threadCount " + threadCount);
        threadCount++;
        unarrived++;
    }

    public synchronized void deregister() {
        if (arrived > 0) {
            return;
        }
        threadCount--;
        unarrived++;

    }

    public synchronized void arriveAndWait() {
        arrived++;
        unarrived--;
        //System.out.println("arrived " + arrived);
        if (arrived == threadCount) {
            notifyAll();
        }
        while (arrived != threadCount) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("in barrier" + Thread.currentThread().getId());
        unarrived++;
        if (unarrived == threadCount) {
            System.out.println("Clear");
            arrived = 0;
        }

    }
}