package Week3CSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class readCsvSimple {
	public static void main(String[] args) {
		System.out.println("\u001b[31m");
		Path path = Path.of("lectures/Week3/data.csv");

		try (BufferedReader br = Files.newBufferedReader(path)) {
			String headers = br.readLine();
			System.out.println(headers);

			String line;
			while ((line = br.readLine()) != null) {
				String[] cols = line.split(",");
				String name = cols[0];
				String age = cols[1];
				System.out.println(name + " is " + age);
			}
		} catch (IOException e) {
			System.out.println("Error: no file found matching path :(");
		}

		System.out.println("\u001b[0m");
	}
}
