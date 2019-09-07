package com.example;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

// TODO: not complete yet
public class Replace {

	private static final String DICT_ITEMS[] = {"looked", "just", "like", "her", "brother", "other", "this", "is", "awesome", "we", "some", "a"};
	private static final SortedSet<String> dictionary = new TreeSet<>();
	
	static {
		Collections.addAll(dictionary, DICT_ITEMS);
	}
	
	public static void replace(String input) {
		int len = input.length();
		
		Suffix[] suffixes = new Suffix[len];
		for (int i = 0; i < len; i++)
			suffixes[i] = new Suffix(input, i);
		
		Arrays.sort(suffixes);
		
		for (int i = 0; i < len; i++) {
			System.out.println(suffixes[i].index + ":" + suffixes[i]);
		}
		
		BitSet validIndex = new BitSet();
		for (int i = 0; i < len; i++) {
		}
		
		for (int i = 0; i < len; i++) {
			for (String dict : dictionary) {
				if (suffixes[i].toString().startsWith(dict)) {
					validIndex.set(i);
				}
			}
		}
		
		System.out.println(input + "->" + validIndex.toString());
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
}
