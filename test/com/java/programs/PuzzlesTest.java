package com.java.programs;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;
//import org.mockito.Mockito;

import com.java.models.puzzles.Fraction;
import com.java.models.puzzles.Kid;
import com.java.models.puzzles.MaxSubArrayResultNode;
import com.java.programs.Puzzles;
import com.java.programs.StringsAndArrays;

public class PuzzlesTest {

	@Test
	public void testReverseTheNumber() {
		// System.out.println(-11/10);
		Puzzles obj = new Puzzles();
		int[] input = { 1, -1, 123, -123, 12, -12, 1234567899, 0, -2147483648,
				2147483647 };
		int[] expected_output = { 1, -1, 321, -321, 21, -21, 0, 0, 0, 0 };
		for (int i = 0; i < input.length; i++) {
			System.out.println("Case: " + i);
			assertEquals(expected_output[i], obj.reverseTheNumber(input[i]));
		}
	}

	@Test
	public void testIsPalindrome() {
		Puzzles obj = new Puzzles();
		int[] input = { -1, 0, 1, 12, 11, 123, 121, Integer.MAX_VALUE,
				Integer.MIN_VALUE };
		boolean f = Boolean.FALSE;
		boolean t = Boolean.TRUE;
		boolean[] expected_output = { f, t, t, f, t, f, t, f, f };
		for (int i = 0; i < input.length; i++) {
			System.out.println("Case: " + i);
			assertEquals(expected_output[i], obj.isPalindrome(input[i]));
		}
	}

	@Test
	public void testIsPalindromeWithoutExtraSpace() {
		Puzzles obj = new Puzzles();
		int[] input = { -1, 0, 1, 12, 11, 123, 121, Integer.MAX_VALUE,
				Integer.MIN_VALUE };
		boolean f = Boolean.FALSE;
		boolean t = Boolean.TRUE;
		boolean[] expected_output = { f, t, t, f, t, f, t, f, f };
		for (int i = 0; i < input.length; i++) {
			System.out.println("Case: " + i);
			assertEquals(expected_output[i],
					obj.isPalindromeWithoutExtraSpace(input[i]));
		}
	}

	@Test
	public void testFormattedDivision() {
		Puzzles obj = new Puzzles();
		int[] n = { 2, 5, 7, 11, 17,6 };
		int d = 3;
		String[] expected_output = { "0.66", "1.66666", "2.3333333",
				"3.66666666666", "5.66666666666666666","2.0"};
		for (int i = 0; i < n.length; i++) {
			System.out.println("Case: " + i);
			assertEquals(expected_output[i], obj.formattedDivision(n[i], d));
		}
	}

	@Test
	public void testWildcard() {
		Puzzles obj = new Puzzles();
		String[] input = { "100?", "1???0" };
		// String[] input = {"100?"};
		List<List<String>> expected = new ArrayList<List<String>>();
		List<String> one = new ArrayList<String>();
		one.add("1000");
		one.add("1001");
		expected.add(one);
		List<String> two = new ArrayList<String>();
		two.add("10000");
		two.add("10010");
		two.add("10100");
		two.add("11000");
		two.add("11010");
		two.add("11100");
		two.add("11110");
		two.add("10110");
		expected.add(two);
		for (int i = 0; i < input.length; i++) {
			System.out.println("Case: " + i);
			ArrayList<String> actual = obj.wildcard(input[i]);

			Collections.sort(actual);
			List<String> e = expected.get(i);
			Collections.sort(e);
			assertEquals(e, actual);
		}
	}

	private Puzzles obj = null;

	@Before
	public void initialize() {
		obj = new Puzzles();
	}

	@Test
	public void testOrderItinerary() {
		String[][] input = { { "D", "E" }, { "C", "D" }, { "B", "C" },
				{ "A", "B" } };
		String[] expected_output = { "A", "B", "C", "D", "E" };
		for (String s : obj.orderItinerary(input))
			System.out.println(s);
		assertEquals(expected_output, obj.orderItinerary(input));

	}

