package com.java.design.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
	private Queue<Integer> queue = new LinkedList<Integer>();
	private int contents;
	private boolean available = false;

	public synchronized int get() {
		// return queueGet();
		return contentGet();
	}

	public synchronized void put(int value) {
		// queuePut(value);
		contentsPut(value);
	}

	private int contentGet() {
		while (!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		available = false;
		notifyAll();
		System.out.println("Consumer  #" + " get: " + contents);
		return contents;
	}

	private void contentsPut(int val) {
		while (available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = true;
		notifyAll();
		contents = val;
		System.out.println("Producer #" + " put: " + contents);
		return;
	}

	private int queueGet() {
		while (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		// available = false;
		notifyAll();
		System.out.println("Consumer  #" + " get: " + queue.peek());
		return queue.remove();
	}

	private void queuePut(int value) {
		while (queue.size() > 5) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Producer #" + " put: " + value);
		queue.add(value);
		// available = true;
		notifyAll();
	}
}