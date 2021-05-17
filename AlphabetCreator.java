package codageHuffman;

import java.util.Hashtable;

public class AlphabetCreator {

	private Hashtable<String, String> alphabet = new Hashtable<String, String>();
	
	public AlphabetCreator() {
		
	}
	
	public void addString(String s) {
		for (int i = 0; i != s.length(); i++) {
			String c = Character.toString(s.charAt(i));
			if (this.alphabet.getOrDefault(c, null) != null) {
				this.alphabet.put(c, Integer.toString(Integer.parseInt(this.alphabet.get(c))+1));
			} else {
				this.alphabet.put(c, "1");
			}
		}
	}
	
	public void affiche() {
		this.alphabet.forEach(
	            (k, v) -> System.out.println("Key : " + k + ", Value : " + v));
	}
	
}
