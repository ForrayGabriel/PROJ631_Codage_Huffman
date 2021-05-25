package codageHuffman;

import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanMaker {

	private PriorityQueue<Node> queue; 
	
	public HuffmanMaker(Hashtable<String, Integer> alphabet) {
		
		System.out.println(alphabet.size());
		
		
		queue = new PriorityQueue<Node>(alphabet.size(), new NodeComparator());
		
		Set<String> keys = alphabet.keySet();
		
		for(String key: keys) {
			queue.add(new Node(alphabet.get(key), key, null, null));
		}
		
		Node racine = null;
		
		while(queue.size()>1) {
			
			Node n1 = queue.poll();
			Node n2 = queue.poll();
			
			Node intermediaire = new Node(n1.getFrequency()+n2.getFrequency(), "" + n1.getValue() + "-" + n2.getValue(), n1, n2);
			
			racine = intermediaire;
			
			queue.add(intermediaire);
			
			System.out.println(intermediaire);
			
		}
	}
	
}
