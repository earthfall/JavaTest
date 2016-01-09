package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter01Test {

	@Test
	public void testCheckUniqueString() {
		boolean b = Chapter01.checkUniqueString("aabcde");
		assertEquals(false, b);
		
		b = Chapter01.checkUniqueString("abcde");
		assertEquals(true, b);
	}

	@Test
	public void testCheckPerm() {
		boolean b = Chapter01.checkPerm("done", "oned");
		assertEquals(true, b);
		
		b = Chapter01.checkPerm("dooo", "dool");
		assertEquals(false, b);
	}
	
	@Test
	public void testReplaceEmptySpace() {
		char[] input = new String("Mr John Smith    ").toCharArray();
		Chapter01.replaceEmptySpace(input, 13);
		assertEquals("Mr%20John%20Smith", new String(input));
	}
	
	@Test
	public void testEncode() {
		assertEquals("a2b1c8a3", Chapter01.encode("aabccccccccaaa"));
	}
	
	@Test
	public void testRotate() {
		int[][] picture = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		
		Chapter01.roate(picture, 4);
		
		assertEquals(13, picture[0][0]);
		assertEquals(4, picture[3][3]);
	}
	
	@Test
	public void testSetZero() {
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 0, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		
		Chapter01.setZero(input);
		
		assertEquals(0, input[0][2]);
		assertEquals(0, input[1][0]);
	}
}
