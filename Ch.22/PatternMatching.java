package ch22;
/*
 * Author: Conner Cox
 * Date: May 5, 2019
 * 
 * Description: Check to see if a string is a substring of another
 * 
 * 
 * Time Complexity: O(1)
 * There is no loops inside my program. That makes its time complexity real time.
 * The rest of the code is simple comparisons and statements, which are negligible.
 */
import java.util.Scanner;

public class PatternMatching {
	public static void main(String[] args) {
		
		//get input from user
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter s1: ");
		String s1 =  keyboard.nextLine().toLowerCase();
		System.out.print("Enter s2: ");
		String s2 =  keyboard.nextLine().toLowerCase();
		keyboard.close();
		System.out.println();
		
		//determine if there is a substring within the first string
		if(s1.contains(s2)) {
			System.out.println(s2 + " is a substring of " + s1);
		}
		else {
			System.out.println(s2 + " is a not substring of " + s1);
		}
	}
}