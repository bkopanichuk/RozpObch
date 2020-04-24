package oop.lab9;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        int size = 1000;
        List<Integer> list = new ArrayList<>();
        long startTime = System.nanoTime();
        for(int i = 0; i < size; i++){
            list.add(i);
        }

        MatrixMult.setMatrixes(size);
        MatrixMult matrixMult = new MatrixMult(size, list);
        matrixMult.invoke();
        //MatrixMult.printRes();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println((double)duration / 1000000000.0);
    }


}
