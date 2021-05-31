package codageHuffman;

/**
 * Object that calculate the average number of bits per char
 * 
 * @author Gabriel
 *
 */
public class MoyBitCalculator {

	/**
	 * Function that calculate the average number of bits per char
	 * @param bitStr The compressed output as a string
	 * @param nbChar The number of char in the original file
	 * @return The number of bits per char
	 */
	public float getMoyBit(String bitStr, int nbChar) {
		return (float) bitStr.length() / nbChar;
	}

}
