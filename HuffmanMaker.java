package codageHuffman;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class that create the huffman tree
 * 
 * @author Gabriel
 *
 */
public class HuffmanMaker {

	private PriorityQueue<Node> queue;

	private String fileName;

	private Node racine;

	private Hashtable<String, String> binaire = new Hashtable<String, String>();

	private Hashtable<String, Integer> alphabet;

	/**
	 * Constructor of the huffman tree
	 * 
	 * @param fName The name of the file containing the text to compress
	 */
	public HuffmanMaker(String fName) {

		this.fileName = fName;

		FileReader fReader = new FileReader(this.fileName);
		// Get the text to compress
		ArrayList<String> data = fReader.readFile();

		AlphabetCreator ac = new AlphabetCreator();
		// Add every character to the frequency list
		for (String s : data) {
			ac.addString(s);
		}

		this.alphabet = ac.getAlphabet();

		// Make a priority queue using the node comparator to store the nodes
		queue = new PriorityQueue<Node>(alphabet.size(), new NodeComparator());
		// Make a priority queue using the node comparator to write the frequencies
		PriorityQueue<Node> tempQueue = new PriorityQueue<Node>(alphabet.size(), new NodeComparator());

		Set<String> keys = alphabet.keySet();

		// For every different character create a new node with it's value and frequency
		for (String key : keys) {
			this.queue.add(new Node(alphabet.get(key), key, null, null));
			tempQueue.add(new Node(alphabet.get(key), key, null, null));
		}

		// Write the frequency file
		FreqWriter fw = new FreqWriter(this.fileName);
		fw.writeFreq(tempQueue);

		this.racine = null;

		// While their is more than one node in the queue
		while (queue.size() > 1) {

			// Take the two node with the lowest frequency and make a new node that has them
			// as childs
			Node n1 = queue.poll();
			Node n2 = queue.poll();

			Node intermediaire = new Node(n1.getFrequency() + n2.getFrequency(),
					"" + n1.getValue() + "-" + n2.getValue(), n1, n2);

			this.racine = intermediaire;
			// Add this new node to the queue
			queue.add(intermediaire);
		}

		// When exiting the loop, the only node in the queue is the root of the tree

		// Create a compiled file writer
		CompWriter cw = new CompWriter(this.fileName, this.getBinaryValues());

		// Create and get the binary string
		String strToWrite = cw.makeString();

		// Write the compressed file
		cw.write(strToWrite);

		CompRateCalculator compRateCalc = new CompRateCalculator(
				this.fileName.substring(0, this.fileName.length() - 4));

		// Get the compresion rate
		float compRate = compRateCalc.getCompressionRate();

		MoyBitCalculator moyBitCalc = new MoyBitCalculator();

		// Get the average number of bits per char
		float moyBit = moyBitCalc.getMoyBit(strToWrite, ac.getNbChar());

		// Show informations to the user
		String message = "The file has been compressed as " + this.fileName.substring(0, this.fileName.length() - 4)
				+ "_comp.bin\nThe frequecy file is " + this.fileName.substring(0, this.fileName.length() - 4)
				+ "_freq.txt \n The compression rate is " + (compRate * 100)
				+ "%\nThe average number of bits per character is " + moyBit + " bits";

		JOptionPane.showMessageDialog(new JFrame(), message, "Resulat", JOptionPane.INFORMATION_MESSAGE);
	}

	public Node getRacine() {
		return racine;
	}

	/**
	 * Method that get every binary value for every char and return the
	 * corresponding hashtable
	 * 
	 * @return The hashtable associating every char to its value
	 */
	public Hashtable<String, String> getBinaryValues() {
		this.setValues(this.racine, "");
		return this.binaire;
	}

	/**
	 * Method that associate every char with its binary value in an hashtable
	 * 
	 * @param n The root node
	 * @param s The binary value as a string
	 */
	public void setValues(Node n, String s) {

		// If the node is a leaf (doesn't have any children)
		if (n.getLeft() == null && n.getRight() == null && n.getValue().length() == 1) {
			// Add the char and its value to the hashtable
			this.binaire.put(n.getValue(), s);
			// Stop the loop
			return;
		}
		// Add a 0 or a 1 if the node is on the left or the right and goes a llevel
		// deeper
		setValues(n.getLeft(), s + "0");
		setValues(n.getRight(), s + "1");
	}

}
