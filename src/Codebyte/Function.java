package Codebyte;

import java.util.*; 
import java.io.*;

class Function {  
	
	/**
	 * Reverse the specified input string
	 * @param input
	 * @return
	 */
	String FirstReverse(String input) { 
		String output = "";
		for( int i = 0; i < input.length(); i++ ){
			output = output + input.charAt(input.length() - i - 1);
		}
		return output;
	}   

	/**
	 * Change the all the letters in the input string to the next letter in the alphabet
	 * @param str
	 * @return
	 */
	String LetterChanges(String str) {	  
		String temp = new String("");
	  
	  	for(int i = 0; i < str.length(); i++){
	  		temp += nextLetter(str.charAt(i));
	  	}
	  	
	  	return temp;	  	
	} 
  
	/**
	 * Using the input char, return the next letter in the alphabet
	 * @param c
	 * @return
	 */
	char nextLetter(char c){
		if(Character.isLetter(c)) {				
			int temp = Character.getNumericValue(c) + 1;			
			c = Character.forDigit(temp, 36);
			
			switch(c){			
			case 'a': return 'A';
			case 'e': return 'E';
			case 'i': return 'I';
			case 'o': return 'O';
			case 'u': return 'U';
			default: return c;
			}
		} else {
			return c;
		}
	}
	
	private static final List<Character> VOWEL = Arrays.asList('a', 'e', 'i', 'o', 'u');
	
	/**
	 * Using the input char, return the next letter in the array
	 * 
	 * Updated to check against an array rather than using a switch
	 * As suggested by user zawiczek
	 * @param c
	 * @return
	 */
	char nextLetterArray(char c) {
		// Check if the character is a letter		
		if(Character.isLetter(c)) {	
			// Convert to the next letter
			int temp = Character.getNumericValue(c) + 1;			
			c = Character.forDigit(temp, 36);
			
			// Make vowles uppercase
			if(VOWEL.contains(c)) {
				c = Character.toUpperCase(c);
			}
			
			return c;
			
		} else {
			return c;
		}
	}
	
	/**
	 * Find the factorial of the numbers in the input string. 
	 * @param s
	 * @return
	 */
	String FirstFactorial(String s) {
		int num = Integer.valueOf(s);
		int temp = 1;
		
		for(int i = 1; i <= num; i++){
			temp = temp * i;
		}
	  
		return String.valueOf(temp);
	}
  
	/**
	 * Return the longest word in the string ignoring punctuation
	 * @param sen
	 * @return
	 */
	String LongestWord(String sen) {
		// Leave only alphanumerical characters
		sen = sen.replaceAll("[^A-Za-z0-9 ]", "");
		
		String[] parts = sen.split(" ");
		String temp = new String("");
	  
		for(String s : parts){
			if(s.length() > temp.length()){
				temp = s;
			}
		}
		
		return temp;
	}
	
	/**
	 * Add all numbers from 1 to num.
	 * This confuses the situation by mixing String and Int without conversion.
	 * @param num
	 * @return
	 */
	int SimpleAdding(int num) {
		int counter = 0;
		
		for(int i = 1; i < num; i++) {
			counter += i;
		}		
		
		return counter;		
	}
	
	/**
	 * Capitalize the first character in the string
	 * @param str
	 * @return
	 */
	String LetterCapitalize(String str){
		char[] charArray = str.toCharArray();
		
		for(int i = 0; i < charArray.length; i++) {
			if(Character.isWhitespace(charArray[i])) {
				charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
			} else if (i == 0) {
				charArray[i] = Character.toUpperCase(charArray[i]);
			}
		}
		
		return String.valueOf(charArray);
	}
	
	/**
	 * Capitalize the first character in the string
	 * Written again using a placeholder for the previous character. 
	 * @param str
	 * @return
	 */
	String LetterCapitalizePrev(String str) {
		String temp = "";		
		char prev = 0;
		
		for(char c : str.toCharArray()) {
			if(Character.isWhitespace(prev) || prev == 0) {
				c = Character.toUpperCase(c);
			}			
			
			prev = c;
			temp += c;
		}
		
		return String.valueOf(temp);
	}
  
	public static void main (String[] args) {  
		// keep this function call here     
		Scanner  s = new Scanner(System.in);
		Function c = new Function();
		System.out.print(c.LetterCapitalizePrev(s.nextLine())); 
	}  
}    