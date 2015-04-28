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
		int temp = Character.getNumericValue(c) + 1;
		return Character.forDigit(temp, 36);
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
  
	public static void main (String[] args) {  
		// keep this function call here     
		Scanner  s = new Scanner(System.in);
		Function c = new Function();
		System.out.print(c.LetterChanges(s.nextLine())); 
	}  
}    