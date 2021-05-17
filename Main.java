package codageHuffman;

import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		FileReader fReader = new FileReader("C:\\Users\\Gabriel\\eclipse-workspace\\Code de Huffman\\src\\codageHuffman\\textesimple.txt");
		
		
		
		ArrayList<String> data = fReader.readFile();
		
		AlphabetCreator ac = new AlphabetCreator();
		
		for (String s : data) {
			
			ac.addString(s);
		}
		
		ac.affiche();
		
		

		
	}

}
