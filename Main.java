package codageHuffman;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		
		String fileName = "alice.txt";
		
		System.out.println("Hello World");
		
		FileReader fReader = new FileReader(fileName);
		
		ArrayList<String> data = fReader.readFile();
		
		AlphabetCreator ac = new AlphabetCreator();
		
		for (String s : data) {
			
			ac.addString(s);
		}
		
		ac.affiche();
		
		HuffmanMaker hf = new HuffmanMaker(ac.getAlphabet(), fileName);
		System.out.println(hf.getBinaryValues());

		
	}

}
