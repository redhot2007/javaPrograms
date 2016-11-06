package com.java.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.java.programs.BitManipulation;


public class BitManipulationTest {
	private BitManipulation obj= null;
	int a[];
	@Before
	public void initialize(){
		obj = new BitManipulation();
		a = new int[]{0,1,2,3,4,(~0)-1};
	}
	
	@Test
	public void testClearMsbToPosition(){
		for(int i:a){
		System.out.println("Input:"+Integer.toBinaryString(i));
		System.out.println("Output:"+
		Integer.toBinaryString(obj.clearMsbToPosition(i, 10)));
		
	}
	}
	
	@Test
	public void testCountSetBits(){
		String input[] =  {"1","10","100","001","101","111","1111","10110110111","1000000000001"};
		int[] expected_output = {1,1,1,1,2,3,4,8,2};
		for(int i =0; i<input.length;i++){
			 int cur = Integer.parseInt(input[i], 2);
			 assertEquals(expected_output[i],obj.countSetBits(cur));
		}
	}
	
	@Test
	public void testCountSetBitskernighansAlgorithm(){
		String input[] =  {"1","10","100","001","101","111","1111","10110110111","1000000000001"};
		int[] expected_output = {1,1,1,1,2,3,4,8,2};
		for(int i =0; i<input.length;i++){
			 int cur = Integer.parseInt(input[i], 2);
			 assertEquals(expected_output[i],obj.countSetBitskernighansAlgorithm(cur));
		}
	}
	@Test
	public void testMaxOfTwoNumbers(){
		int[] input1 = {1,Integer.MIN_VALUE,1,0,Integer.MAX_VALUE,1};
		int[] input2 = {1,-1,Integer.MIN_VALUE,Integer.MIN_VALUE,1,Integer.MAX_VALUE};
		int[] expected={1,-1,1,0,Integer.MAX_VALUE,Integer.MAX_VALUE};
		for(int i=0;i<input1.length;i++)
		assertEquals(expected[i],obj.maxOfTwoNumbers(input1[i],input2[i]));
	}
	@Test
	public void testgetDuplicate(){
		int[] input = {1,2,3,4,5,6,6,6,7};
		System.out.println(obj.getDuplicate(input));
	}
}
