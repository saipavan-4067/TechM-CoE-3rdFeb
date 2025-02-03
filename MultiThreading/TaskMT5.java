
public class TaskMT5 {

    public static void main(String[] args) throws InterruptedException {
        int limit = 100; 
        int numThreads = 4; 
        
        int range = limit / numThreads;
        
        Thread[] threads = new Thread[numThreads];
        
        int[] partialSums = new int[numThreads];
        
        
        for (int i = 0; i < numThreads; i++) {
            final int start = i * range + 1;
            final int end = (i == numThreads - 1) ? limit : (i + 1) * range;
            
            threads[i] = new Thread(new PrimeSumTask(start, end, partialSums, i));
            threads[i].start();
        }
        
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        
        int totalSum = 0;
        for (int partialSum : partialSums) {
            totalSum += partialSum;
        }
        System.out.println("Sum of all prime numbers up to " + limit + " is: " + totalSum);
    }
}

class PrimeSumTask implements Runnable {
    private int start;
    private int end;
    private int[] partialSums;
    private int index;

    public PrimeSumTask(int start, int end, int[] partialSums, int index) {
        this.start = start;
        this.end = end;
        this.partialSums = partialSums;
        this.index = index;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        partialSums[index] = sum;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
