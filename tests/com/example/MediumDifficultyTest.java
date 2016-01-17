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
}
