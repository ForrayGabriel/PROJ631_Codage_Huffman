package codageHuffman;

import java.io.File;

public class CompRateCalculator {

	private String fileName;

	public CompRateCalculator(String fileName) {
		this.fileName = fileName;
	}

	public float getCompressionRate() {
		
		float volInitial = (new File(this.fileName+".txt")).length();
		float volFinal = (new File(this.fileName+"_comp.bin")).length()+(new File(this.fileName+"_freq.txt")).length();
		
		float rate = 1-(volFinal/volInitial);
		
		System.out.println(rate);
		
		return rate;
		
	}

	
	

}
