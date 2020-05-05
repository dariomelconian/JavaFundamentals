public class CircularArray {
	private final int INITIAL_ARRAY_SIZE = 50;
	private int[] array;  // Circular array
	private int front; // Index of the first data item stored in the array
	private int rear;  // Index of the last data item stored in the array
	private int count; // Number of data items stored in the array
	
	public CircularArray() {
		array = new int[INITIAL_ARRAY_SIZE]; 
		front = INITIAL_ARRAY_SIZE - 2;
		rear = INITIAL_ARRAY_SIZE - 3;
		count = 0;
	}
	
	public void initializeArray(int numList) {
		// Initialize the circular array with one of the following sets of integers.
		int[] list1 = {1, 4, 8};
		int[] list2 = {2, 10};
		int[] list3 = {1,10};
		int[] list = null;
		int pos;
		
		switch (numList) {
			case 1: list = list1; break;
			case 2: list = list2; break;
			case 3: list = list3; break;
		}
		
		// Copy the last 2 data items into the circular array
		pos = front;
		for (int i = 0; i < 2; ++i)
			if (list.length > i) array[pos++] = list[i];
		pos = 0;
		
		// Copy the other data items into the circular array
		for (int i = 2; i < list.length; ++i)
			array[pos++] = list[i];
		if (list.length > 2)
			rear = list.length - 3;
		else rear = front + list.length - 1;
		count = list.length;
	}
	
	// Prints the data items stored in the list in increasing order of value
	public void printList() {
		System.out.print("    Circular array: ");
		int pos = front;
		int c = 0;
		while (c < count) {
			System.out.print(array[pos]+" ");
			pos = (pos + 1) % array.length;
			++c;
		}
		System.out.println();
	}
	
	// Setter and getter methods are self-descriptive
	
	public int[] getArray() {
		return array;
	}
	
	public int getFront() {
		return front;
	}
	
	public int getRear() {
		return rear;
	}
	
	public int getNumDataItems() {
		return count;
	}
	
	public void setFront(int newFront) {
		front = newFront;
	}
	
	public void setRear (int newRear) {
		rear = newRear;
	}
	
	public void setNumDataItems (int newCount) {
		count = newCount;
	}
}