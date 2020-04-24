package oop.lab8;

import mpi.MPI;

// Послідовний алгоритм
public class SimpleMatrix {
    public static void calculate(String[] args, int matSize) {

        MPI.Init(args);

        // Номер процесу
        int procRank = MPI.COMM_WORLD.Rank();

        Matrix matrixA = new Matrix(matSize, "A");
        Matrix matrixB = new Matrix(matSize, "B");
        Matrix matrixC = new Matrix(matSize, "C");
        long startTime = 0L;

        // Початкове наповнення виконується процесом номер 0
        if (procRank == 0) {
            matrixA.fillRandom(3);
            matrixB.fillRandom(3);
            startTime = System.currentTimeMillis();
        }

        // Перемноження
        for (int i = 0; i < matrixA.width; i++)
            for (int j = 0; j < matrixB.height; j++)
                for (int k = 0; k < matrixA.height; k++)
                    matrixC.matrix[i * matrixA.width + j] += matrixA.matrix[i * matrixA.width + k] * matrixB.matrix[k * matrixB.width + j];

        // Повідомлення результатів
        if (procRank == 0) {
            System.out.print("siimple: " + matSize + " x " + matSize + ", ");
            System.out.println(System.currentTimeMillis() - startTime + " ms");
        }
        MPI.Finalize();
    }
}