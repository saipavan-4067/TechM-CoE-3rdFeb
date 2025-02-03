
import java.util.Arrays;

public class TaskMT3 {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {5, 3, 8, 6, 2, 7, 4, 1, 9, 0};

        System.out.println("Original Array: " + Arrays.toString(arr));

        
        Thread thread1 = new Thread(new SortArray(arr, 0, arr.length / 2));
        Thread thread2 = new Thread(new SortArray(arr, arr.length / 2, arr.length));

        
        thread1.start();
        thread2.start();

        
        thread1.join();
        thread2.join();

       
        merge(arr, 0, arr.length / 2, arr.length);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] leftPart = Arrays.copyOfRange(arr, left, mid);
        int[] rightPart = Arrays.copyOfRange(arr, mid, right);

        int i = 0, j = 0, k = left;
        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                arr[k++] = leftPart[i++];
            } else {
                arr[k++] = rightPart[j++];
            }
        }

        while (i < leftPart.length) {
            arr[k++] = leftPart[i++];
        }

        while (j < rightPart.length) {
            arr[k++] = rightPart[j++];
        }
    }
}

class SortArray implements Runnable {
    private int[] arr;
    private int start;
    private int end;

    public SortArray(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        Arrays.sort(arr, start, end);
    }
}

