package codageHuffman;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanMaker {

	private PriorityQueue<Node> queue; 
	
	private String fileName;
	
	private Node racine;
	
	private Hashtable<String, String> binaire = new Hashtable<String, String>();
	
	private Hashtable<String, Integer> alphabet;
	
	public HuffmanMaker(String fName) {
		
		this.fileName = fName;
		
		FileReader fReader = new FileReader(this.fileName);
		
		ArrayList<String> data = fReader.readFile();
		
		AlphabetCreator ac = new AlphabetCreator();
		
			for (String s : data) {
				
				ac.addString(s);
			}
		
		this.alphabet = ac.getAlphabet();
		
		
		queue = new PriorityQueue<Node>(alphabet.size(), new NodeComparator());
		PriorityQueue<Node> tempQueue = new PriorityQueue<Node>(alphabet.size(), new NodeComparator());
		
		Set<String> keys = alphabet.keySet();
		
		for(String key: keys) {
			this.queue.add(new Node(alphabet.get(key), key, null, null));
			tempQueue.add(new Node(alphabet.get(key), key, null, null));
		}
		
		FreqWriter fw = new FreqWriter(this.fileName);
		
		fw.writeFreq(tempQueue);
		
		this.racine = null;
		
		while(queue.size()>1) {
			
			Node n1 = queue.poll();
			Node n2 = queue.poll();
			
			Node intermediaire = new Node(n1.getFrequency()+n2.getFrequency(), "" + n1.getValue() + "-" + n2.getValue(), n1, n2);
			
			this.racine = intermediaire;
			
			queue.add(intermediaire);	
		}
		
		/*CompWriter cw = new CompWriter(this.fileName,this.getBinaryValues());
		
		cw.write();*/
	}

	
	public Node getRacine() {
		return racine;
	}
	
	public Hashtable<String, String> getBinaryValues(){
		
		this.setValues(this.racine, "");
		
		return this.binaire;
	}
	

	public void setValues(Node n, String s) {

        if (n.getLeft()
                == null
            && n.getRight()
                   == null
            && n.getValue().length() == 1) {
 
            System.out.println(n.getValue() + ":" + s);
            
            this.binaire.put(n.getValue(), s);
 
            return;
        }
 
        // if we go to left then add "0" to the code.
        // if we go to the right add"1" to the code.
 
        // recursive calls for left and
        // right sub-tree of the generated tree.
        setValues(n.getLeft(), s + "0");
        setValues(n.getRight(), s + "1");
    }
	
	
}
