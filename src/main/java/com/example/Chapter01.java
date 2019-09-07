package com.example;

import java.util.BitSet;

public class Chapter01 {

	public static boolean checkUniqueString(String input) {
		// 길이 check를 통해서 length가 char 수보다 크면 false 반환
		
		// ASCII 또는 UNICODE 확인 필요
		int count[] = new int[256];
		char[] chars = input.toCharArray();
		
		// count와 조건 check를 합칠 수 있음
		// 소문자인 경우 bit padding으로 처리 가능
		for (char ch : chars) {
			count[ch - 'a']++;
		}
		
		for (int i : count) {
			if (i > 1) {
				return false;
			}
		}
		
		return true;
	}
	
	// 대소문재 처리 여부 확인
	// 공백이 있을 때 동일 여부 확인
	// 순열의 정의 확인 필요
	public static boolean checkPerm(String left, String right) {
		// 길이 check를 통해서 length가 다르면 false 반환
		
		String twice = left + left;
		return twice.contains(right);
	}
	
	public static void replaceEmptySpace(char[] input, int length) {
		int space = 0;
		for (int i = 0; i < length; i++) {
			if (input[i] == ' ') {
				space++;
			}
		}
		
		int size = length + space * 2 - 1;
		for (int i = length - 1; i > 0; i--) {
			if (input[i] == ' ') {
				input[size--] = '0';
				input[size--] = '2';
				input[size--] = '%';
			} else {
				input[size--] = input[i];
			}
		}	
	}
	
	// 길이를 미리 검사한다면 StringBuilder를 사용하지 않을 수 있다
	public static String encode(String input) {
		int len = input.length();
		
		StringBuilder builder = new StringBuilder(len / 2);
		char prv = input.charAt(0);
		int count = 1;
		for (int i = 1; i < len; i++) {
			char ch = input.charAt(i);
			if (ch == prv) {
				count++;
			} else {
				builder.append(prv).append(count);
				prv = ch;
				count = 1;
			}
		}
		builder.append(prv).append(count);
		
		String result = builder.toString();
		return (result.length() <= len) ? result : input;
	}
	
	public static void roate(int[][] input, int n) {
		
		for (int i = 0; i < n/2; i++) {
			int size = n - i - 1;
			for (int j = i; j < size; j++) {
				int offset = j - i;
				
				int tmp = input[i][j];
				// index 조건 주의
				// j index 이름을 start/last로 변경하는 것이 더 명확하다
				input[i][j] = input[size - offset][i];
				input[size - offset][i] = input[size][size - offset];
				input[size][size - offset] = input[j][size];
				input[j][size] = tmp;
			}
		}
	}
	
	public static void setZero(int[][] input) {
		int m = input.length;
		int n = input[0].length;
		
		BitSet rows = new BitSet(m);
		BitSet cols = new BitSet(n);
			
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] == 0) {
					rows.set(i);
					cols.set(j);
				}
			}
		}
		
		for (int i = rows.nextSetBit(0); i >= 0; i = rows.nextSetBit(i + 1)) {
			for (int j = 0; j < n; j++) {
				input[i][j] = 0;
			}
		}

		for (int j = cols.nextSetBit(0); j >= 0; j = cols.nextSetBit(j + 1)) {
			for (int i = 0; i < m; i++) {
				input[i][j] = 0;
			}
		}
				
		// 0의 개수가 드물다면 위의 방법이 유리, 0이 많으면 아래가 유리
		/*
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rows.get(i) || cols.get(j)) {
					input[i][j] = 0;
				}
			}
		}
		*/
	}
	
	// dummy function
	private static boolean isSubString(String s1, String s2) {
		return true;
	}
	
	public static boolean checkSubString(String left, String right) {
		// 길이 check를 통해서 length가 다르면 false 반환
		
		String twice = left + left;
		return isSubString(twice, right);
	}
}
