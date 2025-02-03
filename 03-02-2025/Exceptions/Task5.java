import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Task5 {
	public static void main(String[] args)
	{
		try {
			readFile("src//exceptions//empty.dat");
		}
		catch(FileNotFoundException e)
		{
			System.err.println("There is no file found with this name");
		}
		catch(Exception e)
		{
			System.err.println("This file is found and its empty");
		}
	}
	public static void readFile(String filename) throws Exception,FileNotFoundException
	{
		File f1 = new File(filename);
		Scanner sc = new Scanner(f1);
		
		boolean flag = false;
		while(sc.hasNext())
		{
			flag = true;
			break;
		}
		if(flag)
			System.out.println("The file is not empty");
		else 
			throw new Exception("This file is empty");
	}
}
