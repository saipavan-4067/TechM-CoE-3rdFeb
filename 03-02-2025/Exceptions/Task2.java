import java.util.Scanner;
public class Task2 {
    public static void checkEvenNumber(int number) throws Exception {
        if (number % 2 != 0) {
            throw new Exception("Odd number: " + number);
        }
        System.out.println("even number: " + number);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            checkEvenNumber(num);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
