package com.example;

public class BiNode {
	public BiNode node1, node2;
	public int data;
	
	public BiNode(int val) {
		data = val;
	}
	
	public static void treeInsert(BiNode root, int newData) {
		if (newData <= root.data) {
			if (root.node1 != null)
				treeInsert(root.node1, newData);
			else
				root.node1 = new BiNode(newData);
		} else {
			if (root.node2 != null)
				treeInsert(root.node2, newData);
			else
				root.node2 = new BiNode(newData);
		}
	}
	
	public static BiNode append(BiNode a, BiNode b) {
		if (a == null)
			return b;
		
		if (b == null)
			return a;
		
		BiNode aLast = a.node1;
		BiNode bLast = b.node1;
		
		join(aLast, b);
		join(bLast, a);
		
		return a;
	}
	
	private static void join(BiNode a, BiNode b) {
		a.node2 = b;
		b.node1 = a;
	}
	
	public static void printTree(BiNode root) {
		if (root == null)
			return;

		printTree(root.node1);
		System.out.print(Integer.toString(root.data) + " ");
		printTree(root.node2);
	}
	
	public static void printList(BiNode head) {
		BiNode current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.data) + " ");
			current = current.node2;
			if (current == head)
				break;
		}

		System.out.println();
	}
}
