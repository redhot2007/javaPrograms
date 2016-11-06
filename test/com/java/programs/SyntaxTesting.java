package com.java.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.junit.Test;

public class SyntaxTesting {

	@Test
	public void finalFunctionality() {
		// Marking ArrayList as final and adding element later. throws error?
		// No
		final ArrayList<Integer> test = new ArrayList<Integer>();
		// uncomment following to see error from compiler
		// test = new ArrayList<Integer>();
		test.add(1);
		System.out.println(test.get(0));

	}

	/**
	 * An entry in a WeakHashMap will automatically be removed when its key is
	 * no longer in ordinary use. More precisely, the presence of a mapping for
	 * a given key will not prevent the key from being discarded by the garbage
	 * collector, that is, made finalizable, finalized, and then reclaimed. When
	 * a key has been discarded its entry is effectively removed from the map,
	 * so this class behaves somewhat differently from other Map
	 * implementations.
	 */
	@Test
	public void weakHashMap() {
		// uncomment following line to see the difference
		Map<HashEntry, String> map = new WeakHashMap<HashEntry, String>();
		// Map<HashEntry, String> map = new HashMap<HashEntry, String>();
		HashEntry location = new HashEntry("Chennai", "India");
		map.put(location, location.country);
		location = null;
		System.gc();
		System.out.println(map.toString());
	}

	class HashEntry {
		String name;
		String country;

		HashEntry(String name, String country) {
			this.name = name;
			this.country = country;
		}
	}
}
