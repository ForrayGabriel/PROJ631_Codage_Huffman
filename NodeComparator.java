package codageHuffman;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	public int compare(Node n1, Node n2) {
		
		return n1.getFrequency()-n2.getFrequency();
	}
	

}
