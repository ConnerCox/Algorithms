package ch22;
/*
 * Author: Conner Cox
 * Date: May 5, 2019
 * 
 * Description: Find the longest consecutive substring from a string
 * 
 * 
 * Time Complexity: O(n)
 * There is only one loop inside my program. That makes its time complexity linear.
 * The rest of the code is simple comparisons and statements, which are negligible.
 */
import java.util.Scanner;

public class MaxConsecutiveSubstring {
	public static void main(String[] args) {
		
		//get input from user
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a string: ");
		char[] word =  keyboard.nextLine().toLowerCase().toCharArray();
		keyboard.close();
		
		//determine the max consecutive substring
		String substring = "";
		String maxSubstring = "";
		char lastLetter = 0;
		for(char letter : word) {
			//check to see if it is a letter
			if(Character.hashCode(letter) < 97 || Character.hashCode(letter) > 122) {
				//do nothing; it is not a letter
			}
			//if the string is empty or if the hash of the current letter is 
			//more than the last letter (next consecutive letter), add it to substring
			else if(Character.hashCode(letter) > Character.hashCode(lastLetter)) {
				substring += letter;
				lastLetter = letter;
			}
			//if the next letter is less, make a new string. Compare current substring to max substring found
			else if(Character.hashCode(letter) < Character.hashCode(lastLetter)) {
				if(maxSubstring.length() < substring.length()) {
					maxSubstring = substring;
				}
			}
		}
		
		//print results
		System.out.println("Maximum consecutive substring is: " + substring);

	}
}
