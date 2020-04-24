package oop.lab5.Task3;

import java.util.Random;

public class Array {
    int[] arr;
    Random rand;

    Array(){
        rand = new Random();
        arr = new int[10];
        init();
    }

    void init(){
        for (int i = 0; i < 10; i++){
            arr[i] = rand.nextInt(100);
        }
    }

    int getSum(){
        int sum = 0;
        for (int i = 0; i < 10; i++){
            sum += arr[i];
        }
        return sum;
    }

    void makeChange(boolean sign){
        if (sign == false){
            arr[rand.nextInt(10)]--;
        } else {
            arr[rand.nextInt(10)]++;
        }
    }

    String print(){
        String str = new String();
        str += "[" + arr[0];
        for (int i = 1; i < 10; i ++){
            str +=", " + arr[i];
        }
        str += "]";
        return str;
    }
}
