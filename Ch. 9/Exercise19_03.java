/*
Author: Conner Cox
Date: May 8, 2019

Description: 
 */
import java.util.ArrayList;

public class Exercise19_03 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(14);
		list.add(24);
		list.add(14);
		list.add(42);
		list.add(25);
		
		list.add(26);
		list.add(26);
		list.add(27);
		list.add(27);
		list.add(25);
		list.add(25);
		list.add(25);

		ArrayList<Integer> newList = removeDuplicates(list);

		System.out.print(newList);
	}

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)  {
		ArrayList<E> returnList = new ArrayList<E>();
		//go through the list
		for (int i=0; i<list.size()-1; i++) {
			if(!returnList.contains(list.get(i))) {
				returnList.add(list.get(i));
			}
		}
		return returnList;
	}
}