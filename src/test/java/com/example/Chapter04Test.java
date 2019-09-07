package com.example;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.example.Chapter02.ListNode;
import com.example.Chapter04.TreeNode;
import com.example.Chapter04.TreeNode2;

public class Chapter04Test {

	@Test
	public void testCheckBalance() {
		TreeNode root = new TreeNode(3);
		root.insert(1);
		root.insert(5);
		root.insert(2);
		root.insert(3);
		root.insert(4);
		
		System.out.println(root.toString());
		
		boolean b = Chapter04.checkBalance(root);
		
		assertEquals(true, b);
	}
	
	@Test
	public void sortedArrayToTree() {
		int[] input = { 3, 2, 1, 4, 5, 6, 7, 8, 9, 10};
		Arrays.sort(input);
		
		TreeNode node = Chapter04.sortedArrayToTree(input, 0, input.length - 1);
		System.out.println(node.toString());
		assertEquals(" 1 2 3 4 5 6 7 8 9 10", node.toString());
	}
	
	@Test
	public void testTreeToLinkedList() {
		TreeNode root = new TreeNode(3);
		root.insert(1);
		root.insert(5);
		root.insert(2);
		root.insert(3);
		root.insert(4);
		
		System.out.println(root.toString());
		
		ArrayList<ListNode> arrays = new ArrayList<>();
		Chapter04.treeToLinkedList(arrays, root, 0);
		
		for (ListNode node : arrays) {
			node.print();
		}
		
		assertEquals(3, arrays.size());
	}
	
	@Test
	public void testCheckBinarySearchTree() {
		TreeNode root = new TreeNode(3);
		root.insert(1);
		root.insert(5);
		root.insert(2);
		root.insert(3);
		root.insert(4);
		
		System.out.println(root.toString());
		
		boolean b = Chapter04.checkBinarySearchTree(root, null, false);
		
		assertEquals(false, b);
	}
	
	@Test
	public void testFindNext() {
		TreeNode2 root = new TreeNode2(3);
		root.insert(1);
		root.insert(5);
		root.insert(2);
		root.insert(3);
		root.insert(4);
		
		System.out.println(root.toString());
		
		TreeNode2 node2 = root.find(2);
		
		TreeNode2 nextNode = Chapter04.findNext(node2);
		TreeNode2 node3 = root.find(3);
		assertEquals(node3, nextNode);
	}
	
	@Test
	public void testFindCommonAncestor() {
		TreeNode root = new TreeNode(3);
		root.insert(1);
		root.insert(5);
		root.insert(2);
		root.insert(3);
		root.insert(4);
		
		System.out.println(root.toString());
		
		TreeNode node2 = root.find(2);
		TreeNode node4 = root.find(4);
		TreeNode node3 = root.find(3);
			
		TreeNode result = Chapter04.findCommonAncestor(root, node2, node4);
		
		assertEquals(node3, result);
	}
	
	@Test
	public void testIsSubTree() {
		TreeNode t2 = new TreeNode(3);
		t2.insert(1);
		t2.insert(5);
		t2.insert(2);
		t2.insert(3);
		t2.insert(4);
		
		System.out.println(t2.toString());
		
		TreeNode t1 = new TreeNode(13);
		t1.insert(11);
		t1.insert(15);
		t1.insert(12);
		t1.insert(13);
		t1.insert(14);
		t1.insert(3);
		t1.insert(1);
		t1.insert(5);
		t1.insert(2);
		t1.insert(3);
		t1.insert(4);
		
		System.out.println(t1.toString());
		
		boolean b = Chapter04.isSubTree(t1, t2);
		
		assertEquals(true, b);
	}
	
	@Test
	public void testFindValue() {
		TreeNode t1 = new TreeNode(13);
		t1.insert(11);
		t1.insert(15);
		t1.insert(12);
		t1.insert(13);
		t1.insert(14);
		t1.insert(3);
		t1.insert(1);
		t1.insert(5);
		t1.insert(2);
		t1.insert(3);
		t1.insert(4);
		
		System.out.println(t1.toString());
		
		Chapter04.findValue(t1, 7);
		
		assertEquals(false, false);
	}
}
