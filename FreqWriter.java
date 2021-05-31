package codageHuffman;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class FreqWriter {
	
	private String fileName;

	public FreqWriter(String fileName) {
		this.fileName = fileName;
	}
	
	public void writeFreq(PriorityQueue<Node> q) {
		
		String fName = this.fileName.substring(0,this.fileName.length()-4); 

		int size = q.size();
				
		try {
			FileWriter file = new FileWriter(fName+"_freq.txt");
			
			file.write(size+"\n");
		
			while(q.size()>0) {
				Node n = q.poll();
				file.write(""+ n.getValue() +" "+n.getFrequency()+ "\n");
			}
		
		file.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
	}
	
	

}
