package Exercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateFile {

	public static void concat() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//need to do at a time and use oly one buffer
		System.out.println("Enter directory path:");
		String dirName = reader.readLine();

		System.out.println("Enter filename to create and its type:");
		String fileName = reader.readLine();

		String fullPath = dirName.concat("/").concat(fileName);
		File file = new File(fullPath);
		file.createNewFile();
	}

	public static void fullPath() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//need to do at a time and use oly one buffer
		System.out.println("Enter full path with the new file name and type:");
		String fullPath = reader.readLine();
		File file = new File(fullPath);
		file.createNewFile();
	}



}
