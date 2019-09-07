package com.example;

import java.util.Stack;

public class Chapter02 {

	public static class ListNode {
		ListNode next;
		int data;
		
		ListNode(int d) {
			data = d;
		}
		
		void append(int d) {
			ListNode n = this;
			while (n.next != null) {
				n = n.next;
			}
			
			n.next = new ListNode(d);
		}
		
		ListNode findNode(int d) {
			ListNode n = this;
			while (n.next != null) {
				if (n.data == d) {
					return n;
				}
				
				n = n.next;
			}
			
			return null;
		}
		
		@Override
		public String toString() {
			ListNode n = this;
			StringBuilder builder = new StringBuilder();
			builder.append(String.valueOf(n.data));
			
			while (n.next != null) {
				n = n.next;
				builder.append(String.valueOf(n.data));
			}
			
			return builder.toString();
		}
		
		void print() {
			System.out.println(toString());
		}
	}
	
	// runner 사용
	public static int findLastKth(ListNode head, int k) {
		
		/*
		ListNode n = head;
		int count = 1;
		while (n.next != null) {
			n = n.next;
			count++;
		}
		
		n = head;
		int i = 1;
		while (n.next != null) {
			n = n.next;
			if (i++ == count - k) {
				break;
			}
		}
		
		return n.data;
		*/
		
		ListNode p1 = head;
		ListNode p2 = head;
		
		// 오류 검사 필요
		for (int i = 0; i < k - 1; i++) {
			p2 = p2.next;
		}
		
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1.data;
	}
	
	// 다음 node 지우기
	// 마지막 node 처리 불가
	public static void deleteWithoutHead(ListNode node) {
		ListNode next = node.next;
		
		node.data = next.data;
		node.next = next.next;
	}
	
	// 변수 개수 줄이기
	public static ListNode orgnazeWithValue(ListNode head, int x) {
		
		ListNode n = head;
		ListNode before = null;
		ListNode beforeLast = null;
		ListNode after = null;
		ListNode afterLast = null;
		while (n.next != null) {
			ListNode next = n.next;
			
			if (n.data < x) {
				if (before == null) {
					before = n;
					beforeLast = n;
				} else {
					beforeLast.next = n;
					beforeLast = n;
				}
			} else {
				if (after == null) {
					after = n;
					afterLast = n;
				} else {
					afterLast.next = n;
					afterLast = n;
				}
			}
			
			n = next;
		}
		
		if (before == null) {
			return after;
		}
		
		beforeLast.next = after;
		return before;
	}
	
	// 재귀적인 문제 풀이 가능
	public static ListNode addList(ListNode left, ListNode right) {
		if (left == null) {
			return left;
		}
		
		if (right == null) {
			return right;
		}
		
		int val = left.data + right.data;
		int leftOver = val / 10;
		val = val % 10;
		ListNode sum = new ListNode(val);
		ListNode next = sum;

		while(left.next != null) {
			left = left.next;
			right = right.next;
			if (right == null) {
				break;
			}
			
			val = left.data + right.data + leftOver;
			leftOver = val / 10;
			val = val % 10;
			next.next = new ListNode(val);
			next = next.next;
		}
		
		if (right.next != null) {
			sum.next = left;
		}
		
		return sum;
	}
	
	public static ListNode addList2(ListNode left, ListNode right, int carry) {
		
		if (left == null && right == null && carry == 0) {
			return null;
		}
			
		int val = ((left == null) ? 0 : left.data) + ((right == null) ? 0 : right.data) + carry;
		carry = val / 10;
		val = val % 10;
		
		ListNode result = addList2((left == null) ? null : left.next, (right == null) ? null : right.next, carry);
		
		ListNode node = new ListNode(val);
		node.next = result;
		return node;
	}
	
	// 문제에서 충돌이 없는 지 여부 확인 필요
	public static ListNode getCycleNode(ListNode head) {
		ListNode node = head;
		ListNode runner = head;
		while (runner.next != null) {
			node = node.next;
			runner = runner.next.next;
			if (node == runner) {
				break;
			}
		}
		
		node = head;
		while (node != runner) {
			node = node.next;
			runner = runner.next;
		}
		
		return runner;
	}
	
	// recursive 해법
	public static boolean isPalindrome(ListNode head) {
		ListNode node = head;
		ListNode runner = head;
		int count = 1;
		Stack<Integer> stack = new Stack<>();
		
		while(runner != null && runner.next != null) {
			stack.push(node.data);
			node = node.next;
			runner = runner.next.next;
			count++;
		}
		
		// count 변수 불필요
		if (count %2 != 0) {
			node = node.next;
		}
		
		while (node != null) {
			if (!stack.pop().equals(node.data)) {
				return false;
			}
			node = node.next;
		}
				
		return true;
	}
}
