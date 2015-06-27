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
	
	public static void main (String[] args) {  
		// keep this function call here     
		Scanner  s = new Scanner(System.in);
		Medium c = new Medium();
		System.out.println(c.BinaryConverter(s.nextLine()));
	} 
}
