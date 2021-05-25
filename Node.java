package codageHuffman;

public class Node {
	
	private int frequency;
	private String value;
	
	private Node left;
	private Node right;
	
	public Node(int frequency, String value, Node l, Node r) {
		this.frequency = frequency;
		this.value = value;
		this.left = l;
		this.right = r;
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
