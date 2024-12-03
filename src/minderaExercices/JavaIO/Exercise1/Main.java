package Exercise1;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//writer and the path to write to
		BufferedWriter writer = new BufferedWriter(new FileWriter("Exercise1/FilesNames"));
		//get directory input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String directoryName = reader.readLine();

		//to get files i need to have the object iteself where the files are
		File directory = new File(directoryName);

		File[] files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				writer.write(file.getName());
				writer.newLine();
			}
		}
		//force to finish the writting and end it
		writer.flush();
		writer.close();
	}
}
