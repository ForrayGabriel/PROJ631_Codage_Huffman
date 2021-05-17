package codageHuffman;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		FileReader fReader = new FileReader("C:\\Users\\Gabriel\\eclipse-workspace\\Code de Huffman\\src\\codageHuffman\\alice.txt");
		
		ArrayList<String> data = fReader.readFile();
		
		for (String s : data) {
			System.out.println(s);
		}
	}

}
