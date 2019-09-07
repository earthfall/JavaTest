package com.example;

import java.util.Arrays;

public class MediumDifficulty {

	public static void replace(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
	}
	
	// 5�� ����� ���ؼ��� Ȯ���ϴ� �˰������� �� ȿ���� 
	public static int getSubsequentZero(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int tmp = i;
			while (tmp % 5 == 0) {
				count++;
				tmp /= 5;
			}
		}
		return count;
	}
	
	public static int findMax(int a, int b) {
		int c = a - b;
		int sign = (c >> 31) & 0x1;
		return a - sign * c;
	}
	
	// ������ sorting �� diff index ���
	public static void makeIncreasingNum(int[] array) {
		int max = -1;
		for (int i : array) {
			if (i > max) {
				max = i;
			}
		}
		
		int count[] = new int[max + 1];
		for (int i : array) {
			count[i]++;
		}
		
		int[] sorted = new int[array.length];
		int index = 0;
		for (int i = 0; i <= max; i++) {
			while (count[i] > 0) {
				sorted[index++] = i;
				count[i]--;
			}
		}
		
		int minDiff = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != sorted[i]) {
				minDiff = i;
				break;
			}
		}
		
		int maxDiff = -1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] != sorted[i]) {
				maxDiff = i;
				break;
			}
		}
		
		System.out.println("(" + minDiff + ", " + maxDiff + ")");
	}

	private static final String INT_VALUES[] = { null, "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eightteen",
			"Nineteen", };

	private static final String TENS[] = { null, "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninty" };

	private static final String THOUSANDS[] = { "", "Thousand", "Million" };

	public static String readInt(int input) {

		StringBuilder builder = new StringBuilder(512);
		int val;
		int count = 0;
		while (input > 0) {
			val = input % 1000;
			if (val != 0) {
				builder.insert(0, ' ');
				builder.insert(0, THOUSANDS[count]);
				builder.insert(0, ' ');
				builder.insert(0, readSmall(val));
			}

			count++;
			input /= 1000;
		}

		return builder.toString();
	}

	public static String readSmall(int input) {
		if (input < 20) {
			return INT_VALUES[input];
		}

		StringBuilder output = new StringBuilder(256);
		int tmp = input / 100;
		if (tmp != 0) {
			output.append(INT_VALUES[tmp]).append(' ').append("Hundred");
		}

		tmp = input % 100;
		if (tmp < 20) {
			output.append(' ');
			output.append(INT_VALUES[tmp]);
			return output.toString();
		}

		int tens = tmp / 10;
		tmp = tmp % 10;
		if (tens > 0) {
			output.append(' ');
			output.append(TENS[tens]);
		}

		output.append(' ');
		output.append(INT_VALUES[tmp]);

		return output.toString();
	}
	
	// Memoization�� ���ؼ� O(n^3)�� �˰����� ���� ����
	// �׺��ٴ� �˰��������� sum�� Ŀ���� �� ���θ� Ȯ���ϴ� �� �� ȿ����
	public static int getMaxSum(int[] array) {
		int len = array.length;
		
		int max = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				max = Math.max(max, getSum(array, i, j));
			}
		}
		
		return max;
	}
	
	private static int getSum(int[] array, int i, int j) {
		int sum = 0;
		for (int index = i; index < j; index++) {
			sum += array[index];
		}
		return sum;
	}
	
	public static BiNode convertTreeToList(BiNode node) {
		if (node == null)
			return null;
		
		BiNode left = convertTreeToList(node.node1);
		BiNode right = convertTreeToList(node.node2);
		
		node.node1 = node;
		node.node2 = node;
		
		left = BiNode.append(left, node);
		left = BiNode.append(left, right);
			
		return left;
	}
	
	// ���� �� ����
	public static void printPair(int[] array, int n) {
		Arrays.sort(array);
		
		int first = 0;
		int last = array.length - 1;
		
		while (first < last) {
			int s = array[first] + array[last];
			if (s == n) {
				System.out.println(array[first] + ", " + array[last]);
				first++;
				last--;
			} else if (s < n) {
					first++;
			} else {
				last--;
			}
		}
	}
}