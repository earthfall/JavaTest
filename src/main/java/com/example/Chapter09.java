package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Chapter09 {

	public static int countLadder(int n) {
		int[] cache = new int[n + 1];
		Arrays.fill(cache, -1);
		
		cache[0] = 0;
		cache[1] = 1;
		cache[2] = 2;
		
		return countLadderWithCache(n, cache);
	}
	
	private static int countLadderWithCache(int n, int[] cache) {
		if (cache[n] != -1) {
			return cache[n];
		}

		cache[n] = countLadderWithCache(n - 1, cache) + countLadderWithCache(n - 2, cache)
				+ countLadderWithCache(n - 3, cache);
		
		return cache[n];
	}
	

	public static int findMagicIntex(int[] A) {
		return findMagicIndexRanged(A, 0, A.length - 1);
	}
	
	private static int findMagicIndexRanged(int[] A, int start, int end) {
		if (end < start) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (A[mid] == mid) {
			return mid;
		} else if (A[mid] > mid) {
			return findMagicIndexRanged(A, start, mid - 1);
		} else {
			return findMagicIndexRanged(A, mid + 1, end);
		}
	}

	public static void findAllSubSet(int[] input) {
		int len = input.length;
		
		for (int i = 0; i < (1 << len); i++) {
			for (int j = 0; j < len; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(String.valueOf(input[j]) + ' ');
				}
			}
			
			System.out.println();
		}
	}
	
	// DP 문제 정의 검토
	public static int findCoinCombination(int n) {
		final int[] coins = {1, 5, 10, 25};
		
		int[][] cache = new int[coins.length][n + 1];
				
		return findCoinInternal(coins, 0, n, cache);
	}
	
	private static int findCoinInternal(int[] coins, int j, int n, int[][] cache) {
		if (j >= coins.length - 1) {
			return 1;
		}
		
		if (cache[j][n] > 0) {
			return cache[j][n];
		}
		
		int count = 0;
		for (int i = 0; i * coins[j] <= n; i++) {
			count += findCoinInternal(coins, j + 1, n - i * coins[j], cache);
		}
		
		cache[j][n] = count;
		return count;
	}
	
	// 2차원 array 대신에 1개의 column에 하나의 Queen만 올 수 있기 때문에 column 별 Queen의 position만 표시
	public static void placeEightQueen(int row, int[] col, ArrayList<Integer[]> result) {
		if (row == 8) {
			Integer[] entry = new Integer[8];
			for (int i = 0; i < col.length; i++) {
				entry[i] = col[i];
			}
			result.add(entry);
			Arrays.fill(col, 0);
			return;
		}
		
		for (int i = 0; i < 8; i++) {
			if (!isValidPosition(row, i, col)) {
				continue;
			}
			
			col[row] = i;
			placeEightQueen(row + 1, col, result);
		}
	}
	
	private static boolean isValidPosition(int row, int column, int cols[]) {	
		for (int i = 0; i < row; i++) {
			int diff = cols[i] - column;
			
			if (diff == 0) {
				return false;
			}
			
			if (row - i == Math.abs(diff)) {
				return false;
			}
		}
		
		return true;
	}
	
	// Memorization 필요
	public static int findExpectedValue(char[] input, int start, int end, boolean result) {
		if (start == end) {
			if (input[start] == '1' && result) {
				return 1;
			} else if (input[start] == '0' && !result) {
				return 1;
			} else {
				return 0;
			}
		}
		
		int count = 0;
		if (result) {
			for (int i = start + 1; i <= end; i += 2) {

				switch (input[i]) {
				case '|':
					count += findExpectedValue(input, start, i - 1, true) * findExpectedValue(input, i + 1, end, true)
							+ findExpectedValue(input, start, i - 1, true) * findExpectedValue(input, i + 1, end, false)
							+ findExpectedValue(input, start, i - 1, false) * findExpectedValue(input, i + 1, end, true);
					break;
				case '&':
					count += findExpectedValue(input, start, i - 1, true) * findExpectedValue(input, i + 1, end, true);
					break;
				case '^':
					count += findExpectedValue(input, start, i - 1, true) * findExpectedValue(input, i + 1, end, false)
							+ findExpectedValue(input, start, i - 1, false) + findExpectedValue(input, i + 1, end, true);
					break;
				}
			}
		} else {
			for (int i = start + 1; i <= end; i += 2) {

				switch (input[i]) {
				case '|':
					count += findExpectedValue(input, start, i - 1, false) * findExpectedValue(input, i + 1, end, false);
					break;
				case '&':
					count += findExpectedValue(input, start, i - 1, false) * findExpectedValue(input, i + 1, end, false)
							+ findExpectedValue(input, start, i - 1, false) * findExpectedValue(input, i + 1, end, true)
							+ findExpectedValue(input, start, i - 1, true) * findExpectedValue(input, i + 1, end, false);
					break;
				case '^':
					count += findExpectedValue(input, start, i -1, true) * findExpectedValue(input, i + 1, end, true)
							+ findExpectedValue(input, start, i - 1, false) + findExpectedValue(input, i + 1, end, false);
					break;
				}
			}
		}
		
		return count;
	}
}
