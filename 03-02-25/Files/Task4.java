package files;
import java.util.Scanner;
import java.io.File;
public class Task4 {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path of file or directory");
		
		String fileOrDirectory_path = "C:/Users/saipa/eclipse-workspace/files/src";
		
		File fileOrDirectory = new File(fileOrDirectory_path);
		
		if(fileOrDirectory.exists())
		{
			System.out.println(fileOrDirectory.getAbsolutePath());
			System.out.println("Readable : " + fileOrDirectory.canRead());
			System.out.println("Writable : " + fileOrDirectory.canWrite());
		}
		else 
			System.out.println("There is no file or directory with the given path");
	}
}