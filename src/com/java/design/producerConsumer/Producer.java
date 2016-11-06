package com.java.design.producerConsumer;

public class Producer extends Thread {
	private MessageQueue messageQueue;
	private int number;

	public Producer(MessageQueue c, int number) {
		messageQueue = c;
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			messageQueue.put(i);
			
//			try {
//				sleep((int) (Math.random() * 100));
//			} catch (InterruptedException e) {
//			}
		}
	}
}