package oop.lab3.Task2;


public class Hairdresser implements Runnable {
    Thread thread;
    boolean debug_on = true;
    volatile Armchair armchair;
    volatile Object queue;


    Hairdresser(Armchair armchair, Object queue) {
        this.armchair = armchair;
        this.queue = queue;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (!thread.isInterrupted()) {
            synchronized (queue) {
                if (debug_on) System.out.println("Hairdresser: Who is next?");
                queue.notify();
            }
            if (debug_on) System.out.println("Hairdresser: Waiting client to sit");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // gets here, when interrupt from main and should finish work
                break;
                // e.printStackTrace();
            }
            if (debug_on) System.out.println("Hairdresser: Is someone on the chair?");
            synchronized (armchair) {
                if (armchair.whoIsSit == null) {
                    if (debug_on) System.out.println("Hairdresser: Nobody, well I will sleep");
                    armchair.isHairdresserSleep = true;

                    try {
                        armchair.wait();
                        if (debug_on) System.out.println("Hairdresser: Someone woke me up");
                    } catch (InterruptedException e) {
                        System.out.println("Catch an exception");
                    }
                }
            }

            synchronized (armchair) {
                if (armchair.whoIsSit != null) {
                    System.out.println("Hairdresser: Cutting client №" + ((Client) (armchair.whoIsSit)).id + "\n");

                    if (debug_on) System.out.println("Hairdresser: Wake up client №" + ((Client) (armchair.whoIsSit)).id + " and carry out him");
                    armchair.notify();
                    armchair.whoIsSit = null;
                } else {
                    if (debug_on) System.out.println("*Chair is free");
                }
            }
        }
    }
}
