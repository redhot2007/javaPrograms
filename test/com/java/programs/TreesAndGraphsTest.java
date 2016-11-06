package com.java.programs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.java.models.TreesAndGraph.TreeNode;
import com.java.programs.TreesAndGraphs;

public class TreesAndGraphsTest {
	TreesAndGraphs obj = null;
	boolean t = true;
	boolean f = false;

	@Before
	public void initialize() {
		obj = new TreesAndGraphs();
	}

	@Test
	public void testFindMaxAmplitude() {
		TreesAndGraphs obj = new TreesAndGraphs();
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(TreeNode.generateBalancedTree(1));
		input.add(TreeNode.generateBalancedTree(4));
		input.add(TreeNode.generateBalancedTree(5));
		input.add(TreeNode.generateUnbalancedTree(1));
		input.add(TreeNode.generateUnbalancedTree(5));
		input.add(TreeNode.generateUnbalancedTree(6));
		input.add(null);
		int expected_output[] = { 1, 4, 5, 4, 8, 9, 0 };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			assertEquals(expected_output[i], obj.maximumAmplitude(input.get(i), 0));
		}
	}

	@Test
	public void testIsBalancedBad() {
		TreesAndGraphs obj = new TreesAndGraphs();
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(TreeNode.generateBalancedTree(1));
		input.add(TreeNode.generateBalancedTree(4));
		input.add(TreeNode.generateBalancedTree(5));
		input.add(TreeNode.generateUnbalancedTree(1));
		input.add(TreeNode.generateUnbalancedTree(5));
		input.add(TreeNode.generateUnbalancedTree(6));
		input.add(null);
		boolean expected_output[] = { t, t, t, f, f, f, t };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			assertEquals(expected_output[i], obj.isBalancedBad(input.get(i)));
		}
	}

	@Test
	public void testIsBalancedOpt() {
		TreesAndGraphs obj = new TreesAndGraphs();
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(TreeNode.generateBalancedTree(1));
		input.add(TreeNode.generateBalancedTree(4));
		input.add(TreeNode.generateBalancedTree(5));
		input.add(TreeNode.generateUnbalancedTree(1));
		input.add(TreeNode.generateUnbalancedTree(5));
		input.add(TreeNode.generateUnbalancedTree(6));
		// input.add(TreeNode.generateUnbalancedTree(Integer.MAX_VALUE));
		input.add(null);
		boolean expected_output[] = { t, t, t, f, f, f, t };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			assertEquals(expected_output[i], obj.isBalancedOpt(input.get(i)));
		}
	}

	@Test
	public void testMirrorThetree() {
		TreesAndGraphs obj = new TreesAndGraphs();

		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(TreeNode.generateBalancedTree(1));
		input.add(TreeNode.generateBalancedTree(2));
		input.add(TreeNode.generateBalancedTree(3));
		input.add(TreeNode.generateUnbalancedTree(1));
		input.add(TreeNode.generateUnbalancedTree(2));
		input.add(TreeNode.generateUnbalancedTree(3));
		// input.add(TreeNode.generateUnbalancedTree(Integer.MAX_VALUE));
		input.add(null);
		// boolean expected_output[] = {t,t,t,f,f,f,t};
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			obj.preOrderTraversal(input.get(i));
			System.out.println();
			obj.mirror(input.get(i));
			obj.preOrderTraversal(input.get(i));
			System.out.println();
		}

	}

	@Test
	public void testCloneThetree() {
		TreesAndGraphs obj = new TreesAndGraphs();

		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(TreeNode.generateBalancedTree(1));
		input.add(TreeNode.generateBalancedTree(2));
		input.add(TreeNode.generateBalancedTree(3));
		input.add(TreeNode.generateUnbalancedTree(1));
		input.add(TreeNode.generateUnbalancedTree(2));
		input.add(TreeNode.generateUnbalancedTree(3));
		// input.add(TreeNode.generateUnbalancedTree(Integer.MAX_VALUE));
		input.add(null);
		// boolean expected_output[] = {t,t,t,f,f,f,t};
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			obj.preOrderTraversal(input.get(i));
			System.out.println();
			TreeNode output = obj.clone(input.get(i));
			obj.preOrderTraversal(output);
			System.out.println();
		}

	}

	@Test
	public void testSortedArrayToBST() {
		List<int[]> input = new ArrayList<int[]>();
		input.add(new int[] { 1 });
		input.add(new int[] { 1, 2, 3, 4, 5, 6 });
		input.add(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		input.add(new int[] {});
		input.add(null);
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			int[] js = input.get(i);
			TreeNode output = obj.sortedArrayToBST(js);
			obj.preOrderTraversal(output);
			System.out.println();
		}

	}

	@Test
	public void testAllPaths() {
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(obj.sortedArrayToBST(new int[] { 1 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6 }));
		for (int i = 0; i < input.size(); i++) {
			System.out.println();
			System.out.println("case: " + i);
			obj.allPaths(input.get(i));
		}
	}

	@Test
	public void testBreadthFirstSearch() {
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(TreeNode.generateBalancedTree(1));
		input.add(TreeNode.generateBalancedTree(2));
		input.add(TreeNode.generateBalancedTree(3));
		input.add(TreeNode.generateBalancedTree(4));
		input.add(TreeNode.generateUnbalancedTree(1));
		input.add(TreeNode.generateUnbalancedTree(2));
		input.add(TreeNode.generateUnbalancedTree(3));
		input.add(null);
		int[] searchInput = { 0, 2, 2, 7, 4, 1, 2, 3 };
		for (int i = 0; i < input.size(); i++) {
			System.out.println();
			System.out.println("case: " + i);
			TreeNode ret = obj.breadthFirstSearch(input.get(i), searchInput[i]);
			System.out.println(ret != null ? ret.getValue() : "null");
		}
	}

	@Test
	public void testDepthFirstSearch() {
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(TreeNode.generateBalancedTree(1));
		input.add(TreeNode.generateBalancedTree(2));
		input.add(TreeNode.generateBalancedTree(3));
		input.add(TreeNode.generateBalancedTree(4));
		input.add(TreeNode.generateUnbalancedTree(1));
		input.add(TreeNode.generateUnbalancedTree(2));
		input.add(TreeNode.generateUnbalancedTree(3));
		input.add(null);
		input.add(TreeNode.generateUnbalancedTree(3));
		input.add(TreeNode.generateUnbalancedTree(2));
		int[] searchInput = { 0, 2, 2, 7, 4, 1, 2, 3, 100, 100 };
		int[] expected = { 0, 2, 2, 7, 4, 1, 2, -1, -1, -1 };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			TreeNode ret = obj.depthFirstSearch(input.get(i), searchInput[i]);
			assertEquals(expected[i], ret != null ? ret.getValue() : -1);
		}
	}

	@Test
	public void testFirstCommonAncestor() {
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(TreeNode.generateBalancedTree(1));
		input.add(TreeNode.generateBalancedTree(2));
		input.add(TreeNode.generateBalancedTree(3));
		input.add(TreeNode.generateBalancedTree(4));
		input.add(TreeNode.generateUnbalancedTree(1));
		input.add(TreeNode.generateUnbalancedTree(2));
		input.add(TreeNode.generateUnbalancedTree(3));
		input.add(TreeNode.generateBalancedTree(1));
		input.add(null);
		int[] searchInput = { 0, 1, 3, 4, 0, 1, 0, 3, 10 };
		int[] searchInput2 = { 0, 2, 2, 7, 4, 4, 6, 3, 11 };
		int[] expected_output = { 0, 0, 0, 1, 0, 0, 0, -1, -1 };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			TreeNode ret = obj.firstCommonAncestor(input.get(i), searchInput[i], searchInput2[i]);
			assertEquals(expected_output[i], ret != null ? ret.getValue() : -1);
		}

	}

	@Test
	public void testprintAllNodesAtGivenLevel() {
		TreeNode i = (TreeNode.generateBalancedTree(4));
		obj.printAllNodesAtGivenLevel(i, 3);
	}

	@Test
	public void testListsFromBT() {
		TreeNode root = obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		List<LinkedList<TreeNode>> result = obj.levelOrderRecursive(root);
		for (LinkedList<TreeNode> r : result) {
			for (TreeNode t : r) {
				System.out.print(t.value + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void testListsFromBTIterative() {
		TreeNode root = obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		List<List<TreeNode>> result = obj.levelOrderIterative(root);
		for (List<TreeNode> r : result) {
			for (TreeNode t : r) {
				System.out.print(t.value + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void testPathSum() {
		TreeNode root = obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		obj.pathSum(root, 7);
	}

	@Test
	public void testIsValidBSTWithoutDuplicate() {
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 6, 7, 5 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 7, 5 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 6, 7, 9 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 6, 7 }));
		input.add(obj.sortedArrayToBST(new int[] { 1 }));
		input.add(null);
		boolean expected[] = { false, false, true, true, true, true };
		for (int i = 0; i < input.size(); i++) {
			assertEquals(expected[i], obj.isValidBSTWithoutDuplicate(input.get(i)));
		}
	}

	@Test
	public void testIsValidBSTWithDuplicate() {
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 6, 7, 5 }));
		input.add(obj.sortedArrayToBST(new int[] { 5, 5, 1, 1, 2, 2, 3 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 7, 5 }));
		input.add(obj.sortedArrayToBST(new int[] { 3, 3, 3, 1, 1, 1 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 6, 7, 9 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 1, 2, 2, 3, 3, 4 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 6, 7 }));
		input.add(obj.sortedArrayToBST(new int[] { 1 }));
		input.add(null);
		boolean expected[] = { false, false, false, false, true, true, true, true, true };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			assertEquals(expected[i], obj.isValidBSTWithDuplicates(input.get(i)));
		}
	}

	@Test
	public void testLeftView() {
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(obj.sortedArrayToBST(new int[] { 1 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6 }));
		input.add(null);
		List<int[]> expected = new ArrayList<int[]>();
		expected.add(new int[] { 1 });
		expected.add(new int[] { 1, 2 });
		expected.add(new int[] { 2, 1 });
		expected.add(new int[] { 2, 1, 4 });
		expected.add(new int[] { 3, 1, 2 });
		expected.add(new int[] { 3, 1, 2 });
		expected.add(new int[] {});
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			int[] result = obj.leftView(input.get(i));
			assertArrayEquals(expected.get(i), result);
			System.out.println();
		}
	}

	@Test
	public void testMaximumSumFromRootToLeaf() {
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(obj.sortedArrayToBST(new int[] { 1 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5 }));
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6 }));
		input.add(null);
		TreeNode temp = obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6 });
		obj.mirror(temp);
		input.add(temp);
		temp = obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5 });
		obj.mirror(temp);
		input.add(temp);
		temp = obj.sortedArrayToBST(new int[] { 1, 2, 3, 4 });
		obj.mirror(temp);
		input.add(temp);
		temp = obj.sortedArrayToBST(new int[] { 1, 2, 3 });
		obj.mirror(temp);
		input.add(temp);
		temp = obj.sortedArrayToBST(new int[] { 1, 2 });
		obj.mirror(temp);
		input.add(temp);
		temp = obj.sortedArrayToBST(new int[] { 1 });
		obj.mirror(temp);
		input.add(temp);
		int[] expected = { 1, 3, 5, 9, 12, 14, 0, 14, 12, 9, 5, 3, 1 };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			int result = obj.maximumSumFromRootToLeaf(input.get(i));
			assertEquals(expected[i], result);
		}
	}

	@Test
	public void testZigzagLevelOrder() {
		ArrayList<TreeNode> input = new ArrayList<TreeNode>();
		input.add(obj.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6 }));
		obj.zigzagLevelOrder(input.get(0));
	}
}
