package Exercise2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		fullPath();
	}

	private static void concat() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//need to do at a time and use oly one buffer
		System.out.println("Enter directory path:");
		String dirName = reader.readLine();

		System.out.println("Enter filename:");
		String fileName = reader.readLine();

		File filePath = new File(dirName.concat("/").concat(fileName));

		if(filePath.exists()){
			System.out.println("Exists");
		}else{
			System.out.println("Doesn't exists!");
		}
	}

	private static void fullPath() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter file full path: ");
		String fullPath = reader.readLine();

		File filePath = new File(fullPath);

		if(filePath.exists()){
			System.out.println("Exists");
		}else{
			System.out.println("Doesn't exists!");
		}
	}
}
