/*
Author: Conner Cox
Date: June 4, 2019
Description: custom queue class
 */
public class GenericQueue<E> extends java.util.LinkedList<E> {
	//add to end
	public void enqueue(E e) {
		addLast(e);
	}
	//remove from first
	public E dequeue() {
		return removeFirst();
	}
	//get size
	public int getSize() {
		return size();
	}
//	@Override
//	public String toString() {
//		return "Queue: " + toString();
//	}
}