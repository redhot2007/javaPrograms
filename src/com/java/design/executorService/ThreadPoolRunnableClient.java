package com.java.design.executorService;

public class ThreadPoolRunnableClient implements Runnable {

	private String name;

	public ThreadPoolRunnableClient(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name+" is running");
		
	}

}
