package files;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Task11 {
	public static void main(String[] args) {
        String filePath = "C:/Users/saipa/eclipse-workspace/files/src/sample1.dat";

        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line); 
                }
            } catch (IOException e) {
                System.err.println("An error occurred while reading the file: " + e.getMessage());
            }
        } else {
            System.err.println("The specified file does not exist.");
        }
    }
}
