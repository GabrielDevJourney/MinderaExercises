package Exercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		//concat();
		//fullPath();
		//checkPremissons();
	}

	private static void concat() throws IOException {
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

	private static void fullPath() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//need to do at a time and use oly one buffer
		System.out.println("Enter full path with the new file name and type:");
		String fullPath = reader.readLine();
		File file = new File(fullPath);
		file.createNewFile();
	}

	private static void checkPremissons() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter file or directory to test premissions: ");
		String path = reader.readLine();
		File file = new File(path);

		//can write
		System.out.println("Can write " + file.canWrite());
		//can read
		System.out.println("Can read " + file.canRead());
		//can execute
		System.out.println("Can execute " + file.canExecute());

	}
}
