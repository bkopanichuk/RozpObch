package oop.lab5.Task3;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        Array arrA = new Array();
        Array arrB = new Array();
        Array arrC = new Array();
        int[] commonSum = new int[3];
        barrierAction bAct = new barrierAction();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, bAct);

        ResolverThread threadA = new ResolverThread(cyclicBarrier, arrA, commonSum, 0);
        ResolverThread threadB = new ResolverThread(cyclicBarrier, arrB, commonSum, 1);
        ResolverThread threadC = new ResolverThread(cyclicBarrier, arrC, commonSum, 2);
    }
}
