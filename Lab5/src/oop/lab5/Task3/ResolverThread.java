package oop.lab5.Task3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ResolverThread implements Runnable {
    CyclicBarrier cyclicBarrier;
    Array arr;
    volatile int[] commonSum;
    Thread thread;
    int threadId;

    ResolverThread(CyclicBarrier cyclicBarrier, Array arr, int[] commonSum, int threadId){
        this.cyclicBarrier = cyclicBarrier;
        this.arr = arr;
        this.commonSum = commonSum;
        this.threadId = threadId;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            int sum = arr.getSum();
            System.out.println("Thread №" + threadId + " = " + arr.print() + " Sum = " + sum );

            synchronized (commonSum) {
                commonSum[threadId] = sum;
            }

            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            synchronized (commonSum) {
                if (sum == commonSum[0] && sum == commonSum[1] && sum == commonSum[2]) {
                    System.out.println("All sums are equal for thread №" + threadId);
                    thread.interrupt();
                } else {
                    int avg = (commonSum[0] + commonSum[1] + commonSum[2]) / 3;
                    if (sum > avg) {
                        arr.makeChange(false);
                    } else if (sum < avg) {
                        arr.makeChange(true);
                    }
                }
            }
        }
    }
}
