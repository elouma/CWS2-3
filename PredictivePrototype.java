/**
 * @author <JEAN EMMANUEL MESSEY-ELOUMA
            ID: 
             > This class contains the solution for Worksheet2_3a 
             > Predictive Prototype 
 */


package predictive;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 * as requested in the worksheet PredictivePrototype class contains two method
 * 
 * 1) signatureToWords 
 * 
 * 2)  wordToSignature 
 */
public class PredictivePrototype {

	
	public static String wordToSignature(String word) {
		
		StringBuffer str = new StringBuffer();

		word = word.toLowerCase();
		
		int x;

		for (int i = 0; i < word.length(); i++) {
			
			x = word.charAt(i)-97;
			
			if(x<0 || x > 25){
				
				str.append(" ");

			}else 
				
		
				
			if (x == 18 ||x == 21 || x == 24 || x == 25) {
					
				str.append(x/3+1);
				
				}
			
				else 
					
				str.append(x/3+2);
		}
		
		  return str.toString();
	}
	
	/**
	 * signatureToWords method is used to create a set with the 
	 * possible matches the from the file
	 * 
	 * @param signature String of the signature number
	 * @return returns a set of the words matching the signature
	 */
	
	public static Set<String> signatureToWords(String signature){

		Set<String> signatureToWords = new TreeSet<>();
		
		Scanner scr = null;
		
		String line;

		try {
			
						scr = new Scanner(new FileReader("/usr/share/dict/words"));
      /**
		* hasNext() method reads a line at a time,
		*  the loop will stop if there is any line left to read 
		* possible matches the from the file
		* 
		* toLowerCase() is used to ensures that the words from the dictionary are in lowercase 
		* 
		* 
		*/
						while ((scr.hasNext())){
						
						line = scr.next().toLowerCase();

							if (isValidWord(line)){

								if (wordToSignature(line).equals(signature)){
									
									signatureToWords.add(line);
							
								}
							
							}
					
						}
				
		}

					catch (IOException e) {
						
						System.out.println("Words has not been found in the file.");
						
					} finally {
						
						scr.close(); 
					}
					return signatureToWords;
				}

/**
  * This method checks whether the words in the dictionary are non-alphabetic characters
  * 
  * @param word checks if the words in dictionary a valid word
  * @return returns the word true if its exist in alphabetic characters else returns false
 */
	
	
  public static boolean isValidWord(String word) {

	 
		 word = word.toLowerCase();
		 
				int x;

		for (int i = 0; i < word.length(); i++) {

					x = word.charAt(i);
					
					if(x<97 || x > 122){
						
						return false;
					}
				}
				return true;

			}
		}