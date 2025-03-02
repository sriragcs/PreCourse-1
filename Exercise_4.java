
// Time Complexity : O(n) to insert 
// Space Complexity : O(n) -> n is the number of tree nodes
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : No
import java.util.LinkedList;
import java.util.Queue;

public class Exercise_4 {

	/*
	 * A binary tree node has key, pointer to left child and a pointer to right
	 * child
	 */
	static class Node {
		int key;
		Node left, right;

		// constructor
		Node(int key) {
			// Initialize the node
			this.key = key;
			left = null;
			right = null;
		}
	}

	static Node root;
	static Node temp = root;

	/* Inorder traversal of a binary tree */
	static void inorder(Node temp) {
		if (temp == null)
			return;

		inorder(temp.left);
		System.out.print(temp.key + " ");
		inorder(temp.right);
	}

	/* function to insert element in binary tree */
	static void insert(Node temp, int key) {
		if (temp == null) {
			root = new Node(key);
			return;
		}

		// Level order traversal, to insert node at the first available position
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(temp);

		while (!queue.isEmpty()) {
			temp = queue.poll();

			if (temp.left == null) {
				Node newNode = new Node(key);
				temp.left = newNode;
				break;
			} else {
				queue.add(temp.left);
			}

			if (temp.right == null) {
				Node newNode = new Node(key);
				temp.right = newNode;
				break;
			} else {
				queue.add(temp.right);
			}
		}
	}

	// Driver code
	public static void main(String args[]) {
		root = new Node(10);
		root.left = new Node(11);
		root.left.left = new Node(7);
		root.right = new Node(9);
		root.right.left = new Node(15);
		root.right.right = new Node(8);

		System.out.print("Inorder traversal before insertion:");
		inorder(root);

		int key = 12;
		insert(root, key);

		System.out.print("\nInorder traversal after insertion:");
		inorder(root);
	}
}
