package codageHuffman;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	private String fPath;

	public FileReader(String fName) {
		this.fPath = fName;
	}
	
	public ArrayList<String> readFile() {
		ArrayList<String> texts = new ArrayList<String>();
		File myFile = new File(this.fPath);
		try {
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        texts.add(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return texts;
	}
	
	
}
