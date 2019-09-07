package com.example;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Chapter10Test {

	@Test
	public void testQuickSort() {
		int[] x = {9, 2, 4, 7, 3, 7, 10};
		Chapter10.quickSort(x, 0, x.length - 1);
		System.out.println(Arrays.toString(x));
	}

	@Test
	public void testSelectionSort() {
		int[] x = {9, 2, 4, 7, 3, 7, 10};
		Chapter10.sortBySelection(x, x.length - 1);
		System.out.println(Arrays.toString(x));
	}
	
	@Test
	public void testMergeSortedArray() {
		int[] A = new int[20];
		int[] tmp = {1, 3, 6, 8, 9};
		System.arraycopy(tmp, 0, A, 0, tmp.length);
		int[] B = {2, 3, 6, 12, 16};
		int[] result = {1, 2, 3, 3, 6, 6, 8, 9, 12, 16};
		
		Chapter10.mergeSortedArray(A, B);
		assertEquals(Arrays.toString(result).substring(0, 31), Arrays.toString(A).substring(0, 31));
	}
	
	@Test
	public void testAnagramSort() {
		String[] input = {"abc", "abf", "cab"};
		
		Chapter10.anagramSort(input);
		
		String[] result = {"abc", "cab", "abf"};
		
		assertEquals(Arrays.toString(result), Arrays.toString(input));
	}
	
	@Test
	public void testFindElement() {
		assertEquals(8, Chapter10.findElement(new int[] { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 }, 5));
	}
	
	@Test
	public void testFindWordPos() {
		assertEquals(4, Chapter10.findWordPos(new String[] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
	}
	
	@Test
	public void testFindElementFromMatrix() {
		int[][] array = {{15, 20, 40, 85}, {10, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
		
		Chapter10.findElementFromMatrix(array, 55);
	}
	
	@Test
	public void testRank() {	
		int[] x = {5, 1, 4, 4, 5, 9, 7, 13, 3};
		Chapter10.tracks(x);
		
		assertEquals(0, Chapter10.getRankOfNumber(1));
		assertEquals(1, Chapter10.getRankOfNumber(3));
		assertEquals(3, Chapter10.getRankOfNumber(4));
		assertEquals(5, Chapter10.getRankOfNumber(5));
	}
}
