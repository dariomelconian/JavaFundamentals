public class LinkedList {

	private ListNode front;  // First node of the linked list
	private ListNode rear;   // Last node in the linked list
	private int count; // Number of data items stored in the linked list
	
	public LinkedList() {
		front = null;
		rear = null;
		count = 0;
	}

	public void initializeList(int numList) {
		// Initialize the linked list with one of the following sets of integers
		int[] list1 = {4, 8, 12};
		int[] list2 = {2,6};
		int[] list3 = {4, 5, 9};
		int[] list = null;
		
		switch (numList) {
			case 1: list = list1; break;
			case 2: list = list2; break;
			case 3: list = list3; break;
		}
		
		front = new ListNode(list[0]);
		rear = front;
		
		for (int i = 1; i < list.length; ++i) {
			rear.setNext(new ListNode(list[i]));
			rear = rear.getNext();
		}
		count = list.length;
	}
	
	// Prints the data items stored in the list in increasing order of value	
	public void printList() {
		ListNode currentNode = front;
		System.out.print("    Linked list: ");
		while (currentNode != null) {
			System.out.print (currentNode.getData()+" ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	// Setter and getter methods are self-descriptive
	public ListNode getFront() {
		return front;
	}
	
	public void setFront (ListNode newFront) {
		front = newFront;
	}
	
	public ListNode getRear() {
		return rear;
	}
	
	public void setRear(ListNode newRear) {
		rear = newRear;
	}
	
	public int getNumDataItems() {
		return count;
	}
	
	public void setNumDataItems(int newCount) {
		count = newCount;
	}	
}