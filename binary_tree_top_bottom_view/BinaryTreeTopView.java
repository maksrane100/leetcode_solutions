package com.example.codility.test.data_structure8;


import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

class Node {
	int val;
	Node left, right;

	public Node(int val) {
		this.val = val;
		left = right = null;
	}
}

//class of binary tree
class BinaryTreeTopView {
	Node root;

	public BinaryTreeTopView() {
		root = null;
	}

	// top view of binary tree
	private void showTopView(Node root) {
		
		class NodeDistance {
			Node node;
			int distance;

			NodeDistance(Node node, int hd) {
				this.node = node;
				this.distance = hd;
			}
		}
		
		
		Queue<NodeDistance> queue = new LinkedList<NodeDistance>();
		
		Map<Integer, Node> map = new TreeMap<Integer, Node>();

		if (root == null) {
			return;
		} else {
			queue.add(new NodeDistance(root, 0));
		}


		// traverse the binary tree and add the nodes into the map only if there is no entry present. this way we can 
		// capture the top view of the tree
		while (!queue.isEmpty()) {
			
			NodeDistance tmp = queue.poll();
			
			if (!map.containsKey(tmp.distance)) {
				map.put(tmp.distance, tmp.node);
			}
			
			
			// if we are going to the left, we will subtract 1 from the distance
			if (tmp.node.left != null) {
				
				queue.add(new NodeDistance(tmp.node.left, tmp.distance - 1));
			}
			
			// if we are going to the right, we will add 1 to the distance
			if (tmp.node.right != null) {
				queue.add(new NodeDistance(tmp.node.right, tmp.distance + 1));
			}
		}
		
		for (Entry<Integer, Node> entry : map.entrySet()) {
			System.out.print(entry.getValue().val+" ");
		}
	}

	public static void main(String[] args) {
		
		BinaryTreeTopView tree = new BinaryTreeTopView();
		tree.root = new Node(200);
		tree.root.left = new Node(40);
		tree.root.right = new Node(400);
		tree.root.left.right = new Node(20);
		tree.root.left.right.right = new Node(80);
		tree.root.left.right.right.left = new Node(10);
		tree.root.left.right.right.right = new Node(60);
		System.out.println("Top view :");
		tree.showTopView(tree.root);
	}
}
