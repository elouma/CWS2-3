package predictive;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.IOException;

import predictive.PredictivePrototype;

public class TreeDictionary implements Dictionary{

	private TreeDictionary[] treeDict = new TreeDictionary[8];
	
	private Set<String> words;
	
	public TreeDictionary() {
		
		for (int i = 0; i < treeDict.length; i++) {
			
			this.treeDict[i] = null;
		}
		
		this.words = new HashSet<String>(); 
	}

	public TreeDictionary(String path) {
		
		for (int i = 0; i < treeDict.length; i++) {
			
			this.treeDict[i] = new TreeDictionary();
		}

		this.words = new HashSet<String>(); 

		Scanner scr = null;
		
		try {
			
			File file = new File(path);
			
			scr = new Scanner(file);

			while (scr.hasNext()) {
				
				String line = scr.nextLine().toLowerCase();
				
				if (PredictivePrototype.isValidWord(line)) {
					
					String x =PredictivePrototype.wordToSignature(line);
					
					int y = Integer.parseInt(x.substring(0, 1));
					
					this.treeDict[y-2].addWords(x, line, 1);
				}
			}
		}
		
		catch (IOException e) {
			
			System.out.println("File is not found.");
			
		} finally
		
		{
			scr.close(); 
		}
	}
	
	
	
	
	public void addWords(String signature, String word, int x) {
		
		this.words.add(word);
		
		if (x < signature.length()) {
			
			int b = Integer.parseInt(signature.substring(x, x+1));
			
			x++;
			
			if(this.treeDict[b-2]==null) {
				
				this.treeDict[b-2] = new TreeDictionary();
		}
			
		this.treeDict[b-2].addWords(signature, word, x);
		
		}
	}

	
	
	
	@Override
	public Set<String> signatureToWords(String signature) {
		
		Set<String> setWords = new HashSet<>();
		
		int b = signature.length();

		signatureToLine(signature).forEach(word -> setWords.add(word.substring(0, b)));
		
		return setWords;
	}
	
	public Set<String> signatureToLine(String signature) {
		
		if (signature.isEmpty()) {
			
			return words;
		}
		else {
			
		int b = Integer.parseInt(signature.substring(0, 1));
		
		return this.treeDict[b - 2].signatureToLine(signature.substring(1));
		
		}
	}
}