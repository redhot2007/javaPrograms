package com.java.test;

import org.junit.Before;
import org.junit.Test;

import com.data.structures.LRUCache;

public class LRUCacheTest {
	
	LRUCache obj = null;
	@Before
	public void init(){
		obj = 	new LRUCache(5);
	}
	
	@Test
	public void testCache() {
		int[] input = {9,12,11,13,14,12,15};
		for(int i: input)
			obj.set(""+i, i);
		System.out.println(obj.get(""+9));
		System.out.println(obj.get(""+11));
		obj.getCachedValues();
	}
	

}
