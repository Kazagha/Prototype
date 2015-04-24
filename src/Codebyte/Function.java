package Codebyte;

import java.util.*; 
import java.io.*;

class Function {  
  String FirstReverse(String input) { 
    String output = "";
	for( int i = 0; i < input.length(); i++ ){
		output = output + input.charAt(input.length() - i - 1);
	}
	return output;
  } 
  
  String LetterChanges(String str) { 
	  
	    // code goes here   
	    /* Note: In Java the return type of a function and the 
	       parameter types being passed are defined, so this return 
	       call must match the return type of the function.
	       You are free to modify the return type. */
	    
	  	//System.out.println(Character.getNumericValue(str.charAt(0)));
	  
	  String temp = new String("");
	  
		  for(int i = 0; i < str.length(); i++){
			  temp += convert(str.charAt(i));
		  }
		  
	    return temp;
	    
	  } 
  
  char convert(char c){	  
	  int temp = Character.getNumericValue(c) + 1;
	  return Character.forDigit(temp, 36);
  }
  
  String FirstFactorial(String s) {
	  int num = Integer.valueOf(s);
	  int temp = 1;
	  
	  for(int i = 1; i <= num; i++){
		  temp = temp * i;
	  }
	  
	  return String.valueOf(temp);
  }
  
  String LongestWord(String sen) {
	  // Leave only alpha
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
	    System.out.print(c.LongestWord(s.nextLine())); 
  }   
  
}    