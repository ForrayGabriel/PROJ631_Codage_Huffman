package codageHuffman;

/**
 * Class representing a Node object
 * 
 * @author Gabriel
 *
 */
public class Node {

	private int frequency;
	private String value;

	private Node left;
	private Node right;

	/**
	 * Constructor of a Node
	 * 
	 * @param frequency The number of occurences of the letter
	 * @param value     The letter associated to the Node
	 * @param left      Left child of the Node
	 * @param r         Right child of the Node
	 */
	public Node(int frequency, String value, Node left, Node right) {
		this.frequency = frequency;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [frequency=" + frequency + ", value=" + value + "]";
	}

}
