package com.java.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.programs.Puzzles;
import com.java.programs.StringsAndArrays;

public class StringsAndArraysTest {

	String valueWithMoreThan256Characters = "abcdefghijklmnopqrstuvwxyzaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	String expectedOutputsForMoreThan256Characters = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaazyxwvutsrqponmlkjihgfedcba";
	String[] testString_inputs = { "", " ", "a", "ab", "aabbccc", "aa bb c",
			"!@#$%^&*()\n", null, "123abc", "指事字",
			valueWithMoreThan256Characters, "_/\\_ sapidalam vanga",
			"This is a bloody sentence", " fuck off! ", "Duh 指" };
	String[] testStringRevarsal_expectedOutputs = { "", " ", "a", "ba",
			"cccbbaa", "c bb aa", "\n)(*&^%$#@!", null, "cba321", "字事指",
			expectedOutputsForMoreThan256Characters, "agnav maladipas _\\/_",
			"ecnetnes ydoolb a si sihT", " !ffo kcuf ", "指 huD" };
	StringsAndArrays obj = null;
	@Before 
	public void initialize(){
		
		 obj = StringsAndArrays.getInstance();
	}
	@Test
	public void testStringRevarsal_iterative() {
		StringsAndArrays obj = StringsAndArrays.getInstance();
		for (int i = 0; i < testString_inputs.length; i++) {
			String output = obj.stringRevarsal_iterative(testString_inputs[i]);
			assertEquals(testStringRevarsal_expectedOutputs[i] + " " + output,
					testStringRevarsal_expectedOutputs[i], output);
		}
	}

	@Test
	public void testStringRevarsal_recursive() {
		StringsAndArrays obj = StringsAndArrays.getInstance();
		for (int i = 0; i < testString_inputs.length; i++)
			assertEquals(testStringRevarsal_expectedOutputs[i],
					obj.stringRevarsal_recursive(testString_inputs[i]));
	}

	@Test
	public void testLengthOfLastWord() {
		StringsAndArrays obj = StringsAndArrays.getInstance();
		int[] expected_output = { 0, 0, 1, 2, 7, 1, 11, 0, 6, 3,
				expectedOutputsForMoreThan256Characters.length(), 5, 8, 4, 1 };
		for (int i = 0; i < testString_inputs.length; i++) {
			System.out.println(testString_inputs[i]);
			assertEquals(expected_output[i],
					obj.lengthOfLastWord((testString_inputs[i])));
		}

	}

	@Test
	public void testIsAnagram() {
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input1[] = { "", null, null, " ", "abc", " abc", " abc " };
		String input2[] = { "", null, "", " ", "cab", "abc ", " !ac " };
		boolean expected_output[] = { true, true, false, true, true, true,
				false };
		for (int i = 0; i < input1.length; i++) {
			assertEquals(expected_output[i],
					obj.isAnagram(input1[i], input2[i]));
		}
	}
	@Test
	public void testIsAnagram2() {
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input1[] = { "", null, null, " ", "abc", " abc", " abc " };
		String input2[] = { "", null, "", " ", "cab", "abc ", " !ac " };
		boolean expected_output[] = { true, true, false, true, true, true,
				false };
		for (int i = 0; i < input1.length; i++) {
			System.out.println("case: "+i);
			assertEquals(expected_output[i],
					obj.isAnagram2(input1[i], input2[i]));
		}
	}

	@Test
	public void testReverseOrderOfWordsInSentence_inPlace() {
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input[] = { "", " ", null, "Hey there!", " Hello There ",
				"Hello there ", " Hello there" };
		String expected_output[] = { "", " ", null, "there! Hey",
				" There Hello ", " there Hello", "there Hello " };
		for (int i = 0; i < input.length; i++) {
			assertEquals(expected_output[i], obj.reverseOrderOfWordsInSentence_inPlace(input[i]));
		}
	}

//	@Test
//	public void testReverseOrderOfWordsInSentence_javaStyle() {
//		StringsAndArrays obj = StringsAndArrays.getInstance();
//		String input[] = { "", " ", null, "Hey there!", " Hello There ",
//				"Hello there ", " Hello there" };
//		String expected_output[] = { "", " ", null, "there! Hey",
//				" There Hello ", " there Hello", "there Hello " };
//		for (int i = 0; i < input.length; i++) {
//			assertEquals(expected_output[i],
//					obj.reverseOrderOfWordsInSentence_javaStyle(input[i]));
//		}
//	}

