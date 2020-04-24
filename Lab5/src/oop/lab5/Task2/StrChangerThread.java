package oop.lab5.Task2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class StrChangerThread extends Thread {
    String str;
    CyclicBarrier cyclicBarrier;
    boolean isRun = true;
    int abCount = 0;
    private Controller controller;
    StrChangerThread(String str, CyclicBarrier cyclicBarrier, Controller controller){
        this.str = str;
        this.cyclicBarrier = cyclicBarrier;
        this.controller = controller;
        for(int i =0 ; i< str.length(); i++){
            if(str.charAt(i) == 'A' || str.charAt(i) == 'B'){
                abCount++;
            }
        }
    }
    public int getABCount(){
        return abCount;
    }
    public void stopCount(){
        isRun = false;
    }
    @Override
    public void run(){

        while(isRun) {
            int randIndex = (int)(Math.random() * str.length());
            switch(str.charAt(randIndex)){
                case 'A':{
                    str = str.substring(0, randIndex) + 'C' + str.substring(randIndex + 1);
                    abCount--;
                    break;
                }
                case 'B':{
                    str = str.substring(0, randIndex) + 'D' + str.substring(randIndex + 1);
                    abCount--;
                    break;
                }
                case 'C':{
                    str = str.substring(0, randIndex) + 'A' + str.substring(randIndex + 1);
                    abCount++;
                    break;
                }
                case 'D':{
                    str = str.substring(0, randIndex) + 'B' + str.substring(randIndex + 1);
                    abCount++;
                    break;
                }
            }
            controller.getData(abCount);
            System.out.println(Thread.currentThread().getId() + " " + str + " " + abCount);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("----------------");


            isRun = controller.getIsRun();
        }
    }
}
