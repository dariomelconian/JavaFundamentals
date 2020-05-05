// Student name:  Dario Melconian
// Student ID:  251044493

public class Answer2<T> {

	/* Complete this method, which should merge two trees as specified in question 2 of the
	   final exam.                                                */
	public TreeNode<T> mergeTrees(TreeNode<T> r1, TreeNode<T> r2) {
		
		// if both trees to be merged are null
		if (r1 == null && r2 == null) {
			
			// merged is null
			return null;
		}
		
		// if r1 is null, return r2 as merged
		if (r1 == null) {
            
			return r2;
		}
		
		// if r2 is null, return r1 as merged
        if (r2 == null) {
            
        	return r1;
        }
		
        // if neither r1 or r2 is null, r1 and r2 must merge as one
        if (r1 != null && r2 != null) {
        	
	    	LinkedList merged;
        	
        	// event that r1 is linked, and r2 is circular
        	if (r1.getData() instanceof LinkedList) {
        		        	        	
	        	merged = mergeToLinkedList((LinkedList)r1.getData(), (CircularArray)r2.getData());
	        	
	        	// create tree node and set the data for it
	        	TreeNode n = new TreeNode();
	        	n.setData(merged);
	        	
	        	
	        	n.setLeftChild(mergeTrees(r1.getLeftChild(), r2.getLeftChild()));
	        	
	        	n.setRightChild(mergeTrees(r1.getRightChild(), r2.getRightChild()));
	        	
	        	return n;
        	}	
        	
        	// event that r2 is linked, and r1 is circular
        	if (r2.getData() instanceof LinkedList) {
	    	   
	    	   merged = mergeToLinkedList((LinkedList)r2.getData(), (CircularArray)r1.getData());
	    	   	    	
	    	   //  create tree node and set the data for it
	    	   TreeNode n = new TreeNode();
	    	   n.setData(merged);
	    	   
	    	   n.setLeftChild(mergeTrees(r1.getLeftChild(), r2.getLeftChild()));
	    	   
	    	   n.setRightChild(mergeTrees(r1.getRightChild(), r2.getRightChild()));
	    	   
	    	   return n;
	    	}		
        }
        return null;
        
	}  // method closes
	
	
	/* Complete this method, which should merge the linked list list1 and the circular
	   array list2, as specified in question 2 of the final exam. The merged list must be
	   stored and returned in a linked list.                                          */

	public LinkedList mergeToLinkedList(LinkedList list1, CircularArray list2) {

		LinkedList returnList = new LinkedList();

		ListNode currentListNode = list1.getFront();
		
		// data item count for return list
		int returnListCount = 0;
		
		// list1 and list2 empty
		if (list1.getNumDataItems() == 0 && list2.getNumDataItems() == 0) {
			
			return returnList;
		}

		// list1 not empty, list2 empty
		else if (list1.getNumDataItems() != 0 && list2.getNumDataItems() == 0) {
			
			returnList = list1;
			return returnList;
		}

		// list1 empty, list2 not empty
		else if (list1.getNumDataItems() == 0 && list2.getNumDataItems() > 0) {

			//initializing the linked list front and rear node
			ListNode firstNode = new ListNode();
			
			firstNode.setData(list2.getArray()[list2.getFront()]);
			
			returnList.setFront(firstNode);
			returnList.setRear(firstNode);
			
			// increment data count 
			returnList.setNumDataItems(++returnListCount);
	
			int currentArrayIndex = (list2.getFront()) % list2.getArray().length;
			int arrayRearIndex = list2.getRear();
	
			ListNode currNode = new ListNode();
			currNode = firstNode;
	
			// while not done iterating through circular array
			while (currentArrayIndex != (arrayRearIndex + 1) % list2.getArray().length) {
		
				ListNode tempNode = new ListNode();
				
				tempNode.setData(list2.getArray()[currentArrayIndex]);
				
				currNode.setNext(tempNode);
				currNode = tempNode;
				
				// increment data item count
				returnList.setNumDataItems(++returnListCount);
				
				returnList.setRear(tempNode);
				
				// increment
				currentArrayIndex = (currentArrayIndex+1) % list2.getArray().length;
		
			}
			// return the list
			return returnList;
		
		}  // end of else if

		// both lists are not empty
		else {

			// copying over list1 to our return list
			ListNode firstNode = list1.getFront();
			ListNode tempNode = new ListNode();
			
			tempNode.setData(firstNode.getData());
			
			returnList.setFront(tempNode);
			returnList.setRear(tempNode);
			
			// increment count
			returnList.setNumDataItems(++returnListCount);

			//ListNode currListNode = firstNode;
			ListNode currReturnNode = returnList.getFront();
			ListNode currListNode = firstNode.getNext();
	
			// list1 not finished and it's next is not null
			while (currListNode != null && currentListNode.getNext() != null) {

				tempNode = new ListNode();
				tempNode.setData(currListNode.getData());
				
				// set rear for resulting returnList
				returnList.setRear(tempNode);
				
				currReturnNode.setNext(tempNode);
				
				currReturnNode = currReturnNode.getNext();
				currListNode = currListNode.getNext();
				
				// increment data count
				returnList.setNumDataItems(++returnListCount);
			}
	
			// putting list2 items in the return list
			int currentArrayIndex = (list2.getFront()) % list2.getArray().length;
			int arrayRearIndex = list2.getRear();
			
			ListNode currNode;
	
			// while not done iterating through circular array
			while (currentArrayIndex != (arrayRearIndex + 1) % list2.getArray().length) {
	
				tempNode = new ListNode();
				tempNode.setData(list2.getArray()[currentArrayIndex]);
		
				currNode = returnList.getFront();
		
				// if array item less than front
				if (tempNode.getData() <= returnList.getFront().getData()) {
					
					tempNode.setNext(returnList.getFront());
					returnList.setFront(tempNode);
					
					// iterate data count
					returnList.setNumDataItems(++returnListCount);
				}
				
				// if array item greater than rear
				else if (tempNode.getData() >= returnList.getRear().getData()) {
				
					returnList.getRear().setNext(tempNode);
					returnList.setRear(tempNode);
					
					// iterate data count
					returnList.setNumDataItems(++returnListCount);
				}

				// if in between front and rear of return list
				else {
					
					// while current node is not null, nor is it's next node
					while (currNode != null && currNode.getNext() != null) {
	
						// find its place in between
						if (tempNode.getData() > currNode.getData() && tempNode.getData() <= currNode.getNext().getData()) {
							
							tempNode.setNext(currNode.getNext());
							
							currNode.setNext(tempNode);
							
							// increment data items
							returnList.setNumDataItems(++returnListCount);
							
							// get out of loop and break
							break;
						}
						
						// increment nodes
						currNode = currNode.getNext();
				
				
					}  // while closes
					
						if (currNode.getNext() == null) {
							
							returnList.getRear().setNext(tempNode);
							returnList.setRear(tempNode);
						}

				}  // else statement closes
				currentArrayIndex = (currentArrayIndex + 1) % list2.getArray().length;
			
			}  // while loop closes
			return returnList;
			
		}  // else statement closes
	
	}  // method closes

	
	
