package com.designPatterns.singleton;

public class ThreadUnsafeSingleton {
	private static ThreadUnsafeSingleton instance = null;
	private ThreadUnsafeSingleton() {
	      // Exists only to defeat instantiation.
	   }
	   public static ThreadUnsafeSingleton getInstance() {
	      if(instance == null) {
	         instance = new ThreadUnsafeSingleton();
	      }
	      return instance;
	   }
}
