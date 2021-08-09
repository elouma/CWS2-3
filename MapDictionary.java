package predictive;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.IOException;
import java.util.Collections;


/**
 * @author <JEAN EMMANUEL MESSEY-ELOUMA 
 *           ID: 
 *          
 *        
 * MapDictionary Class is a data structure which maps each signature to a set of words and
 * implements interface Dictionary.
 * 
 * The methods  contains in this class are the signatureToWords method and addWords method
 * 
 * A HashMap is used as a  Map implementation for this class as it provides
 * a constant time performance for basic operations such as get and put.
 * 
 * 
 */


public class MapDictionary implements Dictionary{
	
	private HashMap<String,Set<String>> dict = new HashMap <>(); 

	/**
	 * MapDictionary constructor takes in words from the
	 * dictionary file and constructs HashMap dictionary
	 * each word is converted into a signature then each
	 * signature has set of words
	 */
	public MapDictionary(String path) {
		
		this.dict = new HashMap<>();
		
		Scanner lookUp = null;
		
		try {
			
			//Reads the file from the given path
			File file = new File(path);
			
			lookUp = new Scanner(file);

			
			//while the file has next line 
			while (lookUp.hasNextLine()) {
				
				//take this line 
				
				String line = lookUp.nextLine().toLowerCase();
				
				
				String sig = PredictivePrototype.wordToSignature(line);
				
				//check if the word is valid
				if (PredictivePrototype.isValidWord (line));
				
				dict.put(sig, addWords(sig, line));
			}
		}
		catch (IOException e) {
			
			System.out.println("File has not been found.");
			
		} finally {
			
			lookUp.close(); 
			
		}
	}
	
	
	/**
	 * The method signatureToWords converts the signature
	 * into a word for the HashMap
	 * @param signature
	 * @return returns a set of words matching the signature
	 */
	
	
	@Override
	public Set <String> signatureToWords(String signature) {
		
		//if the signature exists in the map
		if (dict.containsKey(signature))
			
			//return the set of words
			return dict.get(signature);
		
		else 
			
			return Collections.emptySet();
	}
	/**
	 * This method adds words and signature to the HashMap Set if the 
	 * signature is not in the Map else adds the word to the signature 
	 * in the Map 
	 * 
	 * @param signature is a String and the key
	 * @param word is a String
	 * @return Set of words for the Map
	 */
	 public Set<String> addWords(String signature, String word) {
		 
		 Set<String> setWords = new TreeSet<String>();
		 
		 if (!dict.containsKey(signature)) {
			 
			 setWords.add(word);
			 
		 		dict.put(signature, setWords);
		 }
		 else {
			 
			 setWords = dict.get(signature);
			 
			 setWords.add(word);
			 
			 dict.put(signature, setWords);
			 
		 }
		 
		 return setWords;
	 }

}