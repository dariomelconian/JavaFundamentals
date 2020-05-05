public class ListNode {
	public ListNode next;
	public int dataItem;
	
	public ListNode() {
		next = null;
		dataItem = 0;
	}
	
	public ListNode(int newData) {
		next = null;
		dataItem = newData;
	}
	
	public ListNode getNext() {
		return next;
	}
	
	public void setNext (ListNode newNext) {
		next = newNext;
	}
	
	public int getData () {
		return dataItem;
	}
	
	public void setData (int newData) {
		dataItem = newData;
	}
}