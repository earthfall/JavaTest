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
			// 길이 조건 추가
			
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
				
		// 가장 가까운 큰 수
		// 1. 첫 0의 그룹이 아닌 다음 가까운 0을 찾아서 1로 변경
		// 2. 그 사이의 1의 개수를 전부 오른 쪽 끝으로 이동
		
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
		// 가장 가까운 작은 수
		// 1. 첫 1의 그룹이 아닌 다음 가까운 1을 찾아서 0으로 변경
		// 2. 그 사이의 0의 개수를 전부 왼쪽으로 이동
		
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
	
	// code quality 개선
	public static int computeBitDiff(int a, int b) {
		int count = 0;
		/*
		int tmp = a ^ b;
		// 무조건 32번의 연산 필요
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
		// 시작과 끝 byte 획득
		// 완전한 byte는 한꺼번에 1로 설정
		// 남는 byte를 위한 mask 준비
		
		for (int x = x1; x <= x2; x++) {
			screen[x + width / 8 * y] = 1;
		}
	}
}
