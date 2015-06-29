package Codebyte;

import java.util.ArrayList;
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
	
	public static void main (String[] args) {  
		// keep this function call here     
		Scanner  s = new Scanner(System.in);
		Medium c = new Medium();
		System.out.println(c.ArithGeoII(new int[] {1, -3, 9, -27, 81, -243}));
	} 
}
