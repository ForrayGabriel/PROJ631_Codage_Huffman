package codageHuffman;

import java.util.Hashtable;
import java.util.Map.Entry;
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
	
	public Map<String, Integer> getAlphabet() {
		List<Map.Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(alphabet.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			 
			  public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
			      return entry1.getValue().compareTo( entry2.getValue() );
			  }
			  
			});
			 
		Map<String, Integer> mapSortedByValues = new LinkedHashMap<String, Integer>();
			 
			//put all sorted entries in LinkedHashMap
		for( Map.Entry<String, Integer> entry : list  ){
			   mapSortedByValues.put(entry.getKey(), entry.getValue());
		}
			 
		System.out.println("Map sorted by values: " + mapSortedByValues);
		return mapSortedByValues;
	}
	
}
