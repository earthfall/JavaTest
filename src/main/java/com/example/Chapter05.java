package com.example;

public class Chapter05 {

	public static int insertNumber(int N, int M, int i, int j) {
		int ret = N;
		
		int mask = (~0 << (j + 1)) | (1 << i - 1);
		N = N & mask;
		
		int val = M << i;
		
		return ret | val;
	}
	
	public static String printDouble(double d) {
		if (d >= 1 || d <= 0) {
			return "ERROR";
		}
		
		StringBuilder builder = new StringBuilder(32);
		builder.append("0.");
		double val = 0.5;
		while (d > 0) {
			// ���� ���� �߰�
			
			if (d >= val) {
				builder.append('1');
				d -= val;
			} else {
				builder.append('0');
			}
			
			val /= 2;
		}
		
		return builder.toString();
	}
		
	public static int findNearestNext(int x) {
				
		// ���� ����� ū ��
		// 1. ù 0�� �׷��� �ƴ� ���� ����� 0�� ã�Ƽ� 1�� ����
		// 2. �� ������ 1�� ������ ���� ���� �� ������ �̵�
		
		int lastOneIndex = nextSetBit(x, 0);
		int zeroIndex = nextClearBit(x, lastOneIndex);
		if (lastOneIndex == -1 || zeroIndex == -1) {
			return -1;
		}
		
		int oneCount = zeroIndex - lastOneIndex;
		int ret = x | (1 << zeroIndex);
		
		ret &= ~((1 << zeroIndex) - 1); 
		ret |= (1 << (oneCount - 1)) - 1;
				
		return ret;
	}
	
	public static int findNearestPrev(int x) {
		// ���� ����� ���� ��
		// 1. ù 1�� �׷��� �ƴ� ���� ����� 1�� ã�Ƽ� 0���� ����
		// 2. �� ������ 0�� ������ ���� �������� �̵�
		
		int lastZeroIndex = nextClearBit(x, 0);
		int oneIndex = nextSetBit(x, lastZeroIndex);
		if (lastZeroIndex == -1 || oneIndex == -1) {
			return -1;
		}
		
		int zeroCount = oneIndex - lastZeroIndex;
		int ret = x & ((~0) << (oneIndex + 1));
		
		int mask = ((1 << (lastZeroIndex + 1)) - 1) << (zeroCount - 1);
		return ret | mask;
	}
	
	public static int nextSetBit(int x, int index) {
		for (int i = index; i < 32; i++) {
			if ((x & (1 << i)) != 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int nextClearBit(int x, int index) {
		for (int i = index; i < 32; i++) {
			if ((x & (1 << i)) == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int prevSetBit(int x, int index) {
		for (int i = index; i >= 0; i--) {
			if ((x & (1 << i)) != 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static boolean hasAllOne(int x) {
		return ((x+1) & x) == 0;
	}
	
	// code quality ����
	public static int computeBitDiff(int a, int b) {
		int count = 0;
		/*
		int tmp = a ^ b;
		// ������ 32���� ���� �ʿ�
		for (int i = 0; i < 32; i++) {
			if ((tmp & (1 << i)) != 0) {
				count++;
			}
		}
		return count;
		*/
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += (c & 1);
		}
		
		return count;
	}
	
	public static int swapEvenAndOdd(int val) {
		int odd = 0x55555555 & val;
		int even = 0xaaaaaaaa & val; 
		return (odd >> 1 | even << 1);
	}
	
	private static int getBit(int[] input, int i, int j) {
		return input[i] & (1 << j);
	}
	
	public static int findMissingInt(int[] input, int n) {
		int prev = 0;
		for (int i = 1; i < n; i++) {
			if (prev == getBit(input, i, 0)) {
				return i;
			}
			
			prev = (~prev & 1);
		}
		return 0;
	}
	
	// FIXME
	public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
		// ���۰� �� byte ȹ��
		// ������ byte�� �Ѳ����� 1�� ����
		// ���� byte�� ���� mask �غ�
		
		for (int x = x1; x <= x2; x++) {
			screen[x + width / 8 * y] = 1;
		}
	}
}