	@Test
	public void testFindNumberOfCanoes() {
		List<List<Kid>> input = new ArrayList<List<Kid>>();
		input.add(Kid.getKids(new int[]{80,40,90,30,60}));
		input.add(Kid.getKids(new int[]{80,40,90,30,60,100,20,101}));
		input.add(Kid.getKids(new int[]{80,40,90,30,60,100,20,101,87,64,32}));
//		input.add(Kid.getKids(new int[]{}));
//		input.add(Kid.getKids(new int[]{}));
		for(int i=0;i<input.size();i++){
			System.out.println("case: "+i);
			System.out.println(obj.findNumberOfCanoes(input.get(i), 150));
		}
	}

	@Test
	public void testdifference() throws IOException {
//		BufferedReader b1 = Mockito.mock(BufferedReader.class);
//		Mockito.when(b1.readLine()).thenReturn("0").thenReturn("0")
//				.thenReturn("1").thenReturn(null);
//		BufferedReader b2 = Mockito.mock(BufferedReader.class);
//		Mockito.when(b2.readLine()).thenReturn("9").thenReturn("9")
//				.thenReturn(null);
//		BufferedReader b3 = Mockito.mock(BufferedReader.class);
//		Mockito.when(b3.readLine()).thenReturn("8").thenReturn("4")
//				.thenReturn("0").thenReturn("2").thenReturn(null);
//		BufferedReader b4 = Mockito.mock(BufferedReader.class);
//		Mockito.when(b4.readLine()).thenReturn("4").thenReturn("2")
//				.thenReturn("0").thenReturn("1").thenReturn(null);
//		System.out.println(obj.difference(b1, b2));
//		System.out.println(obj.difference(b3, b4));
	}

	@Test
	public void testCombineIterators() {
		List<String> l1 = new ArrayList<String>();
		l1.add("a1");
		l1.add("a2");
		List<String> l2 = new ArrayList<String>();
		l2.add("b1");
		List<String> l3 = new ArrayList<String>();
		l3.add("c1");
		l3.add("c2");
		l3.add("c3");
		Iterator<String>[] input = new Iterator[3];
		input[0] = l1.iterator();
		input[1] = l2.iterator();
		input[2] = l3.iterator();
//		Iterator<String> output = new Puzzles.CombinedIterator(input);
		Iterator<String> output = obj.combineIterators(input);
		while (output.hasNext()) {
			System.out.println(output.next());
		}
	}

	@Test
	public void testFancyShuffle() {
		String[] input = { "aabbb", "aaaabb", "ab", "abcde", "abbccc", "aabb",
				"aabbcc", "aaaaaabbbb", "aaabbb" };
		boolean[] expected_output = { true, false, true, true, true, true,
				true, false, true };
		for (int i = 0; i < input.length; i++) {
			System.out.println("case: " + i);
			assertEquals(expected_output[i], obj.fancyShuffle(input[i]));
		}

	}

	@Test
	public void testRepresentNumberInsumOfSquares() {
		int input[] = { 0, 21, 32, 44, 57, 71, 100, 120, 1000, 100098, 198293 };
		for (int i = 0; i < input.length; i++) {
			System.out.println("case: " + i);
			obj.representNumberInsumOfSquares(input[i]);
			System.out.println();
		}
	}

	@Test
	public void testPrintNumbersLexicographicallly() {
		obj.printNumbersLexicographicallly(1, 100);

	}

	@Test
	public void testGenerateParenthesisHelper() {
		obj.generateParenthesis(3);

	}


	@Test
	public void testTrappedWaterVolume() {
		List<int[]> input = new ArrayList<int[]>();
		input.add(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });

