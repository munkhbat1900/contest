package datastructures.binarytree;

/**
 * @author Munkhbat
 * Binary Tree
 */
public class BinaryTree {
	private Node root;

	public BinaryTree() {
		root = null;
	}

	public boolean search(int key) {
		Node tmp = root;
		while (tmp != null) {
			if (tmp.value > key) {
				tmp = tmp.left;
			} else if (tmp.value < key) {
				tmp = tmp.right;
			} else {
				return true;
			}
		}
		return false;
	}

	private boolean searchRec(int key, Node node) {
		if (node == null) {
			return false;
		}

		if (node.value > key) {
			return searchRec(key, node.left);
		} else if (node.value < key) {
			return searchRec(key, node.right);
		} else {
			return true;
		}
	}

	public boolean searchRecursive(int key) {
		return searchRec(key, root);
	}

	public void insertRecursive(int key) {
		root = insertRec(key, root);
	}

	public Node insertRec(int key, Node node) {
		if (node == null) {
			node = new Node(key);
		} else {
			if (key <= node.value) {
				node.left = insertRec(key, node.left);
			} else {
				node.right = insertRec(key, node.right);
			}
		}
		return node;
	}

	public void preOrder() {
		preOrder(root);
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	public void inOrder() {
		inOrder(root);
	}

	public void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.value);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void postOrder(Node node) {
		if (node != null) {
			preOrder(node.left);
			preOrder(node.right);
			System.out.println(node.value);
		}
	}
	
	public void inOrder(Node node) {
		if (node != null) {
			preOrder(node.left);
			System.out.println(node.value);
			preOrder(node.right);
		}
	}

	private class Node {
		private int value;
		private Node left;
		private Node right;

		public Node (int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insertRecursive(5);
		tree.insertRecursive(7);
		tree.insertRecursive(11);
		tree.insertRecursive(1);
		tree.insertRecursive(3);
		tree.insertRecursive(4);
		tree.insertRecursive(1234);
		tree.insertRecursive(2000);
		tree.insertRecursive(23);
		tree.insertRecursive(54);
		tree.preOrder();
		System.out.println(tree.search(54));
		System.out.println(tree.search(105));
		System.out.println(tree.searchRecursive(54));
		System.out.println(tree.searchRecursive(105));
		tree.inOrder();
		tree.postOrder();
	}
}
