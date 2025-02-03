import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Task3 {
	public static void main(String[] args) {
        try {
            readFile("src//exceptions//ex1.dat"); 
        } catch (FileNotFoundException e) {
            System.out.println("Error22: " + e.getMessage()); 
        }
    }
	public static void readFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        
        Scanner scanner = new Scanner(file); 
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}