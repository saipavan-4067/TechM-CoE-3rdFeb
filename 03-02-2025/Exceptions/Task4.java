import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Integer;
public class Task4 {
	public static void main(String[] args)
	{
		try {
			readFile("src//exceptions//numbers.dat");
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File is not found");
		}
		catch(Exception e)
		{
			System.err.println("File found and this file consists of some data which is positive");
		}
	}
	public static void readFile(String filename) throws Exception, FileNotFoundException
	{
		File f1 = new File(filename);
		Scanner sc = new Scanner(f1);
		while(sc.hasNext())
		{
			if(Integer.parseInt(sc.next()) > 0)
				throw new Exception("This is an exception");
		}
	}
}
