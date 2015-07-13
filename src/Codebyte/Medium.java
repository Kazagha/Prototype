package Codebyte;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	/**
	 * Return the <code>num</code>th prime number in the sequence
	 * @param num 
	 * @return - The specified prime number
	 */
	int PrimeMover(int num) {		
		int count = 1;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		// Search for prime numbers the specified number of times
		for(int i = 0; i < num; i++) {
			// Start with the next number in the sequence
			count ++;
			
			// While the number is not prime increase the count
			while(! PrimeNum(count, primes)) {				
				count ++;				
			}
			
			// Add the prime number into the array 
			primes.add(count);
		}
		
		return count;
	}
	
	/**
	 * Check if the specified number is a prime, based on the array of know prime numbers
	 * @param count - The specified number
	 * @param primes - The <b>current</b> array of prime numbers
	 * @return - True if the number is Prime
	 */
	boolean PrimeNum(int count, ArrayList primes) {
		for(Object i : primes.toArray()) {
			if((count % (Integer) i) == 0) {
				return false;
			}
		}		
		
		return true;
	}
	
	/**
	 * Return true if the specified String is a Palidrome
	 * The same forward as it is backwards, ignoring spaces and punctuation
	 * @param str
	 * @return
	 */
	public  String PalindromeTwo(String str) {
		// Replace invalid characters, including spaces
		str = str.replaceAll("[^A-Za-z0-9]", "");
		str = str.toLowerCase();
		
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
	
	ArrayList<Integer> primes = getPrimeArray(10);
	
	/**
	 * Take both input numbers and return the Greatest Common Factor
	 * @param num1
	 * @param num2
	 * @return <code>int</code> - Greatest Commom Factor of the specified numbers
	 */
	int Division(int num1, int num2) {		
		ArrayList primeNum1 = primeFactorization(num1);
		ArrayList primeNum2 = primeFactorization(num2);
		ArrayList primeCommon = new ArrayList<>();
		
		for(Object i :  primeNum1.toArray()) {
			for(Object j : primeNum2.toArray()) {
				if((Integer) i == (Integer) j) {
					primeCommon.add(i);
					break;
				}
			}
			
			primeNum2.remove(primeCommon.get(primeCommon.size() - 1));
		}
		
		int gcf = 1;
		
		for(Object i : primeCommon.toArray()) {
			gcf *= (Integer) i;
		}		
		
		return gcf;
	}
	
	/**
	 * Return the prime factorization of the specified int
	 * @param num
	 * @return
	 */
	ArrayList<Integer> primeFactorization(int num) {
		ArrayList<Integer> array = new ArrayList<>();
		
		while(! PrimeNum(num, primes)) {
			for(int i : primes) {
				if(num % i == 0) {					
					num = num / i;
					array.add(i);
					break;
				}
			}
		}		
		return array;
	}
	
	/**
	 * Return an ArrayList of prime numbers
	 * @param num
	 * @return
	 */
	ArrayList<Integer> getPrimeArray(int num) {
		int count = 1;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		// Search for prime numbers the specified number of times
		for(int i = 0; i < num; i++) {
			// Start with the next number in the sequence
			count ++;
			
			// While the number is not prime increase the count
			while(! PrimeNum(count, primes)) {				
				count ++;				
			}
			
			// Add the prime number into the array 
			primes.add(count);
		}
		
		return primes;
	}
	
	/**
	 * Return True of if a portion of str1 characters can be rearranged to match str2
	 * @param str1
	 * @param str2
	 * @return
	 */
	public String StringScramble(String str1, String str2) {
		ArrayList<Character> array = new ArrayList<>();
		
		for(char c : str2.toCharArray()) {
			array.add(c);
		}
		
		for(char c : str1.toCharArray()) {
			array.remove((Character) c);
		}
		
		if(array.isEmpty()) {
			return "true";
		}
		
		return "false";
	}
	
	/**
	 * Return "Arithmetic" if the sequence follows an arithmetic pattern
	 * 	Or return "Geometric" of the sequence follows a geometric pattern
	 * 	Failing that return -1
	 * 	Arguments can include negative numbers 
	 * @param arr
	 * @return
	 */
	public String ArithGeoII(int[] arr) {
		if(Geometric(arr)) {
			return "Geometric";
		}	
		
		if(Arithmetic(arr)) {
			return "Arithmetic";
		}
			
		return "-1";
	}
	
	/**
	 * Return true if the specified array is a arithmetic sequence
	 * @param arr
	 * @return
	 */
	boolean Arithmetic(int[] arr) {
		int base = arr[1] - arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] - arr[i - 1] != base) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Return true if the specified array is a geometric sequence
	 * @param arr
	 * @return
	 */
	boolean Geometric(int[] arr) {
		double base = arr[1] / arr[0];
				
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] / arr[i - 1] != base) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Return  true if any combination of numbers in the array can be added 
	 *  up to equal the largest number in the array
	 * @param arr
	 * @return
	 */
	public String ArrayAddition(int[] arr) {
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		Arrays.sort(arr);
				
		for(int i : arr) {
			intArray.add(i);
		}
		
		int targetInt = intArray.get(intArray.size() - 1);
		intArray.remove((Integer)targetInt);
		
		if(AddCalc(targetInt, 0, intArray)) {
			return "true";
		}		
		
		return "false";
	}
	
	/**
	 * Check if the current number is the same as the target
	 * Try adding each of the Integers in the array to find the target
	 * @param arr
	 * @param counter
	 * @return
	 */
	public boolean AddCalc(int targetInt, int counter, ArrayList<Integer> arr) {
		
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
			if(AddCalc(targetInt, (counter + i), temp)) {
				return true;
			}
		}
		
		return false; 
	}
	
	/**
	 * Take the specified String and return the first word 
	 *  with the greatest number of repeated letters
	 * @param str
	 * @return
	 */
	public String LetterCount(String str) { 
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
	 * Caesar Cipher works by shifting each letter in the string N places down in the alphabet
	 * @param str - The String to shift
	 * @param num - N number of places
	 * @return
	 */
	public String CaesarCipher(String str, int num) {
		String tempStr = "";
	
		for(char c : str.toCharArray()) {
			if(Character.isLetter(c)) {
				char charInt = c;
				charInt += num;
				
				if(Character.isUpperCase(c)) {
					if(charInt > 'Z') {
						charInt -= 26;
					}
				} else {
					if(charInt > 'z') {
						charInt -= 26;
					}
				}			
				
				tempStr += charInt;
			} else {
				tempStr += c;
			}
		}
		
		return tempStr;
	}
	
	/**
	 * CaesarCipher, attempting to use the String Builder class
	 * @param str
	 * @param num
	 * @return
	 */
	public String CaesarCipherStringBuilder(String str, int num) {
		StringBuilder sb = new StringBuilder(str);
		
		for(int i = 0; i < sb.length(); i++) {
			if(Character.isLetter(sb.charAt(i))) {
				char c;
			
				int numChar = Character.getNumericValue(sb.charAt(i)) + num;
				
				if(numChar > 35) {
					numChar -= 26;
				}				
				
				if(Character.isUpperCase(sb.charAt(i))) {
					sb.setCharAt(i, (char) Character.toUpperCase(numChar));
				} else {
					sb.setCharAt(i, (char) numChar); 
				}
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Using the input array return the number that occurs most frequently (the mode)
	 *  If there is more than one mode, return the number that occurs first in the array
	 * @param arr
	 * @return
	 */
	public String SimpleMode (int[] arr) {
		int modeCount = 1;
		String modeNum = "-1";
		for(int i = 0; i < arr.length; i++) {
			int loopCount = 1;
			
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					loopCount++;
				}
				
				if(loopCount > modeCount) {
					modeNum = String.valueOf(arr[i]); 
					modeCount = loopCount;
				}
			}
		}
		
		return String.valueOf(modeNum);
	}
	
	public void charPrint(int num) {		
		for(int i = 0; i < num; i++) {
			System.out.println(i + ": " + String.valueOf(Character.forDigit(i, Character.MAX_RADIX)));
		}
	}
	
	/**
	 * Return the number of ints required to make the input array consecutive 
	 * @param args
	 * @return
	 */
	public int Consecutive(int[] args) {
		Arrays.sort(args);
		int counter = 0;
		
		for(int i = args[0]; i <= args[args.length - 1]; i++){
			//System.out.format("%d%n", i);
			boolean match = false;
			
			for(int j : args) {
				if(i == j) {
					//System.out.format("  %d%n", counter);	
					match = true;
					break;
				}					
			}
			
			if(! match) {
				counter++;
			}
		}
		
		return counter;
	}
	
	/**
	 * Return the number of ints required to make the input array consecutive
	 * @param args
	 * @return
	 */
	public int ConsecutiveCount(int[] args) {
		Arrays.sort(args);
		int diff = args[args.length - 1] - args[0] + 1;
		diff -= (args.length);
				
		return diff;		
	}
	
	/**
	 * Divide int1 by int2 and  return the result as a string with properly
	 *  formatted commas and 4 significant digits after the decimal place
	 * @param int1
	 * @param int2
	 * @return
	 */
	public String  FormattedDivision(int int1, int int2) {
		double total = (double) int1 / (double) int2;
		
		String s = String.format("%,1.4f", total);
		
		return s;
	}
	
	/**
	 *  Take the str parameter being passed which will be two times 
	 *  (each properly formatted with a colon and am or pm) separated 
	 *  by a hyphen and return the total number of minutes between the two times.
	 *  The time will be in a 12 hour clock format. For example: 
	 *   	If str is 9:00am-10:00am then the output should be 60.
	 *      If str is 1:00pm-11:00am the output should be 1320
	 * @param str
	 * @return
	 */
	public String CountingMinutes(String str) {
		String times[] = str.split("-");
		String timeStart = times[0];
		String timeEnd = times[1];
		
		int intStart = timeToInt(timeStart);
		int intEnd = timeToInt(timeEnd);
		int time = 0;
		
		if(intEnd > intStart) {
			time = intEnd - intStart;
			
		} else if (intEnd < intStart) {	
			time = (60 * 24) - (intStart - intEnd);
		} 
		
		return String.valueOf(time);
	}
	
	public int timeToInt(String s) {
		String str[] = s.split(":");		
		int hour = Integer.valueOf(str[0]) * 60;
		int minute = Integer.valueOf(str[1].substring(0, 2));
		int period = 0;
		
		if(str[1].substring(2, 4).equals("pm")) {
			period += (12 * 60);
		}		
		
		return period + minute + hour;
	}
	
	public static void main (String[] args) {  
		// keep this function call here     
		Scanner  s = new Scanner(System.in);
		Medium c = new Medium();
		System.out.println(c.CountingMinutes("12:30pm-12:00am"));
	} 
}
