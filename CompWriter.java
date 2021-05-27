package codageHuffman;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
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
		
		String strToWrite = this.makeString();
		BitSet bitsToWrite = this.makeBitSet(strToWrite);
		
		try {
			
			FileOutputStream fos = new FileOutputStream(new File(fName+"_comp.bin"));

			fos.write(bitsToWrite.toByteArray());
			
			fos.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}

	public String makeString() {
		
		String res = "";
		
		FileReader fReader = new FileReader(this.fileName);
		
		ArrayList<String> data = fReader.readFile();
		
		AlphabetCreator ac = new AlphabetCreator();
		
			for (String s : data) {
				
				for (char ch: s.toCharArray()) {
					res += this.table.get(String.valueOf(ch));
				}
			}
		System.out.println(res);
		return res;
	}
	
	public BitSet makeBitSet(String str) {
		BitSet bitSet = new BitSet(str.length());
		int bitcounter = 0;
		for(Character c : str.toCharArray()) {
		    if(c.equals('1')) {
		        bitSet.set(bitcounter);
		    }
		    bitcounter++;
		}
		return bitSet;
	}
	
	
}
