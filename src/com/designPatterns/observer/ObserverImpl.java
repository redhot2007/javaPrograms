package com.designPatterns.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class ObserverImpl implements Observer {

	private boolean observable1Received;
	private boolean observable2Received;
	@Override
	public synchronized void update(Observable o, Object arg) {
		if( o instanceof Observable1){
			observable1Received = true;
		}
		if( o instanceof Observable2){
			observable2Received = true;
		}
		
		
			execute();
		
		

	}
	private void execute() {
		if( observable2Received && !observable1Received ){
			System.out.println("waiting for observable1 to complete its task");
		}
		if(observable1Received && !observable2Received){
			System.out.println("waiting for observable2 to complete its task");
		}
		
		if(observable1Received && observable2Received){
			System.out.println("Both observables completed");
		}
		
	}

	public static void main(String args[]){
		Observable1 observable = new Observable1();
		Observable2 observable2 = new Observable2();
		ObserverImpl observer = new ObserverImpl();
		observable.addObserver(observer);
		observable2.addObserver(observer);
		Random random = new Random();
			observable.setSleep(Math.abs(random.nextInt(1)));
			observable2.setSleep(Math.abs(random.nextInt(1)));
		new Thread(observable).start();;
		new Thread(observable2).start();;
		
	}
}
