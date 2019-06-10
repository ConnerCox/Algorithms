/* 
Author: Conner Cox
Date: June 10th, 2019

Given: "4.5"      Expected: 51451
Given: "Hello"    Expected: 69609650
 */
public class Exercise27_09 { 
	public static void main(String[] args) {
		String s = "4.5";
		System.out.println(hashCodeForString(s));

		s = "Hello";
		System.out.println(hashCodeForString(s));
	}

	public static int hashCodeForString(String string) {
		//create vars
		char[] s = string.toCharArray();
		int hash = 0;
		//run through char array
		for(int i=0; i<s.length; i++) {
			hash += (s[i] * Math.pow((31), (s.length-(i+1))));
		}
		return hash;
	}
}