package codageHuffman;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	public int compare(Node n1, Node n2) {
		
		if(n1.getFrequency() == n2.getFrequency() && n1.getValue().length()==1 && n2.getValue().length()==1) {
			return (int) n1.getValue().charAt(0) - (int) n2.getValue().charAt(0);
		}
			
		
		return n1.getFrequency()-n2.getFrequency();
	}
	

}
