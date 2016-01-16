package com.example;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Chapter09Test {

	@Test
	public void testCountLadder() {
		assertEquals(3, Chapter09.countLadder(3));
		assertEquals(6, Chapter09.countLadder(4));
	}

	@Test
	public void testFindMagicIntex() {
		int[] A = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
		
		assertEquals(7, Chapter09.findMagicIntex(A));
	}
	
	@Test
	public void testFindAllSubSet() {
		int[] set = { 1, 2, 3, 4, 5 };

		Chapter09.findAllSubSet(set);
	}
	
	@Test
	public void testFindCoinCombination() {
		assertEquals(4246, Chapter09.findCoinCombination(100));
	}
	
	@Test
	public void testPlaceEightQueens() {
		
		ArrayList<Integer[]> result = new ArrayList<>();
		int[] cols = new int[8];
		Chapter09.placeEightQueen(0, cols, result);
	}
	
	@Test
	public void testFindExpectedValue() {
		char[] input = {'1', '^', '0', '|', '0', '|', '1'};
		assertEquals(2, Chapter09.findExpectedValue(input, 0, input.length - 1, false));
	}
}
