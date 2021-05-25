package codageHuffman;

import java.util.Map.Entry;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AlphabetCreator {

	private Hashtable<String, Integer> alphabet = new Hashtable<String, Integer>();
	
	public AlphabetCreator() {
		
	}
	
	public void addString(String s) {
		for (int i = 0; i != s.length(); i++) {
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
	
}
