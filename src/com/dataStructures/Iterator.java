package com.dataStructures;

public class Iterator implements java.util.Iterator<Integer>{

	private int[] array;
	private int currentIndex = 0;

	public Iterator(int a[]){
		this.array = a;
	}
	
	@Override
	public boolean hasNext() {	
		return currentIndex<array.length;
	}

	@Override
	public Integer next() {
		return array[currentIndex++];
	}

}

