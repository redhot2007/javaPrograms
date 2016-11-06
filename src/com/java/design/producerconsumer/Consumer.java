package com.java.design.producerconsumer;

public class Consumer extends Thread {
	private MessageQueue cubbyhole;
	private int number;

	public Consumer(MessageQueue c, int number) {
		cubbyhole = c;
		this.number = number;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = cubbyhole.get();
			// System.out.println("Consumer #" + this.number + " got: " +
			// value);
		}
	}
}
