/**
 * @author <JEAN EMMANUEL MESSEY-ELOUMA
            ID: 
             > This class contains the solution for Worksheet2_3a 
             > List Dictionary 
 */


package predictive; 

public class WordSig implements Comparable<WordSig>{

	private String words;
	private String signature;

	/**
	 * 
	 * @param words is a String
	 */
	
	public WordSig (String words) {

		this.words = words;
		this.signature = PredictivePrototype.wordToSignature(words);
	}
	
	/**
	 * 
	 * WordSig constructor takes an  empty String and signature
	 * constructs a WordSig object with a word and signature
	 * 
	 * @param signature is a String
	 * 
	 * @param words is a String
	
	 */
	public WordSig (String words, String signature) {

		this.words = "";
		this.signature = signature;
	}
	
	/**
	 * 
	 * @return returns a word
	 */
	
	
	public String getWords() {
		
		return words;
	}
	
	/**
	 * 
	 * getter for signature
	 * 
	 * @return returns a signature
	 * 
	 */
	
	public String getSignature() {
		return signature;
	}

	
	/**
	 * 
	 * @param ws an WordSig signatures
	 * 
	 * @return returns -1, 0 or 1 according to whether 
	 * 
	 *  
	 */
	
	
	public int compareTo(WordSig ws) {

		int x= (this.signature.compareTo(ws.signature));

		if(x>0){
			return 1;
		}
		else if (x<0){
			return -1;
		}
		else return 0;
	}

	public String toString () {
		return signature + " : " + words;
	}



}