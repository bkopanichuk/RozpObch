package oop.lab5.Task2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int numThreads = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numThreads);
        Controller controller = new Controller(numThreads);
        StrChangerThread strChangerThread1 = new StrChangerThread("DCAB", cyclicBarrier, controller);
        StrChangerThread strChangerThread2 = new StrChangerThread("CAAC", cyclicBarrier, controller);
        StrChangerThread strChangerThread3 = new StrChangerThread("DCAD", cyclicBarrier, controller);
        StrChangerThread strChangerThread4 = new StrChangerThread("CCAB", cyclicBarrier, controller);
        strChangerThread1.start();
        strChangerThread2.start();
        strChangerThread3.start();
        strChangerThread4.start();

       /* boolean isEnd = false;
        while(!isEnd){
            int first = strChangerThread1.getABCount();
            int second = strChangerThread2.getABCount();
            int third = strChangerThread3.getABCount();
            int forth = strChangerThread4.getABCount();
            if(first == second){
                strChangerThread1.stopCount();
                strChangerThread2.stopCount();
                strChangerThread3.stopCount();
                strChangerThread4.stopCount();
                isEnd = true;
            }
            cyclicBarrier.await();
        }*/
    }
}
