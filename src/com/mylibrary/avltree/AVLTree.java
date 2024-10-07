package com.mylibrary.avltree;

public class AVLTree {
	
	// Node class representing each Node in the AVL tree
	
	class Node{
		int key, height;
        Node left, right;
        
        Node(int a){
        	key = a;
        	height = 1;
        }
	}
	// root of the tree
	private Node root;
	
	// maximum method
	public int max(int a,int b) {
		return(a > b) ? a : b;
	}
	
	// height method
	private int height(Node N ) {
		return (N  == null) ? 0 : N .height;
	}
	
	// calculating the balance factor of the AVL tree
	
	public int balanceFactor(Node N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}
	
	// calculating the sum of leaf values of the AVL tree (helper)
	
	private int calculateSum(Node N) {
	    if (N == null)
	        return 0;
	    return N.key + calculateSum(N.left) + calculateSum(N.right);
	}
	
	
	// Calculate the sum of leaf values of the AVL tree
	public int calculateSum() {
	    return calculateSum(root);
	}

	
	// Pre-order traversal of the tree (Root, Left, Right)
	
	public void preOrderTraversal() {
		preOrder(root);
	}
	
	// helper pre-order traversal 
	
	private void preOrder(Node N) {
		if(N != null) {
			System.out.println(N.key + " ");
			preOrder(N.left);
			preOrder(N.right);
		}
	}
	
	// In-order traversal of the tree (Left, Root, Right)
	
	public void inOrderTraversal() {
		inOrder(root);
	}
	
	// helper in-order traversal
	
	private void inOrder(Node N) {
		if (N != null) {
            inOrder(N.left);
            System.out.print(N.key + " ");
            inOrder(N.right);
        }
	}
	
	// Post-order traversal of the tree (Left, Right, Root)
	
	public void postOrderTraversal() {
		postOrder(root);
	}
	
	// helper post-order traversal
	
	private void postOrder(Node N) {
		postOrder(N.left);
		postOrder(N.right);
		System.out.println(N.key + " ");
	}
	
	// Perform a left rotation on the given node
	
	public Node leftRotate(Node N) {
		Node newRoot = N.right;  // Store the right of N which becomes the new root
		Node leftSubtreeOfNewRoot = newRoot.left;  // Store left child of the new root
		// performing the rotation
		newRoot.left = N;  // Move N to the left of the new root
		N.right = leftSubtreeOfNewRoot;  // Move the left subtree of the new root to the right of N
		// Update heights
		newRoot.height = max( height(newRoot.left) , height(newRoot.right))+1;
		N.height = max( height(N.left) , height(N.right))+1;
		// Return the new root
		return newRoot;
	}
	
	// Perform a right rotation on the given node
	
	public Node rightRotate(Node N) {
		Node newRoot = N.left;  // Store the left of N which becomes the new root
		Node rightSubtreeOfNewRoot = newRoot.right;  // Store right child of the new root
		// performing the rotation
		newRoot.right = N;  // Move N to the right of the new root
		N.left = rightSubtreeOfNewRoot;  // Move the right subtree of the new root to the left of N
		// Update heights
		newRoot.height = max( height(newRoot.left) , height(newRoot.right))+1;
		N.height = max( height(N.left) , height(N.right))+1;
		// Return the new root
		return newRoot;
	}
	
	// Insert helper: inserts a key into the subtree where N is the root and then returns the new root
	
	private Node insert(Node N, int key) {
		// first we perform normal BST insertion
		if (N == null)
			return new Node(key);
		if (key > N.key)    // if key greater than the root insert to the right
			N.right = insert(N.right, key);
		else if (key < N.key)   // if key less than the root insert to the left
			N.left = insert(N.left, key);
		else     // equal keys not allowed in BST (if key == N.key)
			return N;
		// update height of the node N
		N.height = max( height(N.left), height(N.right)) +1 ;
		// get the balance factor
		int balance = balanceFactor(N);
		// perform rotations if the node is unbalanced
		
		// Left Left insertion case
		if (balance > 1 && key < N.left.key)
			return rightRotate(N);
		// Right Right Insertion case
		if (balance < -1 && key > N.right.key)
			return leftRotate(N);
		// 	Left Right insertion case
		if (balance > 1 && key > N.left.key) {
			N.left = leftRotate(N.left);
		    return rightRotate(N);
		}
		// Right Left insertion case
		if (balance < -1 && key < N.right.key) {
			N.right = rightRotate(N.right);
			return leftRotate(N);
		}
		return N;
	}
	
