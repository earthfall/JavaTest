package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

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
	
	public static String findLongestCombinationWord(String[] input) {
	
		Arrays.sort(input, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		
		HashMap<String, Boolean> map = new HashMap<>();
		for (String s : input) {
			map.put(s, true);
		}
				
		for (String s : input) {
			if (makeCombination(s, map)) {
				return s;
			}
		}
		
		return "";
	}
	
	private static boolean makeCombination(String s, HashMap<String, Boolean> map) {
		if (map.containsKey(s)) {
			return true;
		}
		
		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			
			Boolean bl = map.get(left);
			if (bl == null) {
				continue;
			}
			
			if (bl && makeCombination(right, map)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void findWordInWord(String s, String[] T) {
		
		Suffix[] suffixes = new Suffix[s.length()];
		for (int i = 0; i < s.length(); i++) {
			suffixes[i] = new Suffix(s, i);
		}
		
		Arrays.sort(suffixes);
		
		HashSet<String> set = new HashSet<>();
		Collections.addAll(set, T);
		for (Suffix suffix : suffixes) {
			String val = suffix.toString();
			if (set.contains(val)) {
				System.out.println(val);
			}
		}
	}
	
	private static class Suffix implements Comparable<Suffix> {
		private final String text;
		private final int index;
		
		private Suffix(String text, int index) {
			this.text = text;
			this.index = index;
		}
		
		private int length() {
			return text.length() - index;
		}
		
		private char charAt(int i) {
			return text.charAt(index + i);
		}
		
		public int compareTo(Suffix right) {
			if (this == right)
				return 0;
			
			int i;
			int len = Math.min(length(), right.length());
			for (i = 0; i < len; i++) {
				char c1 = charAt(i);
				char c2 = right.charAt(i);
				if (c1 != c2)
					return c1 - c2;
			}
			
			return length() - right.length(); 
		}
		
		public String toString() {
			return text.substring(index);
		}
	}
	
	public static void convertWord(String left, String right) {
		if (left.length() != right.length()) {
			System.out.println("Word size does not match");
			return;
		}
		
		final Set<String> dictionary = new HashSet<>();
		final String WORDS[] = {"DAMP", "LAMP", "LIMP", "LIME", "LIKE", "TEST", "WORD", "CARD", "DECK", "DAMN", "DOLL"};
		Collections.addAll(dictionary, WORDS);
	
		Queue<String> queue = new LinkedList<>();
		Set<String> visit = new HashSet<>();

		queue.add(left);
		visit.add(left);
		
		while (!queue.isEmpty()) {
			String w = queue.poll();
			
			for (String v : iterate(w)) {
				if (v.equals(right)) {
					System.out.println("Finished");
					return;
				}
				
				if (dictionary.contains(v)) {
					if (!visit.contains(v)) {
						queue.add(v);
						visit.add(v);
						System.out.println(v);
					}
				}
			}
		}
	}
	
	private static Set<String> iterate(String word) {
		Set<String> words = new TreeSet<>();
		char[] wordArray = word.toCharArray();
		char prev;
		for (int i = 0; i < word.length(); i++) {
			prev = wordArray[i];
			
			for (char ch = 'A'; ch <= 'Z'; ch++) {
				if (ch != prev) {
					wordArray[i] = ch;
					words.add(new String(wordArray));
					wordArray[i] = prev;
				}
			}
		}
		
		return words;
	}
}