		int[] expected_result = { 6 };
		for (int i = 0; i < input.size(); i++) {
			int result = obj.trappedWaterVolume(input.get(i));
			assertEquals(expected_result[i], result);
		}

	}

	@Test
	public void testrotate() {
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] matrix2 = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		// input.add(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});

		obj.rotate(matrix2);

	}

	@Test
	public void testGetPermutation() {
		obj.getPermutation(3, 6);
		System.out.println(4 % 3);
	}



	@Test
	public void testSimplifyPath() {
		System.out.println(obj.simplifyPath("/.."));
	}

	@Test
	public void testSortColors() {
		int[] colors = { 0, 1 };
		obj.sortColors(colors);
	}

	@Test
	public void testGrayCode() {
		obj.grayCode(4);
	}

	@Test
	public void testnextPermutation() {
		int input[] = new int[] { 4, 2, 0, 0, 2, 3, 2, 1 };
		// Arrays.sort(input);
		obj.nextPermutation(input);
	}

	@Test
	public void testMyAtoi() {
		String input[] = { "-1", " 1", " 0", "a", "1a1", "+1", "+12",
				"   +123", "2147483648", "-2147483649", "999999999999",
				"-999999999999","2147483640" };
		int[] expected_output = { -1, 1, 0, 0, 1, 1, 12, 123,
				Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE,
				Integer.MIN_VALUE ,2147483640};
		for (int i = 0; i < input.length; i++) {
			System.out.println("case " + i);
			assertEquals(expected_output[i], obj.myAtoi(input[i]));
		}

	}

	@Test
	public void testJump() {
		int input[] = { 2, 3, 1, 1, 4 };
		obj.jump(input);
	}



	@Test
	public void testMySqrt() {
		int[] input = { 1,2, 4, 9, 16, 25, 36, 49, 64, 81, 100, 10 };
		int[] expected = { 1,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3 };
		for (int i = 0; i < input.length; i++) {
			assertEquals(expected[i], obj.mySqrt(input[i]));
		}
	}

	@Test
	public void testIsPerfectSquare() {
		int[] input = { 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 101 };
		boolean[] expected = { true, true, true, true, true, true, true, true,
				true, true, false };
		for (int i = 0; i < input.length; i++) {
			assertEquals(expected[i], obj.isPerfectSquare(input[i]));
		}
	}




	@Test
	public void testgetAllocatedMemory() {
		System.out.println(obj.getAllocatedMemory() / 1024 / 1024);
	}

	@Test
	public void testrand7() {
		for (int i = 0; i < 10; i++) {
			System.out.println(obj.rand7());
		}
	}

	@Test
	public void testFactorialRecursive() {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int expected[] = { 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 };
		for (int i = 0; i < input.length; i++)
			assertEquals(expected[i], obj.factorialRecursive(input[i]));
	}

	@Test
	public void testFactorialIterative() {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int expected[] = { 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 };
		for (int i = 0; i < input.length; i++)
			assertEquals(expected[i], obj.factorialIterative(input[i]));
	}

	@Test
	public void testAddFraction() {
		Fraction[] one = { new Fraction(2, 3), new Fraction(4, 2),
				new Fraction(1, 3) };
		Fraction[] two = { new Fraction(12, 2), new Fraction(6, 3),
				new Fraction(5, 4) };
		Fraction[] expected = { new Fraction(20, 3), new Fraction(4, 1),
				new Fraction(19, 12) };
		for (int i = 0; i < one.length; i++) {
			Fraction result = obj.addFraction(one[i], two[i]);
			assertEquals(expected[i], result);
		}

	}

	@Test
	public void testAddBinary() {
		int[] input1 = { 1, 3, 5, 7, 9, 20, 0, 10 };
		int[] input2 = { 2, 4, 6, 8, 10, 40, 10, 0 };
		int[] expected = { 3, 7, 11, 15, 19, 60, 10, 10 };
		for (int i = 0; i < input1.length; i++) {
			assertEquals(
					Integer.toBinaryString(expected[i]),
					obj.addBinary(Integer.toBinaryString(input1[i]),
							Integer.toBinaryString(input2[i])));
		}
	}

	@Test
	public void testCheckForFibonacci() {
		int[] input = { 1, 2, 3, 4, 5, 8, 13, 14 };
		boolean[] expected = { true, true, true, false, true, true, true, false };
		for (int i = 0; i < input.length; i++) {
			assertEquals(expected[i], obj.checkForFibonacci(input[i]));
		}
	}
}
