public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the list

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}

	/** Return true if this list contains no elements */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Return the number of elements in this list */
	public int size() {
		return size;
	}

	/** Remove the first occurrence of the element o from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else 
			return false;
	}
	
	/** Adds the elements in otherList to this list.
	* Returns true if this list changed as a result of the call */ 
	public boolean addAll(MyList<E> otherList) {
		boolean edit = false;
		for (int i = 0; i < otherList.size(); i++) {
			//if this list does not contain what otherList at i has, add it and set edit to true
			if (!contains(otherList.get(i))){
				edit = true;
				add(otherList.get(i));
			}
		}
		return edit;
	}; 

	/** Removes all the elements in otherList from this list
	* Returns true if this list changed as a result of the call */ 
	public boolean removeAll(MyList<E> otherList) {
		boolean edit = false;
		for (int i = 0; i < otherList.size(); i++) {
			//if this list does contain what otherList at i has, remove it and set edit to true
			if (contains(otherList.get(i))){
				edit = true;
				remove(otherList.get(i));
			}
		}
		return edit;
	}; 

	/** Retains the elements in this list that are also in otherList 
	* Returns true if this list changed as a result of the call */ 
	public boolean retainAll(MyList<E> otherList) {
		boolean edit = false;
		//move backward through the list, so the loop doesn't accidentally skip one as editing occurs
		for (int i=size()-1; i>=0; i--) {
			//if the otherList does not have what is in our list, remove it
			if (!otherList.contains(get(i))){
				edit = true;
				remove(i);
			}
		}
		return edit;
	}; 
}