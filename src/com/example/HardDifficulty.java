package com.example;

import java.util.Random;

public class HardDifficulty {

	public static int add(int a, int b) {
		
		while (b != 0) {
			int carry = (a & b) << 1;
			
			a = a ^ b;
			b = carry;
		}
		
		return a;
		
		/*
		if (b == 0) {
			return a;
		}
		
		if (a == 0) {
			return b;
		}
		
		int val = a ^ b;
		int carry = (a & b) << 1;
		return add(val, carry);
		*/
	}
	
	public static int minus(int a, int b) {
		if (b == 0) {
			return a;
		}
		
		int borrow = ((~a) & b) << 1;
		int val = a ^ b;
		
		return minus(val, borrow);
	}
	
	// http://www.geeksforgeeks.org/shuffle-a-given-array
	// https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
	public static void shuffleCard(int[] cards) {
		Random random = new Random();
		
		for (int len = cards.length; len > 0; len--) {
			
			int j = random.nextInt(len);
			
			int temp = cards[len];
			cards[len] = cards[j];
			cards[j] = temp;
		}
	}
	
	public static void pickRandom(int[] array, int m) {
		int[] subset = new int[m];
		
		for (int i = 0; i < m; i++) {
			subset[i] = array[i];
		}
		
		Random random = new Random();
		for (int i = m; i < array.length; i++) {
			int j = random.nextInt(i);
			if (j < m) {
				subset[j] = array[i];
			}
		}
	}
	
	public static void countTwo(int n) {
		int count = 0;
		for (int i = 0; i <= n; i++) {
			count += getTwoCount(i);
		}
		
		System.out.println(n + " -> " + count);
	}
	
	private static int getTwoCount(int i) {
		int count = 0;
		do {
			if (i % 10 == 2) {
				count++;
			}
			i = i / 10;
		} while (i != 0);
		
		return count;
	}
}
