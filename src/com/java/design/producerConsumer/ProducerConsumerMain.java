package com.java.design.producerConsumer;

import org.junit.Test;

public class ProducerConsumerMain {
	@Test
	public void testProducerConsumer() {
		MessageQueue c = new MessageQueue();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 1);
		p1.start();
		c1.start();
	}
  public static void main(String[] args) {
	      MessageQueue c = new MessageQueue();
	      Producer p1 = new Producer(c, 1);
	      Consumer c1 = new Consumer(c, 1);
	      p1.start(); 
	      c1.start();
	   }
}
	 
	