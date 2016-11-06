package com.java.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.programs.Sorts;

public class SortsTest {
	private List<int[]> input = new ArrayList<int[]>();
	private List<int[]> expected = null;

	@Before
	public void init() {		
		for (int i = 1; i < 100; i++) {
			input.add(Sorts.randomNumberedArrayGenerator(i, Integer.MAX_VALUE));
			expected = new ArrayList<int[]>(input);
		}
	}

	@Test
	public void testHeapSort() {	
		for (int i = 0; i < input.size(); i++) {
			int[] currentInput = input.get(i);
			int[] curretnExpected = expected.get(i);
			Arrays.sort(curretnExpected);
			Sorts.heapSort(currentInput);
			assertArrayEquals(curretnExpected, input.get(i));
		}
	}
	
	@Test
	public void testMergeSort() {	
		for (int i = 0; i < input.size(); i++) {
			int[] currentInput = input.get(i);
			int[] curretnExpected = expected.get(i);
			Arrays.sort(curretnExpected);
			Sorts.mergeSort(currentInput);
			assertArrayEquals(curretnExpected, input.get(i));
		}
	}
	@Test
	public void testQuickSort() {	
		for (int i = 0; i < input.size(); i++) {
			int[] currentInput = input.get(i);
			int[] curretnExpected = expected.get(i);
			Arrays.sort(curretnExpected);
			Sorts.quickSort(currentInput);
			assertArrayEquals(curretnExpected, input.get(i));
		}
	}
}
