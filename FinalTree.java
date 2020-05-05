public class FinalTree<T> {
	private TreeNode<T> root; // Root of the binary tree
	private int pos; //You do not need this instance variable
	
	public FinalTree() {
		root = null;
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode<T> newRoot) {
		root = newRoot;
	}
	
	public void initializeTree(int treeNumber) {
		int[] tree1 = {2, 1, 0}; // 1: only left child, 2: only right child, 3: both children, 0: no children
		int[] data1 = {1, 2, 3}; // Linked list number
		int[] tree2 = {3, 0, 3, 0, 0};
		int[] data2 = {-2, -2, -1, -3, -2}; // Circular array number 
		int[] tree = null;
		int[] data = null;
		
		switch (treeNumber) {
			case 1: tree = tree1; data = data1; break;
			case 2: tree = tree2; data = data2; break;
		}
		pos = 0;
		root = createTree(tree,data);
	}
	
	private TreeNode<T> createTree(int[] tree, int[] data) {
		TreeNode<T> node = new TreeNode<T>();
		if (data[pos] > 0) {// Node stores a linked list
			node.setData((T)new LinkedList());
			LinkedList list = (LinkedList)node.getData();
			list.initializeList(data[pos]);
		}
		else {
			node.setData((T)new CircularArray());
			CircularArray arr = (CircularArray)node.getData();
			arr.initializeArray(-data[pos]);
		}
		
		int oldPos = pos;
		if (tree[pos] == 1 || tree[pos] == 3) {// Node has left child
		    ++pos;
			node.setLeftChild(createTree(tree,data));
		}
		if (tree[oldPos] == 2 || tree[oldPos] == 3) {// Node has right child
			++pos;
			node.setRightChild(createTree(tree,data));
		}
		return node;
	}
}
