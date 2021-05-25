package codageHuffman;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		
		String fileName = "alice.txt";
		

		HuffmanMaker hf = new HuffmanMaker(fileName);
		System.out.println(hf.getBinaryValues());

		
	}

}
