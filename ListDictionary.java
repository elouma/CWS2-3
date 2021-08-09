/**
 * @author <JEAN EMMANUEL MESSEY-ELOUMA 
            ID: 
             > This class contains the solution for Worksheet2_3a 
             > List Dictionary 
 */


package predictive;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 *  ListDictionary class creates a dictionary
 * in a ArrayList with each line containing a WordSig
 * object meaning a word and a signature. Also this class
 * contains the method signatureToWords
 
 */

public class ListDictionary implements Dictionary{
	
	private ArrayList<WordSig>dictionary;
	
	
	
	public ListDictionary(String path) {
		 
		
		Scanner kong = null;
		
		
		/**
		 * ArrayList create a new  dictionary that hold all valid words and signature.
		 * 
		 */
		
		

		dictionary = new ArrayList<WordSig>();

		try {
			
		
			File theFile = new File(path);
			
			
			kong = new Scanner(theFile);

			while (kong.hasNext()) {
				
				
				String wordTo = kong.next().toLowerCase();

				
				if (PredictivePrototype.isValidWord(wordTo))

				
					dictionary.add(new WordSig(wordTo));
			}
		}
		catch (IOException e) {
			
			System.out.println("We were not able to find the File.");
			
		} finally {
			
			kong.close(); 

		}
	
		Collections.sort(dictionary);
	}
	
	/**
	 
	 * @param signature is a String
	 * 
	 * @return returns a set of words matching the signature
	 * 
	 */
	
	
	public Set<String> signatureToWords(String signature){

		Set<String> suggestion_words = new HashSet<String>();

		
		WordSig slim = new WordSig("", signature);

		
		int end = dictionary.size();

	
		int x= Collections.binarySearch(dictionary, slim);

		
		int below = x;
		
		int above = x;

		
		if (x < 0) {
			
			return suggestion_words;
		}
		
		else {
			
		
			
			
			while (signature.equals(dictionary.get(below).getSignature())) {

				if (!suggestion_words.contains(dictionary.get(below).getWords())) {

					suggestion_words.add(dictionary.get(below).getWords());
				}
				below--;
				
				if (below<0)
					
					break;
			}
			while (signature.equals 
					
					(dictionary.get(above).getSignature())) {
				
				if (!suggestion_words.contains
						
						(dictionary.get(above).getWords())) {

					suggestion_words.add(dictionary.get(above).getWords());
				}
				
				above++;
				
				if (above>end)
					
					break;	
			}

		}
		
		return suggestion_words;
	}

}