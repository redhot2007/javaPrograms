package com.java.programs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.models.TreesAndGraph.TreeNode;
import com.java.models.puzzles.MaxSubArrayResultNode;
import com.java.programs.DynamicProgramming;
import com.java.programs.Puzzles;

public class DynamicProgrammingTest {
	private DynamicProgramming obj = null;

	@Before
	public void initialize() {
		obj = new DynamicProgramming();
	}

	@Test
	public void testKnapSack() {
		int[] weight = { 100, 300, 400, 500 };
		int[] value = { 1, 4, 5, 7 };
		List<Integer> result = obj.knapSack(weight, value, 400);
		for (int i : result)
			System.out.println(i);
	}

	@Test
	public void testLongesCommonSubsequence() {
		String input1[] = { "abcb", "abcde", null, "abc",
				"2763726a3943948j2939239j293929d" };
		String input2[] = { "bdcab", "abcde", "abc", null,
				"agdfgdhgfhdgjjdfdfjbdjiwiweiwd" };
		String expected[] = { "bcb", "abcde", null, null, "ajjd" };
		for (int i = 0; i < input1.length; i++) {
			assertEquals(expected[i],
					obj.longesCommonSubsequence(input1[i], input2[i]));
		}

	}

	@Test
	public void testLongesIncreasingSubsequence() {
		List<int[]> input = new ArrayList<int[]>();
		input.add(new int[] { 3, 4, -1, 0, 6, 2, 3 });
		input.add(new int[] { 2, 5, 1, 8, 4 });
		input.add(new int[] { -100, -200, 1, 0, 8, 7, 3, 6, 9 });
		// input.add(new int[] {});
		// input.add(new int[] {});

		int expected[] = { 4, 3, 5 };
		for (int i = 0; i < input.size(); i++) {
			assertEquals(expected[i],
					obj.longestIncreasingSubsequence(input.get(i)));
		}

	}

	@Test
	public void testLongesBuildingBridges() {
		List<int[]> input = new ArrayList<int[]>();
		input.add(new int[] { 2, 6 });
		input.add(new int[] { 5, 4 });
		input.add(new int[] { 8, 1 });
		input.add(new int[] { 10, 2 });
		int expected[] = { 2 };
		assertEquals(expected[0], obj.buildingBridges(input));

	}

	@Test
	public void testClimbStairsRecursion() {
		System.out.println(obj.climbStairsRecursion(4));
	}

	@Test
	public void testNumTrees() {
		int expected[] = { 1, 2, 5, 14, 42, 132 };
		for (int i = 1; i <= 5; i++)
			assertEquals(expected[i - 1], obj.numTrees(i));
	}

	@Test
	public void testLongestValidParentheses() {
		String input = "(()()())";
		int result = obj.longestValidParentheses(input);
		System.out.println(result);

	}

	@Test
	public void testMaxSubArray() {
		List<int[]> input = new ArrayList<int[]>();
		input.add(new int[] { -1, -2, 3, 4, -5, 6 });
		input.add(new int[] { -1, 9, -2, 3, 4, -5, 6 });
		input.add(new int[] { -1, -2, -3, 1, -5, -6 });
		input.add(new int[] { -2, -3, -1, -5, -6, -1 });
		input.add(new int[] { 2, 1, -3, 4, -1, 2, 1, -5, 4 });
		input.add(new int[] {});
		input.add(null);
		for (int i = 0; i < input.size(); i++) {
			MaxSubArrayResultNode result = obj.maxSubArray(input.get(i));
			if (result != null)
				System.out.format("start: %d end: %d maxValue: %d",
						result.start, result.end, result.max_result);
			System.out.println();

		}
	}

	@Test
	public void testUniquePaths() {
		int input[] = { 4, 5, 10 };
		int expected[] = { 20, 70, 48620 };
		for (int i = 0; i < input.length; i++)
			assertEquals(expected[i], obj.uniquePaths(input[i], input[i]));
	}

}
