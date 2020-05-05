public class TreeNode<T> {
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	private T dataItem;
	
	public TreeNode() {
		leftChild = null;
		rightChild = null;
		dataItem = null;
	}
	
	public TreeNode(TreeNode<T> left, TreeNode<T> right, T newData) {
		leftChild = left;
		rightChild = right;
		dataItem = newData;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	
	public T getData () {
		return dataItem;
	}
	
	public void setData(T newData) {
		dataItem = newData;
	}
	
	public void setLeftChild (TreeNode<T> left) {
		leftChild = left;
	}
	
	public void setRightChild (TreeNode<T> right) {
		rightChild = right;
	}
}