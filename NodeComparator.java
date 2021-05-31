package codageHuffman;

import java.util.Comparator;

/**
 * Comparator that is used to rank the nodes in the priority queue
 * 
 * @author Gabriel
 *
 */
public class NodeComparator implements Comparator<Node> {

	/**
	 * Function that compare two Nodes
	 */
	public int compare(Node n1, Node n2) {

		if (n1.getFrequency() == n2.getFrequency() && n1.getValue().length() == 1 && n2.getValue().length() == 1) {
			// If both Nodes have the same frequency and are both just a letter, order it by
			// the Ascii value of the character
			return (int) n1.getValue().charAt(0) - (int) n2.getValue().charAt(0);
		}
		// Else return the difference of frequencies
		return n1.getFrequency() - n2.getFrequency();
	}

}
