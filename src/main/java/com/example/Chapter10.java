package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Chapter10 {

	public static void sortBySelection(int[] arr, int index) {
		for (int i = 0; i < index - 1; i++) {
			int min = i;
			for (int j = i + 1; j < index; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[(low + high) / 2];
		
		while (low <=  high) {
			while (arr[low] < pivot)
				low++;
			
			while (arr[high] > pivot)
				high--;
			
			if (low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		return low;
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		
		int pivot = partition(arr, low, high);
		quickSort(arr, low, pivot - 1);
		quickSort(arr, pivot, high);
	}
	
	public static void mergeSortedArray(int[] A, int[] B) {
		int lengthA = A.length -1;
		while (A[lengthA] == 0) {
			lengthA--;
		}

		int lengthB = B.length - 1;

		for (int i = lengthA + lengthB + 1; i >= 0; i--) {

			if (lengthA >= 0 && A[lengthA] > B[lengthB]) {
				A[i] = A[lengthA];
				lengthA--;
			} else {
				A[i] = B[lengthB];
				if (lengthB == 0) {
					break;
				}
				
				lengthB--;
			}
		}
	}
	
	public static void anagramSort(String[] test) {
		Arrays.sort(test, new AnagramComparator());
	}
	
	private static class AnagramComparator implements Comparator<String> {

		private static HashMap<String, String> cache = new HashMap<>();
		
		@Override
		public int compare(String o1, String o2) {		
			return toSortedString(o1).compareTo(toSortedString(o2));
		}
		
		private static String toSortedString(String o1) {
			String result = cache.get(o1);
			if (result != null) {
				return result;
			}
			
			int[] arr = new int[256];
			for (int i = 0; i < o1.length(); i++) {
				arr[(int) o1.charAt(i)]++;
			}
			
			char[] ret = new char[o1.length()];
			for (int i = 0, index = 0; i < 256; i++) {
				while (arr[i] != 0) {
					ret[index++] = (char) i;
					arr[i]--;
				}
			}
			
			result = new String(ret);
			cache.put(o1, result);
			return result;
		}
		
		private static boolean isAnagram(String o1, String o2) {
			if (o1.length() != o2.length()) {
				return false;
			}
			
			int[] arr1 = new int[256];
			int[] arr2 = new int[256];

			for (int i = 0; i < o1.length(); i++) {
				arr1[(int) o1.charAt(0)]++;
			}
			
			for (int i = 0; i < o2.length(); i++) {
				arr2[(int) o2.charAt(0)]++;
			}
			
			for (int i = 0; i < 256; i++) {
				if (arr1[i] != arr2[i]) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	public static int findElement(int[] input, int value) {
		int min = 0;
		for (int i = 1; i < input.length; i++) {
			if (input[i] < input[min]) {
				min = i;
			}
		}

		int start;
		int end;
		if (input[0] <= value) {
			start = 0;
			end = min - 1;
		} else if (input[input.length - 1] >= value) {
			start = min;
			end = input.length - 1; 
		} else {
			return -1;
		}
		
		while (start < end) {
			int mid = (start + end) / 2;
			int tmp = input[mid];
			if (tmp > value) {
				end = mid - 1;
			} else if (tmp < value) {
				start = mid;
			} else {
				return mid;
			}
		}

		
		return -1;
	}
	
	// 찾는 문자열이 빈 문자열인 경우 문제 정의
	public static int findWordPos(String[] list, String value) {
		int start = 0;
		int end = list.length - 1;
		
		while (start < end) {
			int mid = (start + end) / 2;
			String tmp = list[mid];
			while(tmp.isEmpty()) {
				tmp = list[++mid];
			}

			int comp = tmp.compareTo(value);
			if (comp > 0) {
				end = mid - 1;
			} else if (comp < 0) {
				start = mid;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
	
	// 이진 탐색이 효율적. 4분할 해서 확인 가능
	public static void findElementFromMatrix(int[][] array, int val) {
		int row = 0;
		int col = array[0].length - 1;
		while (row < array.length && col >= 0) {
			if (array[row][col] == val) {
				System.out.println("(" + row + ", " + col + ")");
				return;
			} else if (array[row][col] > val) {
				col--;
			} else {
				row++;
			}
		}
		
		System.out.println("Not found");
	}
	
	/*
	private static final int COUNT = 65535;

	private final int mArray[] = new int[COUNT];

	public void tracks(int[] stream) {
		for (int index : stream)
			mArray[index]++;
	}

	public int getRankOfNumber(int x) {
		int count = 0;
		for (int i = 0; i < x; i++) {
			count += mArray[i];
		}

		return count;
	}
	*/
	
	private static TreeItem root;

	public static void tracks(int[] stream) {
		root = new TreeItem(stream[0]);

		for (int i = 1; i < stream.length; i++)
			root.insert(stream[i]);
	}

	public static int getRankOfNumber(int x) {
		return root.getRank(x);
	}

	public static class TreeItem {
		private int value;
		private int left_count;
		private TreeItem left;
		private TreeItem right;

		TreeItem(int val) {
			value = val;
		}

		void insert(int x) {
			if (x <= value) {
				if (left == null)
					left = new TreeItem(x);
				else
					left.insert(x);

				left_count++;
			} else {
				if (right == null)
					right = new TreeItem(x);
				else
					right.insert(x);
			}
		}

		int getRank(int x) {
			if (value == x) {
				return left_count;
			} else if (x < value) {
				if (left == null)
					return -1;
				else
					return left.getRank(x);
			} else {
				if (right == null)
					return -1;
				else
					return left_count + 1 + right.getRank(x);
			}
		}
	}
}
