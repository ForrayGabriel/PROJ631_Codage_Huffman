package codageHuffman;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Hashtable;

/**
 * Object that create the compressed string and write it in a binary file
 * 
 * @author Gabriel
 *
 */
public class CompWriter {

	private String fileName;
	private Hashtable<String, String> table;

	/**
	 * Construction of the writer
	 * 
	 * @param fileName Name of the original file
	 * @param table    The Hashtable associating each char to a binary value (as a
	 *                 string)
	 */
	public CompWriter(String fileName, Hashtable<String, String> table) {
		this.fileName = fileName;
		this.table = table;
	}

	/**
	 * Method that write the binary file
	 * 
	 * @param strToWrite
	 */
	public void write(String strToWrite) {

		String fName = this.fileName.substring(0, this.fileName.length() - 4);
		// Get the bits that will be written
		BitSet bitsToWrite = this.makeBitSet(strToWrite);

		try {
			// Create a new file with a custom name
			FileOutputStream fos = new FileOutputStream(new File(fName + "_comp.bin"));
			// Write the bits in it
			fos.write(bitsToWrite.toByteArray());
			fos.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	/**
	 * Function that make the binary value of the file as a string
	 * 
	 * @return The binary value that will be written as a String
	 */
	public String makeString() {

		String res = "";

		FileReader fReader = new FileReader(this.fileName);
		// Get the text that will be encrypted
		ArrayList<String> data = fReader.readFile();

		for (String s : data) {

			for (char ch : s.toCharArray()) {
				// For every char of the text, get the corresponding binary value and add it to
				// the string
				res += this.table.get(String.valueOf(ch));
			}
		}
		return res;
	}

	/**
	 * Function that make a bitset out of the String
	 * 
	 * @param str The string composed of 1's and 0's
	 * @return The string but in the form of a bitset
	 */
	public BitSet makeBitSet(String str) {
		BitSet bitSet = new BitSet(str.length());
		int bitcounter = 0;
		for (Character c : str.toCharArray()) {
			if (c.equals('1')) {
				bitSet.set(bitcounter);
			}
			bitcounter++;
		}
		return bitSet;
	}

}
