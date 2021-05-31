package codageHuffman;

import java.util.*;

/**
 * An object that count the number of letters The alphabet is stored in a
 * HashTable that associate each character with the number of times it is in the
 * string
 * 
 * @author Gabriel
 *
 */
public class AlphabetCreator {

	private Hashtable<String, Integer> alphabet = new Hashtable<String, Integer>();

	private int nbChar;

	public AlphabetCreator() {
		this.nbChar = 0;
	}

	/**
	 * Method that count the number of time every char appear in a string
	 * 
	 * @param str The string in which the char are counted
	 */
	public void addString(String str) {
		// For every char of the string
		for (int i = 0; i != str.length(); i++) {
			this.nbChar += 1;
			// Take a char
			String c = Character.toString(str.charAt(i));
			if (this.alphabet.getOrDefault(c, null) != null) {
				// If this char is in the alphabet, increase its value by one
				this.alphabet.put(c, this.alphabet.get(c) + 1);
			} else {
				// Else add it with the value 1
				this.alphabet.put(c, 1);
			}
		}
	}

	/**
	 * Debbuging method that print the HashTable
	 */
	public void affiche() {
		this.alphabet.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
	}

	public Hashtable<String, Integer> getAlphabet() {
		return alphabet;
	}

	public int getNbChar() {
		return nbChar;
	}

}
