package codageHuffman;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Object used to write the file containing the alphabet and the numbers of
 * different characters
 * 
 * @author Gabriel
 *
 */
public class FreqWriter {

	private String fileName;

	/**
	 * Constructor of the writer
	 * 
	 * @param fileName Name of the original file
	 */
	public FreqWriter(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Method that create and write in the file
	 * 
	 * @param q The priority queue of Nodes
	 */
	public void writeFreq(PriorityQueue<Node> q) {

		// Get the file name without the extension
		String fName = this.fileName.substring(0, this.fileName.length() - 4);

		int size = q.size();

		try {
			// Create a new file with an added name
			FileWriter file = new FileWriter(fName + "_freq.txt");

			file.write(size + "\n");

			// While there are nodes in the queue
			while (q.size() > 0) {
				// Take the Node with the lowest frequency and lowest Ascii value if there are
				// multiple nodes with the same frequency
				Node n = q.poll();
				// Write its infos in the file
				file.write("" + n.getValue() + " " + n.getFrequency() + "\n");
			}

			file.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
