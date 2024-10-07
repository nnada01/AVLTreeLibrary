package com.mylibrary.avltree;

public class AVLTreeTest {
	
	public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Test insertions
        System.out.println("Inserting values into the AVL Tree...");
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(10);
        tree.insert(25);
        tree.insert(35);
        tree.insert(50);

        // Test in-order traversal
        System.out.println("In-order Traversal:");
        tree.inOrderTraversal();  // Expected output: 10, 20, 25, 30, 35, 40, 50
        System.out.println();

        // Test search method
        System.out.println("Searching for values...");
        System.out.println("Is 25 present? " + tree.search(25));  // Expected: true
        System.out.println("Is 60 present? " + tree.search(60));  // Expected: false

        // Test count nodes
        System.out.println("Total nodes in the tree: " + tree.countNodes());  // Expected: 7

        // Test minimum and maximum key values
        System.out.println("Minimum key value: " + tree.minValue());  // Expected: 10
        System.out.println("Maximum key value: " + tree.maxValue());  // Expected: 50

        // Test deleting a node
        System.out.println("Deleting node 20...");
        tree.delete(20);
        System.out.println("In-order Traversal after deletion:");
        tree.inOrderTraversal();  // Expected output: 10, 25, 30, 35, 40, 50
        System.out.println();

        // Test deleting a node with no children
        System.out.println("Deleting node 10...");
        tree.delete(10);
        System.out.println("In-order Traversal after deletion:");
        tree.inOrderTraversal();  // Expected output: 25, 30, 35, 40, 50
        System.out.println();

        // Test deleting a node with one child
        System.out.println("Deleting node 30...");
        tree.delete(30);
        System.out.println("In-order Traversal after deletion:");
        tree.inOrderTraversal();  // Expected output: 25, 35, 40, 50
        System.out.println();

        // Test calculating sum of leaf nodes
        int sum = tree.calculateSum();
        System.out.println("Sum of all leaf node values: " + sum);  // Expected output: 25 + 35 + 40 + 50 = 150

        // Test checking if the tree is empty
        System.out.println("Is the tree empty? " + tree.isEmpty());  // Expected: false

        // Clear the tree
        System.out.println("Clearing the tree...");
        tree.clear();
        System.out.println("Is the tree empty? " + tree.isEmpty());  // Expected: true
    }

}
