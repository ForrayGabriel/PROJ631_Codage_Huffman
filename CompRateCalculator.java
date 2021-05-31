package codageHuffman;

import java.io.File;

/**
 * Object that calculate the compression rate
 * 
 * @author Gabriel
 *
 */
public class CompRateCalculator {

	private String fileName;

	/**
	 * Constructor of the calculator
	 * 
	 * @param fileName Name of the original file
	 */
	public CompRateCalculator(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Function that calculate the compression rate
	 * 
	 * @return The compression rate
	 */
	public float getCompressionRate() {

		// Get the weight of the original file
		float volInitial = (new File(this.fileName + ".txt")).length();
		// Get the weight of the frequency file and the compressed file
		float volFinal = (new File(this.fileName + "_comp.bin")).length()
				+ (new File(this.fileName + "_freq.txt")).length();

		float rate = 1 - (volFinal / volInitial);

		return rate;

	}

}
