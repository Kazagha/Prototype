package Codebyte;

import java.util.Scanner;

public class Medium {

	/**
	 * Check if the specified integer is a prime number
	 * @param num
	 * @return
	 */
	String PrimeTime(int num) {
		if (num %2 == 0) return "false";
		
		for(int i = 2; i < num; i++) {
			if((num % i) == 0) {
				return "false";
			}
		}		
		return "true";
	}
	
	String BinaryConverter(String str) {
		int count = 0;
		
		for(double i = 0; i < str.length(); i++) {		
			double temp = Character.digit(str.charAt((int) i), 10);
			temp = temp * (Math.pow(2, (str.length() - i - 1)));
			
			count += temp;
		}
		
		return String.valueOf(count);
	}
	
	/**
	 * Return a compressed version of the string using the Run-length encoding algorithm
	 * For example "wwwggopp" would return 3w2g1o2p
	 * @param str
	 * @return
	 */
	String  RunLength(String str) {
		String encStr = "";
		// Set the previous char to the first char in the array
		char prevChar = str.charAt(0);
		// Offset by starting the count at zero
		int count = 0;
		
		// Iterate throgh the chars
		for(char c : str.toCharArray()) {
			
			if(c == prevChar) {
				// If this char matches the prevChar add to the counter
				count ++;			
			} else {		
				// Otherwise append to the encoded String
				encStr += String.valueOf(count) + String.valueOf(prevChar);				
				count = 1;
			}
			
			// Reset the previous char
			prevChar = c;
		}
		
		// Append the final char to the encoded String
		encStr += String.valueOf(count) + String.valueOf(prevChar);
		
		return encStr;
	}
	
	public static void main (String[] args) {  
		// keep this function call here     
		Scanner  s = new Scanner(System.in);
		Medium c = new Medium();
		System.out.println(c. RunLength(s.nextLine()));
	} 
}
