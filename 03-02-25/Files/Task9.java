package files;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class Task9 {
	public static void main(String[] args)
	{
		String filePath = "C:/Users/saipa/eclipse-workspace/files/src/sample1.dat";
		
		File file = new File(filePath);
		
		if(file.exists() && file.isFile())
		{
			try {
				FileInputStream fis = new FileInputStream(file);
				
				long length = file.length();
				System.out.println(length);
				byte[] fileBytes = new byte[(int)length];
				
				int bytesRead = fis.read(fileBytes);
				
				if(bytesRead != -1)
					System.out.println("File contents are read succesfully");
				
				for(byte b : fileBytes)
					System.out.println(b);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		else 
			System.out.println("The file does not exists");
	}
}