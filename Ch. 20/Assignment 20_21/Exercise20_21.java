/*
Author:Conner Cox 
Date: May 16

Description: sorts arrays
 */
import java.util.Arrays;
import java.util.Comparator;

public class Exercise20_21 {
	public static void main(String[] args) {
		//array to be sorted later
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
				new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
				new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
				new Circle(6.5), new Rectangle(4, 5)};
		//unused
		Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
				new Circle(5), new Circle(6), new Circle(1), new Circle(2),
				new Circle(3), new Circle(14), new Circle(12)};
		//call the sort array method
		selectionSort(list1, new GeometricObjectComparator());
		//print sorted array
		for (int i = 0; i < list1.length; i++)
			System.out.println(list1[i].getArea() + " ");
	}
	//method to sort array based on the list and comparator given
	public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
		Arrays.sort(list, 0, list.length-1, comparator);
	}
}