package Codebyte;

import java.util.*; 
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

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
	
	
	
	
	int targetInt;
	/**
	 * Check if *any* combination of numbers in the specified array add up to the largest number in the array.
	 * @param arr - Specified array
	 * @return
	 */
	String ArrayAdditionI(int[] arr) {

		ArrayList<Integer> intArray = new ArrayList<Integer>();
		Arrays.sort(arr);
				
		for(int i : arr) {
			intArray.add(i);
		}
		
		targetInt = intArray.get(intArray.size() - 1);
		intArray.remove((Integer)targetInt);
		
		//System.out.println(intArray.toString() + " Target: " + targetInt);
		
		//System.out.println(AddCalc(intArray, 0));
		
		if(AddCalc(intArray, 0)) {
			return "true";
		}
		
		return "false";
	}
	
	/**
	 * Check if the counter equals the target
	 * Then begin testing each number in the array
	 * @param arr
	 * @param counter
	 * @return
	 */
	boolean AddCalc(ArrayList<Integer> arr, int counter) {
		
		// Check if the current counter equals the target
		if(counter == targetInt) {
			return true;
		}
		
		// Iterate through the numbers in the array
		for(int i : arr) {
			// Create a temporary array and remove the current number
			ArrayList<Integer> temp = new ArrayList<Integer>(arr);
			temp.remove((Integer) i);
			// Check if the temporary array matches the target 
			if(AddCalc(temp, (counter + i))) {
				return true;
			}
		}
		
		return false; 
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
	 * Return the work with the largest number of repeated letters
	 * @param str
	 * @return
	 */
	String LetterCountI(String str) {		
		String[] strArray = str.split(" ");
		String longestStr = "-1";
		int maxCount = 1;
		
		for(String s : strArray) {			
			for(int i = 0; i < s.length(); i++) {
				int count = 1;				
				
				for(int j = i + 1; j < s.length(); j++) {					
					if(s.charAt(i) == s.charAt(j)) {
						count++;						
					}
					
					if(count > maxCount) {
						longestStr = s;
						maxCount = count;
					}
				}
			}
		}	
		
		return longestStr;
	}
	
	/**
	 * Return the second lowest and second largest numbers from the input array
	 * This doesn't take into account numbers that are the same
	 * @param array
	 * @return
	 */
	String SecondGreatLowNonSame(int[] arr) {
		Arrays.sort(arr);		
		String str = (arr[1] + " " + arr[arr.length - 2]);		
		
		return str;
	}
	
	/**
	 * Return the second lowest and second largest numbers from the input array
	 * @param arr
	 * @return
	 */
	String SecondGreatLow(int[] arr) {
		Arrays.sort(arr);
		int numHigh = 0;
		int numLow = 0;
				
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] != arr[i + 1]) {
				numLow = arr[i + 1];
				break;
			}
		}
		
		for(int i = arr.length - 1; i > 0; i--) {
			if(arr[i] != arr[i - 1]) {
				numHigh = arr[i - 1];
				break;
			}
		}
		
		String str = (numLow + " " + numHigh);		
		
		return str;
	}
	
	/**
	 * Work in progress
	 * @param num1
	 * @param num2
	 * @return
	 */
	String DivisionStringified(int num1, int num2) {
		int total = num1 / num2;
		
		String str = String.valueOf(total);
		int commaNum = (int) Math.floor((str.length() - 1) / 3);
		int rem = str.length() % 3;
		
		System.out.println(rem);
		String temp = "";
		
		for(int i = rem; i < str.length(); i++) {
			
		}		
		return str;
	}
	
	/**
	 * Determine the difference between two times
	 * @param str
	 * @return
	 */
	String CountingMinutesI(String str) {
		String[] temp = str.split("-");
		
		int start = timeToMin(temp[0]);
		int end   = timeToMin(temp[1]);
		
		if(end > start) {
			return String.valueOf(end - start);
		}
		
		return String.valueOf((24 * 60) - (start - end));
	}
	
	/**
	 * Convert the specified '12 hour clock' format time to a number of minutes 
	 * @param str
	 * @return
	 */
	int timeToMin(String str) {
		int time = 0;
		String[] temp = str.split(":");
		
		// Set Hours
		time += (Integer.valueOf(temp[0])) * 60;
		
		// Add 12 hours for PM
		if(temp[1].substring(2, 4).equals("pm")) {
			time += (12 * 60);
		}
		
		// Set Minutes
		time += Integer.valueOf(temp[1].substring(0, 2));		
		
		return time;
	}
	
	/**
	 * Determine if the mean and mode are of the input array are equal
	 * Return 1 if they are equal, return 0 if they are not
	 * @param arr
	 * @return
	 */
	public int MeanMode(int[] arr) {
		int mode = 0;
		Arrays.sort(arr);
		
		for(int i : arr) {
			mode += i;
		}		
		mode = mode / arr.length;

		int mean = 0;
		int temp = 0;
		int maxCount = 0;
		int count = 0;
		for(int i : arr) {
			if(temp == i) {
				count++;
				if(count > maxCount) {
					mean = i;
					maxCount = count;
				}
			} else {
				count = 0;
			}
				
			temp = i;
		}
						
		if(mean == mode) {
			return 1;
		} 
		
		return 0;
	}
	
	public int MeanModeConcise(int[] arr) {
		int mode = 0;
		Arrays.sort(arr);
		
		for(int i : arr) {
			mode += i;
		}		
		mode = mode / arr.length;

		int mean = 0;
		int temp = 0;
		int maxCount = 0;
		int count = 0;
		for(int i : arr) {
			if(temp == i) {
				count++;
				if(count > maxCount) {
					mean = i;
					maxCount = count;
				}
			} else {
				count = 0;
			}
				
			temp = i;
		}
						
		if(mean == mode) {
			return 1;
		} 
		
		return 0;
	}
	
	/**
	 * Insert a dash '-' between odd numbers in the specified String. 
	 * @param str
	 * @return
	 */
	public String DashInsert(String str) {
		String temp = "";
		
		for(int i = 0; i < str.length() - 1; i++) {
			if(isOdd(Integer.valueOf(str.charAt(i))) && isOdd(Integer.valueOf(str.charAt(i + 1)))) {				
				temp += str.charAt(i) + "-";
			} else {
				temp += str.charAt(i);
			}
		}
		
		return temp + str.charAt(str.length() - 1);
	}
	
	/**
	 * Check if the specified int is odd.
	 * @param i
	 * @return
	 */
	public boolean isOdd(int i) {
		return (i % 2 != 0);
	}
	
	/**
	 * Swap the case on all Characters in the input String 
	 * @param str
	 * @return
	 */
	public String SwapCase(String str) {
		String temp = "";
		
		for(char c : str.toCharArray()) {
			if(Character.isLetter(c)) {
				if(Character.isLowerCase(c)) {
					temp += Character.toTitleCase(c);
				} else {
					temp += Character.toLowerCase(c);
				}
			} else {
				temp += c;
			}
		}		
		
		return temp;
	}
	
	/**
	 * Search the specified String for numbers and return the total of all numbers. 
	 * Must differentiate between single and multiple digit numbers.  
	 * @param str
	 * @return
	 */
	public  String NumberAddition(String str) {
		int count = 0;
		String[] array = str.split("[^0-9]+");
		
		for(String s : array) {
			if(! s.equalsIgnoreCase("")) {
				count += Integer.valueOf(s);
			}
		}
				
		return String.valueOf(count);
	}
	
	/**
	 * Return the third longest String in the array. 
	 * When Strings are the same length return the last String in the array
	 * @param strArr
	 * @return
	 */
	public String ThirdGreatest(String[] strArr) {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("");
		
		for(String s : strArr) {
			
			for(int i = 0; i < temp.size(); i++) {	
				
				if(s.length() > temp.get(i).length()) {
					temp.add(i, s);	
					break;
				}
			}			
		}
				
		return temp.get(2);
	}
	
	/**
	 * Determine if the specified number is a power of two
	 * 2^0, 2^1, 2^2, 2^3, 2^4, ...
	 * @param num
	 * @return
	 */
	public String PowersofTwo(int num) {
		int power = 1;
		
		while(power <= num) {
			if(power == num) {
				return "true";
			}
			
			power = power * 2;
		}
		
		
		return "false";
	}
	
	public int countAdd = 0;
	
	/**
	 * Return the 'additive persistence' of the specified input number 
	 * For example the additive persistence of 2718 is 2
	 * 0: 2718
	 * 1: 18 = 2 + 7 + 1 + 8
	 * 2:  9  = 1 + 1
	 * @param num
	 * @return
	 */
	public int  AdditivePersistence(int num) {
		int count = 0;		
		String numStr = String.valueOf(num);
		
		if(String.valueOf(num).length() == 1) {
			return countAdd;
		} else {
			int temp = 0;
			for(int i = 0; i < numStr.length(); i++) {
				temp += Integer.valueOf(String.valueOf(numStr.charAt(i)));
			}
			
			countAdd++;
			AdditivePersistence(temp);
		}
		
		return countAdd;
	}
	
	/**
	 * Taking suggestions from CoderByte user 'jakmaj' <br>
	 * Using <code>while</code> loop and clean up adding the char as in Integer  
	 * @param num
	 * @return
	 */
	public int  AdditivePersistenceWhile(int num) {
		int count = 0;		
		String str = String.valueOf(num);
		
		while(String.valueOf(str).length() > 1) {
			int sum = 0;
			
			for(int i = 0; i < str.length(); i++) {
				 sum += str.charAt(i) - '0';
			}
			
			str = String.valueOf(sum);			
			count++;
		}
		
		return count;
	}
	  
	public static void main (String[] args) {  
		// keep this function call here     
		Scanner  s = new Scanner(System.in);
		Function c = new Function();
		//System.out.print(c.ArithGeo(s.nextLine()));
		System.out.println(c.AdditivePersistenceWhile(s.nextInt()));
	}  
}    