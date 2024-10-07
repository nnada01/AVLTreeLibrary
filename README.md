# AVL Tree Library

AVLTreeLibrary is a Java library that provides an implementation of an AVL Tree.An AVL tree is a self-balancing binary search tree where the difference in heights between the left and right subtrees cannot be more than one for all nodes.

## Features

- **Insert**: Add a key to the AVL tree while maintaining balance.
- **Delete**: Remove a key from the AVL tree and rebalance if necessary.
- **Search**: Check if a specific key exists in the AVL tree.
- **Traversal**:
  - **Pre-order**: Visit the root, then left subtree, followed by right subtree.
  - **In-order**: Visit the left subtree, then the root, followed by the right subtree.
  - **Post-order**: Visit the left subtree, then the right subtree, followed by the root.
- **Calculate Sum**: Calculate the sum of all leaf node values in the AVL tree.
- **Find Minimum and Maximum**: Get the minimum and maximum key values in the AVL tree.
- **Count Nodes**: Count the total number of nodes in the tree.
- **Check if Empty**: Determine if the tree is empty.
- **Clear**: Remove all nodes from the tree.

## Method Descriptions

### `void insert(int key)`
Inserts a key into the AVL tree and balances the tree if necessary.

### `void delete(int key)`
Removes a key from the AVL tree and rebalances it.

### `boolean search(int key)`
Checks if a specific key exists in the AVL tree.

### `void preOrderTraversal()`
Performs a pre-order traversal of the tree and prints the keys.

### `void inOrderTraversal()`
Performs an in-order traversal of the tree and prints the keys.

### `void postOrderTraversal()`
Performs a post-order traversal of the tree and prints the keys.

### `int calculateSum()`
Calculates and returns the sum of all leaf node values in the AVL tree.

### `int minValue()`
Returns the minimum key value in the AVL tree. Throws an exception if the tree is empty.

### `int maxValue()`
Returns the maximum key value in the AVL tree. Throws an exception if the tree is empty.

### `int countNodes()`
Returns the total number of nodes in the AVL tree.

### `boolean isEmpty()`
Checks if the AVL tree is empty.

### `void clear()`
Removes all nodes from the AVL tree, effectively clearing it.


## Testing

The project includes tests for all the implemented methods. You can run the tests from the AVLTreeTest class.


## Usage

To use this library, create an instance of `AVLTree` and call its methods:

```java
AVLTree tree = new AVLTree();
tree.insert(10);
tree.insert(20);
tree.insert(5);

// Traverse the tree
System.out.println("Pre-order traversal:");
tree.preOrderTraversal();

System.out.println("In-order traversal:");
tree.inOrderTraversal();

System.out.println("Post-order traversal:");
tree.postOrderTraversal();

// Calculate sum of leaf nodes
int sum = tree.calculateSum();
System.out.println("Sum of all leaf node values: " + sum);

// Find minimum and maximum key values
System.out.println("Minimum key value: " + tree.minValue());
System.out.println("Maximum key value: " + tree.maxValue());

// Count nodes
int nodeCount = tree.countNodes();
System.out.println("Number of nodes in the tree: " + nodeCount);



