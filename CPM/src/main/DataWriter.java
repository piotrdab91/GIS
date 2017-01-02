package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataWriter {
	String inputName;
	String outputName;

	public DataWriter(String inputName, List<String> lines) throws IOException {
		this.inputName = inputName;
		this.outputName = this.inputName.replace(".txt", "-Result.txt");
		Path file = Paths.get("resources/output", outputName);
		Files.write(file, lines, Charset.forName("UTF-8"));
		System.out.println("Wygenerowano plik:" + this.outputName);
				
	}
	
	
	
}
