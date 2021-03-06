package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class HardDifficultyTest {

	@Test
	public void testAdd() {
		
		assertEquals(12 + 92, HardDifficulty.add(12, 92));
		assertEquals(321 - 12, HardDifficulty.minus(321,12));
	}

	@Test
	public void testCount25() {
		HardDifficulty.countTwo(25);
	}

	@Test
	public void testCount2000000000() {
		HardDifficulty.countTwo(2000000000);
	}
	
	@Test
	public void testCount20000() {
		HardDifficulty.countTwo(20000);
	}
	
	@Test
	public void testFindLongestCombinationWord() {
		String[] input = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
		
		assertEquals("dogwalker", HardDifficulty.findLongestCombinationWord(input));
	}
	
	@Test
	public void testfindWordInWord() {
		String[] input = {"b", "ibs", "ad2", "s", "a", "ca", "zq"};
		
		HardDifficulty.findWordInWord("bibs", input);
	}
	
	@Test
	public void testConvertWord() {
		HardDifficulty.convertWord("DAMP", "LIKE");
	}
}
