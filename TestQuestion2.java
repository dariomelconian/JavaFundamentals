public class TestQuestion2 {
	private static int counter;
	private static int nodeNumber;

	public static void main (String[] args) {
		boolean testPassed;
		int[] tree = {3, 0, 3, 0, 0}; // Nodes of merged tree. 1: only left child; 2: only right child;
									  // 3: both children								
		int[][]data = {{2,4,8,10,12}, {2,10}, {1,2,4,6,8},{1,4,5,9,10},{2,10}}; // Data in nodes of merged tree
		FinalTree<LinkedList> tree1;
		FinalTree<CircularArray> tree2;
		
		tree1 = new FinalTree<LinkedList>();
		tree2 = new FinalTree<CircularArray>();
		
		tree1.initializeTree(1);
		tree2.initializeTree(2);
		
		Answer2 q = new Answer2();
		LinkedList list = new LinkedList();
		list.initializeList(1);
		CircularArray circ = new CircularArray();
		circ.initializeArray(2);
		testPassed = true;
		try {
			list = q.mergeToLinkedList(list,circ);
			if (!checkList(list,data[0])) testPassed = false;
		}
		catch (Exception e) {testPassed = false;}
		
		if (testPassed) System.out.println("Test for mergeToLinkedList PASSED");
		else System.out.println("Test for megeToLinkedList FAILED");
		
		/*
		------------------------------------------------------------------------
		*/
		
		TreeNode<Object> r = null;
		try {
			r = q.mergeTrees(tree1.getRoot(), tree2.getRoot());
			testPassed = true;
			nodeNumber = 0;
			testPassed = checkTree(r,tree,data);
			if (nodeNumber != 4) {
				//
				testPassed = false;
				// 2 should be 4
				System.out.println(nodeNumber);
				System.out.println("Failed.");
			}
		}
		catch(Exception e) {
			
			testPassed = false;
			//
			e.printStackTrace();
		}
		if (testPassed) System.out.println("First test for mergeTrees PASSED");
		else System.out.println("First test for mergeTrees FAILED");
		
		try {
			r = q.mergeTrees(tree2.getRoot(), tree1.getRoot());
			testPassed = true;
			nodeNumber = 0;
			testPassed = checkTree(r,tree,data);
			if (nodeNumber != 4) {
				//
				testPassed = false;
				System.out.println("Failed.");
			}
		}
		catch(Exception e) {
			
			testPassed = false;
			//
			e.printStackTrace();
		}
		if (testPassed) System.out.println("Second test for mergeTrees PASSED");
		else System.out.println("Second test for mergeTrees FAILED");		
		
		/*
		 * ------------------------------------------------------------------------
		 */
		
		testPassed = true;
		try {
			if (!q.defeatMonsters(r,3)) testPassed = false;
		}
		catch (Exception e) {
			testPassed = false;
		}
		if (testPassed) System.out.println("Test for defeatMonsters PASSED\n    Warrior Walda crossed the forest");
		else System.out.println("Test for defeatMonsters FAILED");
		
		testPassed = true;
		try {		
			if (q.defeatMonsters(r,2)) {
				//System.out.println("Here");
				testPassed = false;
			}
		}
		catch (Exception e) {
			testPassed = false;
			e.printStackTrace();
		}
		if (!testPassed) System.out.println("Test for defeatMonsters FAILED2");
		else System.out.println("Test for defeatMonsters PASSED\n    Warrior Walda cannot cross the forest");
		
	}
	
	/* Check that the tree contains the correct information in each node */
	private static boolean checkTree(TreeNode<Object> r, int[] nodes, int[][] data) {
		int prevNode = nodeNumber;
		if (r == null) return true;
		else {
			if (!checkNode(r,data)) {return false;}
			if (nodes[nodeNumber] == 1 || nodes[nodeNumber] == 3) { // This node must have a left child
				++nodeNumber;
				if (checkTree(r.getLeftChild(),nodes,data) == false) return false;
			}
			if (nodes[prevNode] == 2 || nodes[prevNode] == 3) { //This node must have a right child
				++nodeNumber;

				if (checkTree(r.getRightChild(),nodes,data) == false) return false;
			}
			return true;
		}
	}

	/* Check that the node r stores the correct information */
	private static boolean checkNode(TreeNode<Object> r, int[][] data) {
		if (nodeNumber == 1 || nodeNumber == 4) {
			CircularArray circ = (CircularArray)r.getData();
			return checkCircList(circ,data[nodeNumber]);
		}
		else {
			LinkedList list = (LinkedList)r.getData();
			return checkList(list,data[nodeNumber]);
		}
	}
	
	/* Returns true if the two given lists contain the same information; returns false otherwise */
	private static boolean checkList(LinkedList list1, int[] list2) {
		if (list1.getNumDataItems() != list2.length) return false;
		ListNode p = list1.getFront();
		int i = 0;
		while (p != null) {
			if (p.getData() != list2[i++]) return false;
			p = p.getNext();
		}
		return true;
	}
		
	/* Returns true if the two given lists contain the same information; returns false otherwise */		
	private static boolean checkCircList (CircularArray circ, int[] list) {
		int front = circ.getFront();
		int count = circ.getNumDataItems();
		int[] arr = circ.getArray();
		if (count != list.length) return false;
		int c = 0;
		for (int i = 0; i < count; ++i) {
			if (list[i] != arr[front]) return false;
			front = (front + 1) % arr.length;
		}
		return true;	
	}
	
}