	/* Complete this method, which should return true if the warrior can defeat all the 
	    monsters along one branch of the tree; otherwise it should return false.        */   
	
	public boolean defeatMonsters(TreeNode<T> r, int attackValue) {
		
		// create stack of nodes 
		ArrayStack<TreeNode> nodesStack = new ArrayStack<TreeNode>();
	    
	    // push onto root of the tree
	    nodesStack.push(r);
	    
	    // while the stack is NOT empty
	    while (nodesStack.size() > 0) {
	        
	    	// pop item out of the stack
	    	TreeNode currentPoppedNode = nodesStack.pop();
	    	
	    	// set her attack to the attackValue
	    	int WaldaAttack = attackValue; 
	    	
	    // Visit p:
	    	
	    	/*
	    	 * IF P IS LINKED LIST TYPE
	    	 */
	    	
	    	// current node and moved it along the list
	    	if (currentPoppedNode.getData() instanceof LinkedList) {
	    		
	    		// iterate through linked list and go from there
	    		LinkedList monsterList = (LinkedList) currentPoppedNode.getData();
	    		
	    		ListNode monsterAttack = monsterList.getFront(); 	    		
	    		
	    		// iterate through the linked list
	    		while (monsterAttack != null) {
	    			
	    			if (WaldaAttack >= monsterAttack.getData()) {	
	    				
	    				// update her value
	    				WaldaAttack = WaldaAttack + monsterAttack.getData();
	    				
	    				// iterate
	    				monsterAttack = monsterAttack.getNext();
	    					    					    				
	    			// she loses and has to turn back
	    			} else {	
	    				
	    				// turn back
	    				return false;
	    			}
	    		}  // end of while loop  	
	    		
	    	}  // end of if statement
	    	
	    	/*
	    	 * IF P IS CIRCULAR ARRAY TYPE
	    	 */
	    	
	    	if (currentPoppedNode.getData() instanceof CircularArray) {
	    		
	    		CircularArray monsterAttack = (CircularArray) currentPoppedNode.getData();
	    		
	    		// for each attack integer value in the list	    		
	    		int v = monsterAttack.getFront();
	    		int rear = monsterAttack.getRear();
	    		
	    		// rear + 1
	    		int end = (rear) % (monsterAttack.getArray()).length;
	    		int index = v;
	    		
	    		while (index != end) {
	    			
	    			// if she beats the monster
	    			if (WaldaAttack >= (monsterAttack.getArray())[v]) {
	
	    				// update her attack score
	    				WaldaAttack = (monsterAttack.getArray())[v] + WaldaAttack;
	    				
	    				// increment through circular array
	    				index = (index+1) % monsterAttack.getArray().length;
	    				
	    				v = (v + 1) % monsterAttack.getArray().length;
	    					    			
	    			// she loses to monster and must turn back
	    			} else {
	    				
	    				// turn back
	    				return false;
	    			}
	    		} 		
	
	    	}  // end of if statement
	    	
	    	// reset her attack score
	    	WaldaAttack = attackValue;
	
	        // push the right child 
	        if (currentPoppedNode.getRightChild() != null) { 
	        	
	        	nodesStack.push(currentPoppedNode.getRightChild()); 
	        }
	        
	        // push the left child
	        if (currentPoppedNode.getLeftChild() != null) {
	        	
	        	nodesStack.push(currentPoppedNode.getLeftChild()); 
	        }
	        
	        // event that she's at the leaf and completed
	        if (currentPoppedNode.getLeftChild() == null && currentPoppedNode.getRightChild() == null) {
	        	
	        	// she's reached the leaves and has beaten all monsters
	        	return true;
	        }
	    }  // while loop closes
	    
	    // final return
	    return false;
	}  // method closes
		
}  // class closes
