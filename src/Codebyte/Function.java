package Codebyte;

import java.util.*; 
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	/**
	 * Return true when the input String has '+' both before and after any alpha characters
	 * ===+u+=== is True
	 * ===+u==== is False
	 * @param str
	 * @return
	 */
	String SimpleSymbols(String str) {
		char[] charArray = str.toCharArray();
		boolean valid = true;		

		for(int i = 0; i < charArray.length; i++) {
			if(Character.isAlphabetic(charArray[i])) {
				
				if(i == 0 || i == charArray.length - 1) {
					return String.valueOf(false);
				}				
				
				if(charArray[i + 1] != '+' || charArray[i - 1] != '+') {
					return String.valueOf(false);
				}				
			}				
		}		
		return String.valueOf(true);
	}
	
	/**
	 * Return true if num2 is greater than num 1 otherwise return false
	 * Return "-1" if they are equal
	 * @param num1
	 * @param num2
	 * @return
	 */
	String CheckNums(int num1, int num2) {		
		if(num2 > num1) {
			return "true"; 
		} else if (num2 < num1) {
			return "false";
		}
		
		return "-1";
	}
	
	/**
	 * Convert the specified number of minutes into hours:minutes.
	 * @param str The specified String
	 * @return
	 */
	String TimeConvert(String str) {
		int num = Integer.valueOf(str);
		
		int hours = (int) Math.floor(num / 60);
		int minutes = (int) (num % 60);
		
		String time = hours + ":" + minutes;
						
		return time;
	}
	
	/**
	 * Sort the specified String into alphabetical order
	 * @param str The specified String
	 * @return
	 */
	String  AlphabetSoup(String str){
		ArrayList<Character> stringArray = new ArrayList<Character>();
		
		for(char c : str.toCharArray()){
			stringArray.add(c);
		}
		
		Collections.sort(stringArray);
		
		str = "";
		
		for(char c : stringArray) {
			str += c;
		}
		
		return str;
	}
	
	/**
	 * Alternative implementation of AlphabetSoup by user jakmaj
	 * @param input The specified String
	 * @return
	 */
	String AlphabetSoupConcise(String input) { 
		  char[] tmp = input.toCharArray();
			Arrays.sort(tmp);
			input = new String(tmp);
			
			return input;
	} 
	
	/**
	 * Check if the specified string contains 'a???b' anywhere in the String
	 * Apparently the 'Pattern' class is not supported.
	 * @param str
	 * @return
	 */
	String ABCheckPattern(String str) {
		str = str.replaceAll("[^A-Za-z0-9 ]", "");		
		
		System.out.println(str);
		
		Pattern p = Pattern.compile(".*a...b.*");
		Matcher m = p.matcher(str);		
		boolean b = m.matches();
		return String.valueOf(b);
	}
	
	/**
	 * Check if the specified string contains 'a???b' anywhere in the String
	 * @param str
	 * @return
	 */
	String ABCheck(String str) {
		char[] array = str.toCharArray();
		
		for(int i = 0; i < str.length() - 4; i++)
		{			
			if(array[i] == 'a' && array[i + 4] == 'b') {
				return "true";
			}
		}					
		return "false";
	}
	
	/**
	 * Count the number of Vowels in the specified String
	 * @param str
	 * @return
	 */
	String VowelCount(String str) {
		int count = 0;
		char[] vowel = {'a', 'e', 'i', 'o', 'u'};
		
		for(char c : str.toLowerCase().toCharArray()) {
			for(char v : vowel) {
				if(c == v) {
					count++;
					break;
				}
			}
		}		
		return String.valueOf(count);
	}
	
	/**
	 * Count the number of words in the specified String
	 * @param str
	 * @return
	 */
	String WordCount(String str) {
		String[] array = str.split(" ");
		
		return String.valueOf(array.length);
	}
	
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
	
	/**
	 * Check if there are an equal number of 'o' and 'x' characters
	 * @param str
	 * @return
	 */
	String ExOh(String str) {
		int xCount = 0;
		int yCount = 0;
		
		for(char c : str.toLowerCase().toCharArray()) {
			if(c == 'x') {
				xCount++;
			} else {
				yCount++;
			}
		}
		
		return String.valueOf(xCount == yCount);
	}
	
	/**
	 * Return <code>true</code> in the specified input String is same forward as it is backwards
	 * @param str
	 * @return
	 */
	String Palindrome(String str) {
		// Replace invalid characters, including spaces
		str = str.replaceAll("[^A-Za-z0-9]", "");
		str.toLowerCase();
		
		String reverseString = reverseStr(str);
		
		return String.valueOf(str.equals(reverseString));
	}
	
	/**
	 * Reverse the specified String
	 * @param str
	 * @return
	 */
	String reverseStr(String str) {
		String reverseString = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseString += str.charAt(i);
		}	
		
		return reverseString;
	}
	
	String ArithGeo(int[] arr) {
		
		if(Geometric(arr)) {
			return "Geometric";
		}	
		
		if(Arithmetic(arr)) {
			return "Arithmetic";
		}
			
		return "-1";
	}
	
	boolean Arithmetic(int[] arr) {
		for(int i : arr) {
			if(i % arr[0] != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	boolean Geometric(int[] arr) {
		double basePlus = arr[0];
		double baseMult = arr[1] / basePlus;
		
		for(int i = 2; i < arr.length; i++) {
			
			double temp = arr[i] / basePlus;		
			
			if((temp % baseMult) != 0) {
				return false;
			} 
		}
		
		return true;
	}
  
	public static void main (String[] args) {  
		// keep this function call here     
		Scanner  s = new Scanner(System.in);
		Function c = new Function();
		//System.out.print(c.ArithGeo(s.nextLine()));
		System.out.println(c.ArithGeo(new int[] {2, 6, 18, 54}));
	}  
}    