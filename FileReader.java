package codageHuffman;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Object that read a file and return its data
 * 
 * @author Gabriel
 *
 */
public class FileReader {

	private String fPath;

	/**
	 * Constructor of the reader
	 * 
	 * @param fName Name of the file
	 */
	public FileReader(String fName) {
		this.fPath = fName;
	}

	/**
	 * Method that read the file and return its text
	 * 
	 * @return and array of Strings containing the text
	 */
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

			JOptionPane.showMessageDialog(new JFrame(), "File no found", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return texts;
	}

}
