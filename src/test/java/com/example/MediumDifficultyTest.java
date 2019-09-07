package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class MediumDifficultyTest {

	@Test
	public void testGetSubsequentZero() {
		assertEquals(2, MediumDifficulty.getSubsequentZero(10));
		assertEquals(2, MediumDifficulty.getSubsequentZero(14));
		assertEquals(3, MediumDifficulty.getSubsequentZero(15));
		assertEquals(6, MediumDifficulty.getSubsequentZero(25));
	}
	
	@Test
	public void testFindMax() {
		assertEquals(321, MediumDifficulty.findMax(321, 123));
	}
	
	@Test
	public void testMakeIncreasingNum() {
		
		MediumDifficulty.makeIncreasingNum(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
	}

	@Test
	public void testRead3269267() {
		String val = MediumDifficulty.readInt(3269267);
		System.out.println(val);
	}

	@Test
	public void testRead321() {
		String val = MediumDifficulty.readSmall(321);
		System.out.println(val);
	}
	
	@Test
	public void testRead115() {
		String val = MediumDifficulty.readSmall(115);
		System.out.println(val);
	}
	
	@Test
	public void testRead101() {
		String val = MediumDifficulty.readSmall(101);
		System.out.println(val);
	}
	
	@Test
	public void testRead110() {
		String val = MediumDifficulty.readSmall(110);
		System.out.println(val);
	}
	
	@Test
	public void testGetMaxSum() {
		int array[] = {2, -8, 3, -2, 4, -10};
		int val = MediumDifficulty.getMaxSum(array);
		System.out.println(val);
		assertEquals(5, val);
	}
	
	@Test
	public void testConvertTreeToList() {
		BiNode root = new BiNode(4);
		BiNode.treeInsert(root, 2);
		BiNode.treeInsert(root, 1);
		BiNode.treeInsert(root, 3);
		BiNode.treeInsert(root, 5);

		BiNode.printTree(root);
		System.out.println();

		BiNode head = MediumDifficulty.convertTreeToList(root);
		BiNode.printList(head);
	}
	
	@Test
	public void testPrintPair() {
		int[] input = {-2, -1, 0, 3, 5, 6, 7, 9, 13, 14};
		
		MediumDifficulty.printPair(input, 8);
	}
	
	@Test
	public void testParseSentence() {
		Replace.replace("thisisawesome");
		//Replace.replace("jesslookedjustliketimherbrother");
	}
}
