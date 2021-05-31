package codageHuffman;

import java.util.Map.Entry;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AlphabetCreator {

	private Hashtable<String, Integer> alphabet = new Hashtable<String, Integer>();
	
	private int nbChar;
	
	public AlphabetCreator() {
		this.nbChar = 0;
	}
	
	public void addString(String s) {
		for (int i = 0; i != s.length(); i++) {
			this.nbChar+=1;
			String c = Character.toString(s.charAt(i));
			if (this.alphabet.getOrDefault(c, null) != null) {
				this.alphabet.put(c, this.alphabet.get(c)+1);
			} else {
				this.alphabet.put(c, 1);
			}
		}
	}
	
	public void affiche() {
		this.alphabet.forEach(
	            (k, v) -> System.out.println("Key : " + k + ", Value : " + v));
	}
	

	public Hashtable<String, Integer> getAlphabet() {
		return alphabet;
	}

	public int getNbChar() {
		return nbChar;
	}
	
	
	
}