	@Test
	public void testRemoveConsecutiveDuplicates() {
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input[] = { "", " ", null, "aa", "abcccde", "abc", "  a b b cc " };
		String expected_output[] = { "", " ", null, "a", "abcde", "abc",
				" a b b c " };
		for (int i = 0; i < input.length; i++) {
			assertEquals(expected_output[i],
					obj.removeConsecutiveDuplicates(input[i]));
		}
	}
	
	@Test
	public void testBinarySearchRecursive(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		ArrayList<Integer[]> input = new ArrayList<Integer[]>(); 
		input.add(new Integer[] {});
		input.add(new Integer[] {1,2,3});
		input.add(new Integer[] {1,2,3});
		input.add(new Integer[] {1,2,3});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(null);
		int key[] = {1,1,2,3,-1,2,3,4,5,-1};
		int expected_output[] = {-1,0,1,2,0,1,2,3,4,-1};
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case "+i);
			int b[] = null;
			b = convertIntegerArraytoIntArray(input, i, b);
			assertEquals(expected_output[i],
					obj.binarySearchRecursive(b, key[i]));
		}
	}

	@Test
	public void testBinarySearchIterative(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		ArrayList<Integer[]> input = new ArrayList<Integer[]>(); 
		input.add(new Integer[] {});
		input.add(new Integer[] {1,2,3});
		input.add(new Integer[] {1,2,3});
		input.add(new Integer[] {1,2,3});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(new Integer[] {-1,2,3,4,5});
		input.add(null);
		int key[] = {1,1,2,3,-1,2,3,4,5,-1};
		int expected_output[] = {-1,0,1,2,0,1,2,3,4,-1};
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case "+i);
			int b[] = null;
			b = convertIntegerArraytoIntArray(input, i, b);
			assertEquals(expected_output[i],
					obj.binarySearchIterative(b, key[i]));
		}
	}
	
	private int[] convertIntegerArraytoIntArray(ArrayList<Integer[]> input,
			int i, int[] b) {
		Integer[] a = input.get(i);
		if (a != null) {
			b = new int[a.length];
			int index = 0;
			for (Integer j : a)
				b[index++] = j;
		}
		return b;
	}
	
	@Test
	public void testMergeTwoSortedArrays(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		int a1[] ={1,2,3,0,0};int b1[] = {1,2};
		int expected_output[] = {1,1,2,2,3};
		obj.mergeTwoSortedArrays(a1, b1, 3, 2);
		assertArrayEquals(expected_output,a1);
		
		int a2[] ={0,0,0};int b2[] = {1,2};
		int expected_output2[] = {1,2,0};
		obj.mergeTwoSortedArrays(a2, b2, 0, 2);
		assertArrayEquals(expected_output2,a2);
		
//		int a3[] =null;int b3[] = {1,2};
//		int expected_output3[] = null;
//		obj.mergeTwoSortedArrays(a3, b3, 0, 2);
//		assertArrayEquals(expected_output3,a3);
		
		int a4[] ={1,2,3,4,0,0};int b4[] = {-2,-1};
		int expected_output4[] = {-2,-1,1,2,3,4};
		obj.mergeTwoSortedArrays(a4, b4, 4, 2);
		assertArrayEquals(expected_output4,a4);
	}
	
	// incom;lete
	@Test
	public void testReturnAnagramList() {
		StringsAndArrays obj = StringsAndArrays.getInstance();
		List<String[]> input= new ArrayList<String[]>();
		input.add(new String[]{});
		input.add(new String[]{"qwerty","yteqwr","ab","ba","a"});
		for( int i=0;i<input.size();i++){
			List<List<String>> result = obj.anagramList(input.get(i));
			for(List<String> eachList: result){
				for( String eachAnagram: eachList){
					System.out.print(eachAnagram+" ");
				}
				System.out.println();
			}
		}
	}
	
	@Test
	public void testBinarySearchRotatedArray(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		ArrayList<Integer[]> input = new ArrayList<Integer[]>(); 
		input.add(new Integer[] {});
		input.add(new Integer[] {1,2,3});
		input.add(new Integer[] {1,2,3});
		input.add(new Integer[] {1,2,3});
		input.add(new Integer[] {3,4,5,-1,2});
		input.add(new Integer[] {3,4,5,-1,2});
		input.add(new Integer[] {3,4,5,-1,2});
		input.add(new Integer[] {3,4,5,-1,2});
		input.add(new Integer[] {3,4,5,-1,2});
		input.add(new Integer[] {6,7,8,1});
		input.add(new Integer[] {6,7,8,1});
		input.add(new Integer[] {6,7,8,1});
		input.add(new Integer[] {6,7,8,1});
		input.add(null);
		int key[] = {1,1,2,3,-1,2,3,4,5,6,7,8,1,-1};
		int expected_output[] = {-1,0,1,2,3,4,0,1,2,0,1,2,3,-1};
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case "+i);
			int b[] = null;
			b = convertIntegerArraytoIntArray(input, i, b);
			assertEquals(expected_output[i],
					obj.binarySearchRotatedArrayRecursive(b, key[i]));
		}
	}
	
	@Test
	public void testRemoveExtraSpaces(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input[]= {" Yo   there"," Holy Shite ",""," ","  ",null};
		String expected_output[] ={"Yo there","Holy Shite","","","",null};
		for (int i = 0; i < input.length; i++) {
			assertEquals(expected_output[i],
					obj.removeExtraSpaces(input[i]));
		}
	}
	
	@Test
	public void testAreCharactersUnique(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input1[] = {"",null," ","Karthikeyan","Singh is King","Matriculation","Karthik"};
		boolean expected_output[]= {true,true,true,false,false,false,true};
		
		for (int i = 0; i < input1.length; i++) {
			System.out.println("case "+i);
			assertEquals(expected_output[i],
					obj.areCharactersUnique(input1[i]));
		}
	}
	
	@Test
	public void testRemoveDuplicateCharacters(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input1[] = {"",null," ","aa","aba","aab","baa","abbccc","cabcb"};
		String expected_output[] = {"", null, " ", "a","ab","ab","ba","abc","cab"};
		for (int i = 0; i < input1.length; i++) {
			System.out.println("case "+i);
			assertEquals(expected_output[i],
					obj.removeDuplicateCharacters(input1[i]));
		}
	}
	
	
	@Test
	public void testStringSort(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input1[] = {"",null," ","aa","aba","aab","baa","abbccc","cabcb"};
		String expected_output[] = {"", null, " ", "aa","aab","aab","aab","abbccc","abbcc"};
		for (int i = 0; i < input1.length; i++) {
			System.out.println("case "+i);
			assertEquals(expected_output[i],
					obj.stringSort(input1[i]));
		}
	}
	
	@Test
	public void testLongestRun(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input1[] = {"",null," ","aa","aba","aab","aabb","abbccc","aabbb","aaab"};
		String expected_output[] = {"", null, " ", "aa","a","aa","aa","ccc","bbb","aaa"};
		for (int i = 0; i < input1.length; i++) {
			System.out.println("case "+i);
			assertEquals(expected_output[i],
					obj.longestRun(input1[i]));
		}
	}
	
	@Test
	public void testZigZagConvert(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input1[] = {"PAYPALISHIRING","A", null, "","1"};
		int input2[] = {3,1,0,0,1};
		String expected_output[] = {"PAHNAPLSIIGYIR","A",null,"","1"};
		for (int i = 0; i < input1.length; i++) {
			System.out.println("case "+i);
			assertEquals(expected_output[i],
					obj.zigZagConvert(input1[i],input2[i]));
		}
	}
	

	@Test
	public void testCompressString(){
		StringsAndArrays obj = StringsAndArrays.getInstance();
		String input[] = {"1","11", "21", "1211","111221"};
		String expected_output[] = {"11","21","1211","111221","312211"};
		for(int i=0;i<input.length;i++){
			System.out.println("case "+i);
			assertEquals(expected_output[i],obj.compressString(input[i]));		
		}
		
	}
	@Test
	public void testNthPatternOfCompressedSeries(){
		
		int input[] = {1,2,3,4,5,6,7,8,9};
		String expected_output[] = {"1","11","21","1211","111221","312211","13112221","1113213211","31131211131221"};
		for(int i=0;i<input.length;i++){
			System.out.println("case "+i);
			assertEquals(expected_output[i],obj.compressedSequence(input[i]));		
		}
	}
	
	@Test
	public void testFindNumeronyms(){
		String i1 = "careercup";
		String s1 = "careercup,c1reercup,ca1eercup,car1ercup,care1rcup,caree1cup,career1up,careerc1p,c2eercup,ca2ercup,car2rcup,care2cup,caree2up,career2p,c3ercup,ca3rcup,car3cup,care3up,caree3p,c4rcup,ca4cup,car4up,care4p,c5cup,ca5up,car5p,c6up,ca6p,c7p";
		String[] o1 = (s1.split(","));
		assertEquals(o1, obj.numeronyms(i1));
	}
	
	@Test
	public void testRegularExpressionMatching(){
		String i1[] = {"a","ab","ab"};
		String i2[] = {"a","a.",".b"};
		boolean[] expected_output = {true, true, true};
		for(int i=0;i<i1.length;i++)
			assertEquals(expected_output[i],obj.regularExpressionMatching(i1[i], i2[i]));
	}
	
	@Test
	public void testSumCloseToZero(){
		int a[] = {-1,4,6,-100,5,9,20,3,2,1,-2,-3,3};
		int output[] = obj.sumCloseToZero(a);
		for(int i:output)
			System.out.println(i);
	}
	
	@Test
	public void testPrintDuplicatesWithExtraSpace(){
		List<int[]> input= new ArrayList<int[]> ();
		input.add(null);
		input.add(new int[]{});
		input.add(new int[]{1});
		input.add(new int[]{1,2});
		input.add(new int[]{1,2,3});
		input.add(new int[]{1,1});
		input.add(new int[]{1,1,1});
		input.add(new int[]{1,2,1});
		input.add(new int[]{1,1,2,1,1});
		input.add(new int[]{1,1,2,2,1,1});
		
		for(int i = 0; i<input.size();i++){
			System.out.println("Case: "+i);
			obj.printDuplicatesWithExtraSpace(input.get(i));
		}
	}
	
	@Test
	public void testPrintDuplicatesWithoutExtraSpace(){
		List<int[]> input= new ArrayList<int[]> ();
		input.add(null);
		input.add(new int[]{});
		input.add(new int[]{1});
		input.add(new int[]{1,2});
		input.add(new int[]{1,2,3});
		input.add(new int[]{1,1});
		input.add(new int[]{1,1,1});
		input.add(new int[]{1,2,1});
		input.add(new int[]{1,1,2,1,1});
		input.add(new int[]{1,1,2,2,1,1});
		
		for(int i = 0; i<input.size();i++){
			System.out.println("Case: "+i);
			obj.printDuplicatesWithoutExtraSpace(input.get(i));
		}
	}
	
	@Test
	public void testFindRotationsInRotatedSortedArray(){
		List<int[]> input= new ArrayList<int[]> ();
		input.add(null);
		input.add(new int[]{});
		input.add(new int[]{1});
		input.add(new int[]{12,33,44,55,11});
		input.add(new int[]{33,44,55,11,12});
		input.add(new int[]{44,55,11,12,33});
		input.add(new int[]{55,11,12,33,44});
		input.add(new int[]{11,12,33,44,55});
		input.add(new int[]{12,13,33,44,55,11});
		input.add(new int[]{13,33,44,55,11,12});
		input.add(new int[]{33,44,55,11,12,13});
		input.add(new int[]{44,55,11,12,13,33});
		input.add(new int[]{55,11,12,13,33,44});
		input.add(new int[]{11,12,13,33,44,55});
//		input.add(new int[]{1,1,2,2,1,1});
		
		int expected_output[] = {0,0,0,4,3,2,1,0,5,4,3,2,1,0};
		for(int i = 0; i<input.size();i++){
			System.out.println("Case: "+i);
			int result = obj.pivotOfRotatedArray(input.get(i));
			assertEquals(expected_output[i],result);
		}
	
	}
	
	@Test
	public void testGetIntersectionOfSets(){
		List<int []> input1 = new ArrayList<int[]>();
		input1.add(null);
		input1.add(new int[] {1,2,3,4,5});
		input1.add(null);
		input1.add(new int[] {1,3,5,7,9});
		input1.add(new int[] {1,2,3,5,7,9,10,11});
		input1.add(new int[] {1,2,3,5,7,9,10,11});
		List<int []> input2 = new ArrayList<int[]>();
		input2.add(new int[] {1,2,3,4,5});
		input2.add(null);
		input2.add(null);
		input2.add(new int[] {2,4,6,8,10});
		input2.add(new int[] {2,4,6,8,10});
		input2.add(new int[] {1,2,3,5,7,9,10,11});
	
		List<int []> expect_o1 = new ArrayList<int[]>();
		expect_o1.add(null);
		expect_o1.add(null);
		expect_o1.add(null);
		expect_o1.add(new int[] {});
		expect_o1.add(new int[] {2,10});
		expect_o1.add(new int[] {1,2,3,5,7,9,10,11});
		
		
		for( int i = 0;i<input1.size();i++){
			System.out.println("case: "+i);
			assertArrayEquals(expect_o1.get(i), obj.intersectionOfSortedSets(input1.get(i), input2.get(i)));
		}
		
	}
	@Test
	public void testGetUnionOfSets(){
		List<int []> input1 = new ArrayList<int[]>();
		input1.add(null);
		input1.add(new int[] {1,2,3,4,5});
		input1.add(null);
		input1.add(new int[] {1,3,5,7,9});
		input1.add(new int[] {1,2,3,5,7,9,10,11});
		List<int []> input2 = new ArrayList<int[]>();
		input2.add(new int[] {1,2,3,4,5});
		input2.add(null);
		input2.add(null);
		input2.add(new int[] {2,4,6,8,10});
		input2.add(new int[] {2,4,6,8,10});
	
		List<int []> expect_o1 = new ArrayList<int[]>();
		expect_o1.add(new int[] {1,2,3,4,5});
		expect_o1.add(new int[] {1,2,3,4,5});
		expect_o1.add(null);
		expect_o1.add(new int[] {1,2,3,4,5,6,7,8,9,10});
		expect_o1.add(new int[] {1,2,3,4,5,6,7,8,9,10,11});
		
		for( int i = 0;i<input1.size();i++){
			System.out.println("case: "+i);
			assertArrayEquals(expect_o1.get(i), obj.unionOfSortedSets(input1.get(i), input2.get(i)));
		}
		
	}
	@Test
	public void testReplaceSpaceWith(){
		String[] input = {"Hello World     ","Zombie land is the best            ","To hell  with this world               "};
		int[] length = {11,23,24};
		for( int i = 0;i<input.length;i++){
			System.out.println("case: "+i);
			char[] c = input[i].toCharArray();
			obj.replaceSpaceWith(c, length[i]);
			System.out.println(c);
		}
	}
	@Test
	public void testMagicIndex(){
		List<int[]> input =  new ArrayList<int[]>();
		input.add(new int[]{0,2,3,4,6,7,8});
		input.add(new int[]{-1,1,3,4,6,7,8});
		input.add(new int[]{-1,0,2,4,6,7,8,9});
		input.add(new int[]{-1,0,1,3,6,7,8,9});
		input.add(new int[]{-1,0,1,2,4,7,8,9});
		input.add(new int[]{-1,0,1,2,3,5,8,9});
		input.add(new int[]{-1,0,1,2,3,4,6,9});
		input.add(new int[]{-1,0,1,2,3,4,5,7});
		input.add(new int[]{-1,0,1,2,3,4,5,6,8});
		int[] expected={0,1,2,3,4,5,6,7,8};
		for( int i=0;i<input.size();i++){
			System.out.println("Case:"+i);
			assertEquals(expected[i],obj.magicIndex(input.get(i)));
		}
	}
	@Test
	public void testMagicIndexHandleDuplicates(){
		int[] input={-10,-5,2,2,2,3,4,7,9,12,13};

			System.out.println(obj.magicIndex2(input));
	
	}
	@Test
	public void testTwoSum(){
		int[] input = {1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,
				2,2,2,2,2,2,2,3,3,3,3,3,3,3,
				4,4,4,4,4,4,4,
				5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,
				6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6};
		obj.twoSum(input, 7);
	}
	@Test
	public void testThreeSumClosest(){
		List<int[]> input = new ArrayList<int[]>();
		input.add(new int[]{-2,-1,0,7,8,9,10});
		input.add(new int[]{Integer.MIN_VALUE,0,0});
		input.add(new int[]{Integer.MAX_VALUE,0,0});
//		input.add(new int[]{});
		int expected[]= {-3,Integer.MIN_VALUE,Integer.MAX_VALUE};
		for(int i=0;i<input.size();i++){
			assertEquals(expected[i],obj.threeSumClosest(input.get(i), 0));
		}
	}
	
	@Test
	public void testSearchRange(){
		int[] input = {1,1,1,1,1,1,1,1,
					   2,2,2,2,2,2,2,2,2,
					   3,3,3,3,3,3,3,3,3,3,
					   4,4,4,4,4,4,4,4,4,4,4,
					   5,5,5,5,5,5,5,5,5,5,5,5,
					   6,6,6,6,6,6,6,6,6,6,6,6,6};
		int[][] expected={{0,7},{8,16},{17,26},{27,37},{38,49},{50,62},{-1,-1}};
		
		assertArrayEquals(new int[]{-1,-1},obj.searchRange(null, 7));
		for(int i=0;i<7;i++){
			assertArrayEquals(expected[i],obj.searchRange(input, i+1));
		}
	}
	@Test
	public void testSubsetsWithDuplicates(){
		int[] input = {1,2,2};
		obj.subsetsWithDuplicates(input);
	}
	
	@Test
	public void testDifferenceOfSortedSets(){
		// incomplete
		List<Integer[]> a1 = new ArrayList<Integer[]>();
		List<Integer[]> b1 = new ArrayList<Integer[]>();
		List<List<Integer>> expected = new ArrayList<List<Integer>>();
		a1.add(null);
		b1.add(new Integer[]{1});
		expected.add(null);

	}
}