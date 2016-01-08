package com.example;

public class Chapter01 {

	public static boolean checkUniqueString(String input) {
		// ���� check�� ���ؼ� length�� char ������ ũ�� false ��ȯ
		
		// ASCII �Ǵ� UNICODE Ȯ�� �ʿ�
		int count[] = new int[256];
		char[] chars = input.toCharArray();
		
		// count�� ���� check�� ��ĥ �� ����
		// �ҹ����� ��� bit padding���� ó�� ����
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
	
	// ��ҹ��� ó�� ���� Ȯ��
	// ������ ���� �� ���� ���� Ȯ��
	// ������ ���� Ȯ�� �ʿ�
	public static boolean checkPerm(String left, String right) {
		// ���� check�� ���ؼ� length�� �ٸ��� false ��ȯ
		
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
	
	// ���̸� �̸� �˻��Ѵٸ� StringBuilder�� ������� ���� �� �ִ�
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
		//
	}
}
