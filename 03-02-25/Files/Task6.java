
package files;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
public class Task6 {
	public static void main(String[] args)
	{
		String path = "C:/Users/saipa/eclipse-workspace/files/src";
		
		File file = new File(path);
		
		if(file.exists())
		{
			Date lastDateOfModified = new Date(file.lastModified());
			System.out.println("Last Modified : " + lastDateOfModified);
		}
		else 
			System.out.println("There is no file or directory with this name");
	}
}
