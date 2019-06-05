/*
Author: Conner Cox
Date: June 4, 2019
Description: Tests my custom Queue class
 */
public class TestQueue {
	public static void main(String[] args) {
		GenericQueue<String> queue = new GenericQueue<>();
		
		//initialization
		System.out.println("Adding names to queue: \nbob\ntexas\ngreg\nbilly");
		queue.enqueue("bob"); // Add it to the queue
		queue.enqueue("texas"); 
		queue.enqueue("greg");
		queue.enqueue("billy");
		

		// Remove elements from the queue
		System.out.println("Removing bob and texas:");
		System.out.println("1. " + queue.dequeue());
		System.out.println("2. " + queue.dequeue());
		
		System.out.println("Printing whats left in the queue: " + queue);
	}
}