	// Insert method
	
	public void insert(int key) {
		root = insert(root, key);
	}
	
	// helper function to find the maximum key value in a tree
	
	public int maxValue(Node N) {
		Node current = N;
		while (current.right != null)
			current = current.right;  // gets the key value of rightmost leaf in the tree
		return current.key;
	}
	
	// helper function to find the minimum key value in a tree
	
	public int minValue(Node N) {
		Node current = N;
		while (current.left != null)
			current = current.left;  // gets the key of the leftmost leaf in the tree
		return current.key;
	}
	
	// Method to find the minimum key value in the tree
	public int minValue() {
	    if (root == null) {
	        throw new IllegalStateException("The tree is empty");
	    }
	    return minValue(root);
	}

	// Method to find the maximum key value in the tree
	public int maxValue() {
	    if (root == null) {
	        throw new IllegalStateException("The tree is empty");
	    }
	    return maxValue(root);
	}
	
	// function to find the node with the minimum key value (used as helper for the delete method)
	
    public Node minValueNode(Node N) {
        Node current = N;
        // loop down to find the leftmost leaf (minimum value)
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete a key from the subtree with root N and return the new root
    
    private Node delete(Node N, int key) {
        //  Perform standard BST deletion
        if (N == null)
            return N;

        if (key < N.key)
            N.left = delete(N.left, key);
        else if (key > N.key)
            N.right = delete(N.right, key);
        else {
            // Node with only one child or no child
            if ((N.left == null) || (N.right == null)) {
                Node temp = null;
                if (temp == N.left)   // no left child
                    temp = N.right;
                else   // no right child
                    temp = N.left;
                // no child case
                if (temp == null) {
                    temp = N;
                    N = null;    // remove N
                } else     // one child case
                    N = temp;    // copy the contents of the non-empty child to N
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(N.right);
                // Copy the inorder successor's data to this node
                N.key = temp.key;
                // Delete the inorder successor
                N.right = delete(N.right, temp.key);
            }
        }

        // if the tree had only one node, return
        if (N == null)
            return N;

        // update the height of the current node
        N.height = max( height(N.left), height(N.right)) + 1;

        // get the balance factor of this node
        int balance = balanceFactor(N);

        // Balance the node if unbalanced

        // Left Left Case
        if (balance > 1 && balanceFactor(N.left) >= 0)
            return rightRotate(N);

        // Left Right Case
        if (balance > 1 && balanceFactor(N.left) < 0) {
            N.left = leftRotate(N.left);
            return rightRotate(N);
        }

        // Right Right Case
        if (balance < -1 && balanceFactor(N.right) <= 0)
            return leftRotate(N);

        // Right Left Case
        if (balance < -1 && balanceFactor(N.right) > 0) {
            N.right = rightRotate(N.right);
            return leftRotate(N);
        }

        return N;
    }
    
    // Delete method
    public void delete(int key) {
        root = delete(root, key);
    }
    
    // helper search method that checks if a specific key exists in a tree
    
    private boolean search(Node N, int key) {
    	if (N == null) {
    		return false;
    	}
    	if(N.key == key) {
    		return true;
    	}
    	if (key < N.key) {
    		return search(N.left, key); // search the left subtree
    	}else {
    		return search(N.right, key); // search the right subtree
    	}	
    }
    
    // Search method
    public boolean search(int key) {
    	return search(root,key);
    }
    
    // helper method for counting the number of nodes in a tree

    private int countNodes(Node N) {
        if (N == null) {
            return 0;
        } else {
            return 1 + countNodes(N.left) + countNodes(N.right);
        }
    }
    
    // returns number of nodes in a tree
    public int countNodes() {
        return countNodes(root);
    }
    
    // Checks if tree is empty
    public boolean isEmpty() {
        return root == null;
    }
    
    // Clears the tree (deletes all node)
    public void clear() {
        root = null;
    }
}
