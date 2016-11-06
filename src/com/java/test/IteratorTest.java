package com.java.test;

import org.junit.Test;

import com.dataStructures.Iterator;

public class IteratorTest{
	@Test
	public void testIterator(){
		int a[] = {1,2,3,4,5};
		Iterator i = new Iterator(a);
		while(i.hasNext())
			System.out.println(i.next());
	}
}
