
public class TaskMT4 {

    public static void main(String[] args) throws InterruptedException {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] matrixB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible: incompatible dimensions.");
            return;
        }

        int[][] result = new int[rowsA][colsB];

        
        Thread[] threads = new Thread[rowsA];
        for (int i = 0; i < rowsA; i++) {
            threads[i] = new Thread(new MatrixMultiplicationTask(matrixA, matrixB, result, i));
            threads[i].start();
        }

        
        for (Thread thread : threads) {
            thread.join();
        }

        
        System.out.println("Resultant Matrix:");
        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

class MatrixMultiplicationTask implements Runnable {
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] result;
    private int row;

    public MatrixMultiplicationTask(int[][] matrixA, int[][] matrixB, int[][] result, int row) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.row = row;
    }

    @Override
    public void run() {
        int colsB = matrixB[0].length;
        for (int j = 0; j < colsB; j++) {
            result[row][j] = 0;
            for (int k = 0; k < matrixA[0].length; k++) {
                result[row][j] += matrixA[row][k] * matrixB[k][j];
            }
        }
    }
}
