package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.Chapter03.ArrayQueue;
import com.example.Chapter03.ArrayStack;
import com.example.Chapter03.MyQueue;

public class Chapter03Test {

	@Test
	public void testQueue() {
		ArrayQueue<Integer> q = new ArrayQueue<>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		assertEquals(true, q.isEmpty());
		
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		
		assertEquals(4, (int) q.dequeue());
		assertEquals(5, (int) q.dequeue());
		assertEquals(6, (int) q.dequeue());
		assertEquals(7, (int) q.dequeue());
		assertEquals(8, (int) q.dequeue());
	}

	@Test
	public void testSolveHanoi() {
		ArrayStack<Integer> s1 = new ArrayStack<>("Source");
		ArrayStack<Integer> s2 = new ArrayStack<>("Buffer");
		ArrayStack<Integer> s3 = new ArrayStack<>("Dest");
		
		s1.push(4);
		s1.push(3);
		s1.push(2);
		s1.push(1);
		
		System.out.println(s1.toString());
		
		Chapter03.solveHanoi(s1,  s2,  s3, 4);
		
		assertEquals(true, s1.isEmpty());
		assertEquals(true, s2.isEmpty());
		assertEquals(false, s3.isEmpty());
	}
	
	@Test
	public void testMyQueue() {
		MyQueue<Integer> q = new MyQueue<>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		assertEquals(true, q.isEmpty());
		
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		
		assertEquals(4, (int) q.dequeue());
		assertEquals(5, (int) q.dequeue());
		assertEquals(6, (int) q.dequeue());
		assertEquals(7, (int) q.dequeue());
		assertEquals(8, (int) q.dequeue());
	}
	
	@Test
	public void testSortStack() {
		ArrayStack<Integer> s1 = new ArrayStack<>();

		s1.push(0);
		s1.push(3);
		s1.push(4);
		s1.push(2);
		s1.push(1);
		
		ArrayStack<Integer> ret = Chapter03.sortStack(s1);
		
		assertEquals(4, (int) ret.pop());
		assertEquals(3, (int) ret.pop());
		assertEquals(2, (int) ret.pop());
		assertEquals(1, (int) ret.pop());
		assertEquals(0, (int) ret.pop());
	}
}
