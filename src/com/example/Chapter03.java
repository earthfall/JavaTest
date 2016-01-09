package com.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Chapter03 {

	public static class ArrayStack<E> {
		
		private final Object[] element = new Object[100];
		int count;
		private final String name;
		
		ArrayStack() {
			this.name = "";
		}
		
		ArrayStack(String name) {
			this.name = name;
		}
		
		@SuppressWarnings("unchecked")
		private E element(int i) {
			return (E) element[i];
		}
		
		void push(E item) {
			if (count == element.length) {
				throw new ArrayIndexOutOfBoundsException();
			}

			element[count] = item;
			count++;
		}
		
		E pop() {
			if (count == 0) {
				return null;
			}
			
			E elem = element(--count);
			element[count] = null;
			return elem;
		}
		
		E peek() {
			return element(count -1);
		}
		
		boolean isEmpty() {
			return count == 0;
		}
		
		boolean isFull() {
			return count == element.length;
		}
		
		int getCount() {
			return count;
		}
		
		@Override
		public String toString() {
			if (count == 0) {
				return name.isEmpty() ? "empty" : name + ": empty";
			}
			
			StringBuilder builder = new StringBuilder();
			if (!name.isEmpty()) {
				builder.append(name).append(':');
			}
			
			for (int i = count - 1; i >= 0; i--) {
				builder.append(String.valueOf(element(i)));
			}
			return builder.toString();
		}
	}
	
	public static class ArrayQueue<E> {
		
		Object[] element = new Object[5];
		int start;
		int last;
		int count;
		
		@SuppressWarnings("unchecked")
		private E element(int i) {
			return (E) element[i];
		}
		
		private void confirmSpace() {
			if (count != 0 && start == last) {
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		
		void enqueue(E item) {
			confirmSpace();
			
			element[last++] = item;
			count++;
			if (last == element.length) {
				last = 0;
			}
		}
		
		E dequeue() {
			if (count == 0) {
				return null;
			}
			
			E ret = element(start++);
			count--;
			if (start == element.length) {
				start = 0;
			}
			return ret;
		}
		
		boolean isEmpty() {
			return count == 0;
		}
	}
	
	public static class SetOfStacks<E> {
		private final ArrayList<ArrayStack<E>> list = new ArrayList<>();
		private final int size;
		
		SetOfStacks(int size) {
			this.size = size;
		}
		
		void push(E item) {
			// last stack이 null인 경우 check
			ArrayStack<E> stack = list.get(list.size() - 1);
			if (stack == null || stack.getCount() == size) {
				stack = new ArrayStack<>();
				list.add(stack);
			}
			
			stack.push(item);
		}
		
		E pop() {
			ArrayStack<E> stack = list.get(list.size() - 1);
			E item = stack.pop();
			if (stack.isEmpty()) {
				list.remove(list.size() - 1);
			}
			return item;
		}
		
		boolean isEmpty() {
			ArrayStack<E> stack = list.get(list.size() - 1);
			return stack == null || stack.isEmpty();
		}
	}
	
	// recursion으로 Hanoi 문제를 생각 할 수 있을까...
	public static void solveHanoi(ArrayStack<Integer> org, ArrayStack<Integer> buffer, ArrayStack<Integer> dest, int n) {
		if (n == 0) {
			return;
		}
		
		solveHanoi(org, dest, buffer, n - 1);
		
		Integer val = org.pop();
		dest.push(val);
		System.out.println(org.toString() + ", " + dest.toString() + ", " + buffer.toString());
		
		solveHanoi(buffer, org, dest, n - 1);
	}
	
	// old stack 전환 여부를 위해 flag를 두지 말고 !oldStack.isEmpty()로 충분
	public static class MyQueue<E> {
		private final ArrayStack<E> newStack = new ArrayStack<>();
		private final ArrayStack<E> oldStack = new ArrayStack<>();
		
		void enqueue(E item) {
			newStack.push(item);
		}
		
		E dequeue() {
			if (oldStack.isEmpty()) {
				while (!newStack.isEmpty()) {
					oldStack.push(newStack.pop());
				}
			}

			return oldStack.pop();
		}
		
		boolean isEmpty() {
			return newStack.isEmpty() && oldStack.isEmpty();
		}
	}
	
	// 입력에 대해서 모든 member에 대해서 DFS 탐색 처리
	public static ArrayStack<Integer> sortStack(ArrayStack<Integer> input) {
		ArrayStack<Integer> result = new ArrayStack<>();
		while (!input.isEmpty()) {
			Integer tmp = input.pop();
			while (!result.isEmpty() && result.peek() > tmp) {
				input.push(result.pop());
			}

			result.push(tmp);
		}
		
		return result;
	}
	
	// single queue 보다 2개의 queue가 구현 용이
	public static class AnimalShelter {
		
		private final LinkedList<Dog> dogs = new LinkedList<>();
		private final LinkedList<Cat> cats = new LinkedList<>();
		private int timeStamp = 0;
		
		public void enqueue(Animal animal) {
			
			animal.setTime(++timeStamp);
			if (animal instanceof Dog) {
				dogs.add((Dog) animal);
			} else {
				cats.add((Cat) animal);
			}
		}
		
		public Animal dequeueAny() {
			Dog dog = dogs.peekFirst();
			if (dog == null) {
				return cats.poll();
			}
			
			Cat cat = cats.peekFirst();
			if (cat == null) {
				return dogs.poll();
			}
			if (dog.isOlder(cat)) {
				return dogs.poll();
			} else {
				return cats.poll();
			}
		}
		
		public Dog dequeueDog() {
			return dogs.poll();
		}
		
		public Cat dequeueCat() {
			return cats.poll();
		}
	}
	
	public static abstract class Animal {
		private int time;
				
		public void setTime(int time) {
			this.time = time;
		}
		
		public boolean isOlder(Animal other) {
			return time < other.time;
		}
	}
	
	public static class Dog extends Animal {

	}
	
	public static class Cat extends Animal {

	}
}
