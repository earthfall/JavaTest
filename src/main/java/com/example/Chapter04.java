package com.example;

import java.util.ArrayList;
import java.util.LinkedList;

import com.example.Chapter02.ListNode;

public class Chapter04 {

	public static class TreeNode {
		protected final int value;
		protected TreeNode left;
		protected TreeNode right;

		TreeNode(int val) {
			value = val;
		}
		
		TreeNode find(int val) {
			if (val == value) {
				return this;
			} else if (val < value) {
				return left.find(val);
			} else {
				return right.find(val);
			}
		}
		
		boolean insert(int val) {
			if (val == value) {
				return false;
			} else if (val < value) {
				if (left == null) {
					left = new TreeNode(val);
					return true;
				} else {
					return left.insert(val);
				}
			} else {
				if (right == null) {
					right = new TreeNode(val);
					return true;
				} else {
					return right.insert(val);
				}
			}
		}
		
		@Override
		public String toString() {
			return ((left == null) ? "" : left.toString()) + " " + value + ((right == null) ? "" : right.toString());
		}
	}
	
	// depth와 balance check가 별도로 되면 비효율적
	public static boolean checkBalance(TreeNode input) {
		if (getDepth(input) == -1) {
			return false;
		}
		
		return true;
	}
	
	private static int getDepth(TreeNode input) {
		if (input == null) {
			return 0;
		}
		
		int left = getDepth(input.left);
		if (left == -1) {
			return -1;
		}
		
		int right = getDepth(input.right);
		if (right == -1) {
			return -1;
		}
		
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		
		return Math.max(left, right) + 1;
	}

	// 종료 조건 주의
	// argument로 TreeNode를 전달 할 필요 없음
	public static TreeNode sortedArrayToTree(int[] input, int start, int end) {
		if (end < start) {
			return null;
		}
		
		int index = (end + start) / 2;
		int mid = input[index];
		
		TreeNode node = new TreeNode(mid);
		
		node.left = sortedArrayToTree(input, start, index - 1);
		node.right = sortedArrayToTree(input, index + 1, end);
		
		return node;
	}
	
	public static void treeToLinkedList(ArrayList<ListNode> arrays, TreeNode input, int depth) {

		if (input == null) {
			return;
		}
				
		if (arrays.size() <= depth) {
			ListNode node = new ListNode(input.value);
			arrays.add(node);
		} else {
			ListNode node = arrays.get(depth);
			node.append(input.value);
		}
		
		treeToLinkedList(arrays, input.left, depth + 1);
		treeToLinkedList(arrays, input.right, depth + 1);
	}
	
	// Min-Max를 주어야 할까?
	public static boolean checkBinarySearchTree(TreeNode input, Integer parent, boolean left) {
		if (input == null) {
			return true;
		}
		
		if (parent != null) {
			if (left) {
				if (input.value <= parent) {
					return false;
				}
			} else {
				if (input.value > parent) {
					return false;
				}
			}
		}
		
		return checkBinarySearchTree(input.left, input.value, true) && checkBinarySearchTree(input.right, input.value, false);
	}
	
	public static class TreeNode2 extends TreeNode {
		private final TreeNode2 parent;
		
		TreeNode2(int val) {
			super(val);
			this.parent = null;
		}
		
		TreeNode2(TreeNode2 parent, int val) {
			super(val);
			this.parent = parent;
		}
		
		boolean insert(int val) {
			if (val == value) {
				return false;
			} else if (val < value) {
				if (left == null) {
					left = new TreeNode2(this, val);
					return true;
				} else {
					return left.insert(val);
				}
			} else {
				if (right == null) {
					right = new TreeNode2(this, val);
					return true;
				} else {
					return right.insert(val);
				}
			}
		}
		
		TreeNode2 find(int val) {
			return (TreeNode2) super.find(val);
		}
		
		TreeNode2 getParent() {
			return parent;
		}
	}
	
	public static TreeNode2 findNext(TreeNode2 input) {
		// root node 인 경우 예외 처리 추가
		if (input == null) {
			return null;
		}
		
		// right 가 leaf가 아니라 node인 경우 처리 필요
		if (input.right != null) {
			return (TreeNode2) input.right;
		}
		
		TreeNode2 parent = input.getParent();	
		TreeNode2 current = input;
		while (parent != null && parent.left != current) {
			current = parent;
			parent = parent.getParent();
		}
		return parent;
	}
	
	// t1과 t2가 같은 방향이 아니면 root가 common ancestor
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2) {
		if (root == null) {
			return null;
		}
		
		// root가 공통 부모 인 경우
		if (t1 == root || t2 == root) {
			return root;
		}
		
		boolean isT1Left = isChild(root.left, t1);
		boolean isT2Left = isChild(root.left, t2);
		
		if (isT1Left != isT2Left) {
			return root;
		}
		
		return findCommonAncestor((isT1Left) ? root.left : root.right, t1, t2);
	}
	
	private static boolean isChild(TreeNode root, TreeNode n) {
		if (root == null) {
			return false;
		}
		
		if (root == n) {
			return true;
		}
		
		return isChild(root.left, n) || isChild(root.right, n);
	}
	
	public static boolean isSubTree(TreeNode t1, TreeNode t2) {
		// t1이 null인 경우 예외 처리
		if (t1 == null) {
			return false;
		}
		
		if (t1.value == t2.value) {
			if (traverseTree(t1, t2)) {
				return true;
			}
		}
		
		return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
	}
	
	private static boolean traverseTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		
		if (t1 == null || t2 == null) {
			return false;
		}
		
		if (t1.value != t2.value) {
			return false;
		}
		
		return traverseTree(t1.left, t2.left) && traverseTree(t1.right, t2.right);
	}
	
	public static LinkedList<Integer> findValue(TreeNode root, int n) {
		
		LinkedList<Integer> list = new LinkedList<>();
		getPathWithCost(list, root, n);
		return list;
	}
	
	private static void getPathWithCost(LinkedList<Integer> list, TreeNode root, int n) {
		if (root == null) {
			return;
		}
		
		list.add(root.value);
		
		int sum = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			sum += list.get(i);
			if (sum == n) {
				System.out.print("Path: ");
				for (int j = i; j < list.size(); j++) {
					System.out.print(list.get(j));
					System.out.print(' ');
				}
				System.out.println();
			}
		}
				
		getPathWithCost(list, root.left, n);
		getPathWithCost(list, root.right, n);
	}
}
