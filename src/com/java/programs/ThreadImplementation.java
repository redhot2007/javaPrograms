package com.java.programs;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.java.models.ThreadExample;

public class ThreadImplementation {

	public static void arrayListWithoutSynchronized() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		deployThreads(al);

	}

	public static void vectorWithoutSynchronized() {
		Vector<Integer> al = new Vector<Integer>();
		deployThreads(al);

	}

	public static void arrayListWithSynchronized() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		ThreadExample.setSync("Synchronize");	
		deployThreads(al);

	}

	public static void arrayListWithReentrantLock() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		deployThreads(al,new ReentrantLock());

	}
	
	public static void deployThreads(List<Integer> al) {
		ThreadExample t1 = new ThreadExample(al);
		ThreadExample t2 = new ThreadExample();
		ThreadExample t3 = new ThreadExample();
		t1.start(); 
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("After join: " + al.size());
	}
	
	public static void deployThreads(List<Integer> al,Lock lock) {
		ThreadExample t1 = new ThreadExample(al,lock);
		ThreadExample t2 = new ThreadExample();
		ThreadExample t3 = new ThreadExample();
		t1.start(); 
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("After join: " + al.size());
	}

	public static void printAB(){
		Thread t1 =new Thread(){
			public void run(){
				printABHelper('A');
			}
		};
		t1.start();
		Thread t2 =new Thread(){
			public void run(){
				printABHelper('B');
			}
		};
		t2.start();
	}
	
	private static Integer synchronizer=0;
	
	private  static void printABHelper(char alpha){
		int i=0;
		while(i<2){
			synchronized(synchronizer){
				if((synchronizer == 0 && alpha =='A')||(synchronizer == 1 && alpha =='B')){
					System.out.println(alpha);
					synchronizer^=1;
					i++;
				} 
			}
			
		}
			
	}

}


class ProducerConsumerSolution {
	public static void deployProducerComsumerThreads(){
        Vector<Integer> sharedQueue = new Vector<Integer>();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
        prodThread.start();
        consThread.start();
	}
}

class Producer implements Runnable{
    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Producer(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }
	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
            System.out.println("Produced: " + i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
		
	}
    private void produce(int i) throws InterruptedException {

        //wait if queue is full
        while (sharedQueue.size() == SIZE) {
            synchronized (sharedQueue) {
                System.out.println("Queue is full " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //producing element and notify consumers
        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
	
}
class Consumer implements Runnable {

    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Consumer(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            	ex.printStackTrace();
            }

        }
    }

    private int consume() throws InterruptedException {
        //wait if queue is empty
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return sharedQueue.remove(0);
        }
    }
}