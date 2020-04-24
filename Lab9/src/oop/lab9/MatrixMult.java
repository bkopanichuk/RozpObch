package oop.lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MatrixMult extends RecursiveAction {
    static int[][] a;
    static int[][] b;
    static int[][] c;
    static int size;
    int columnsCount;
    List<Integer> columns;
    MatrixMult(int columnsCount, List<Integer> columns){
        this.columnsCount = columnsCount;
        this.columns = columns;
    }
    public static void setMatrixes(int size){
        MatrixMult.size =  size;
        a = new int[size][size];
        b = new int[size][size];
        c = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                a[i][j] = i+j;
                b[i][j] = i+j;
                c[i][j] = 0;
            }
        }
    }
    public static void printRes(){
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
    @Override
    protected void compute() {
        if(columnsCount == 0){
            return;
        }
        if(columnsCount == 1){
            int column = columns.get(0);
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    c[column][i] += a[column][j] * b[j][i];
                }
            }
        }else{
            List<Integer> leftColumns = new ArrayList<>();
            List<Integer> rightColumns = new ArrayList<>();
            for(int i = 0; i < columnsCount; i++){
                if(i < columnsCount/2){
                    leftColumns.add(columns.get(i));
                }else{
                    rightColumns.add(columns.get(i));
                }
            }
            MatrixMult leftAction = new MatrixMult(columnsCount/2, leftColumns);
            MatrixMult rightAction = new MatrixMult(columnsCount - columnsCount/2, rightColumns);
            leftAction.invoke();
            rightAction.invoke();
        }
    }
}
