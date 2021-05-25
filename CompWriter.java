package codageHuffman;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class CompWriter {

	private String fileName;
	private Hashtable<String, String> table;
	
	public CompWriter(String fileName, Hashtable<String, String> table) {

		this.fileName = fileName;
		this.table = table;
	}

	public void write() {
		
		String fName = this.fileName.substring(0,this.fileName.length()-4); 
		
		String toWrite = this.makeString();
		
		try {
			FileWriter file = new FileWriter(fName+"_comp.txt");
			
			file.write(toWrite);
		
			file.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}

	private String makeString() {
		
		String res = "";
		
		FileReader fReader = new FileReader(this.fileName);
		
		ArrayList<String> data = fReader.readFile();
		
		AlphabetCreator ac = new AlphabetCreator();
		
			for (String s : data) {
				
				for (char ch: s.toCharArray()) {
					System.out.println(ch + " " + this.table.get(String.valueOf(ch)));
					res += this.table.get(String.valueOf(ch));
				}
			}

		return res;
	}
	
	
}
