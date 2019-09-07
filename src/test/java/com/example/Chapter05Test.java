package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter05Test {

	@Test
	public void testInsertNumber() {
		int ret = Chapter05.insertNumber(0b10000000000, 0b10011, 2, 6);
		
		assertEquals(0b10001001100, ret);
	}

	@Test
	public void testPrintDouble() {
		
		String ret = Chapter05.printDouble(0.625);
		
		assertEquals("0.101", ret);
	}
	
	@Test
	public void testFindNearestNumber() {
		
		assertEquals(0b11011010001111, Chapter05.findNearestNext(0b11011001111100));
		
		assertEquals(0b0010_0111_0111_0000, Chapter05.findNearestPrev(0b10011110000011));
	}
	
	@Test
	public void testNextSetIndex() {
		int index = Chapter05.nextSetBit(0b0101011100, 0);
		assertEquals(2, index);
		
		index = Chapter05.nextClearBit(0b00000111, 0);
		assertEquals(3, index);
		
		index = Chapter05.prevSetBit(0b0101011100, 32);
		assertEquals(8, index);
		
		assertEquals(true, Chapter05.hasAllOne(0b11111));
		assertEquals(false, Chapter05.hasAllOne(0b11101));
	}
	
	@Test
	public void testComputeBitDiff() {
		assertEquals(2, Chapter05.computeBitDiff(0b11101, 0b01111));
	}
	
	@Test
	public void testSwapEvenAndOdd() {
		assertEquals(0, Chapter05.swapEvenAndOdd(0));
		assertEquals(0b01010, Chapter05.swapEvenAndOdd(0b10101));
	}
	
	@Test
	public void testFindMissingInt() {
		int arr[] = {0, 1, 2, 3, 5, 6, 7, 8, 9};
		assertEquals(4, Chapter05.findMissingInt(arr, 9));
	}
}
