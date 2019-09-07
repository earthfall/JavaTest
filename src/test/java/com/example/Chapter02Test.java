package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.Chapter02.ListNode;

public class Chapter02Test {

	@Test
	public void testFindLastKth() {
		ListNode root = new ListNode(4);
		root.append(2);
		root.append(1);
		root.append(3);
		root.append(5);
		
		int ret = Chapter02.findLastKth(root, 3);
		
		assertEquals(1, ret);
	}

	@Test
	public void testOrganizeWithNumber() {
		
		ListNode root = new ListNode(4);
		root.append(2);
		root.append(5);
		root.append(1);
		root.append(6);
		root.append(7);
		root.append(3);
		
		root.print();
		
		ListNode node = Chapter02.orgnazeWithValue(root, 3);
		node.print();
		
		assertEquals(2, node.data);
		assertEquals("2145673", node.toString());
	}
	
	@Test
	public void testAddList() {
		ListNode left = new ListNode(7);
		left.append(1);
		left.append(6);
		
		ListNode right = new ListNode(5);
		right.append(9);
		right.append(2);
		
		ListNode sum = Chapter02.addList(left, right);
		sum.print();
		
		assertEquals("219", sum.toString());
	}
	
	@Test
	public void testAddList2() {
		ListNode left = new ListNode(7);
		left.append(1);
		left.append(6);
		
		ListNode right = new ListNode(5);
		right.append(9);
		right.append(2);
		
		ListNode sum = Chapter02.addList2(left, right, 0);
		sum.print();
		
		assertEquals("219", sum.toString());
	}
	
	@Test
	public void testGetCycleNode() {
		ListNode root = new ListNode(1);
		root.append(2);
		root.append(3);
		root.append(4);
		root.append(5);
		
		ListNode node3 = root.next.next;
		ListNode node5 = node3.next.next;
		node5.next = node3;
		
		ListNode result = Chapter02.getCycleNode(root);
		
		assertEquals(3, result.data);
	}
	
	@Test
	public void testIsPalindrome() {
		ListNode root = new ListNode(0);
		root.append(1);
		root.append(2);
		root.append(1);
		root.append(0);
		
		boolean b = Chapter02.isPalindrome(root);
		assertEquals(true, b);
	}
}
