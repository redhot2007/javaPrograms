package com.java.programs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.models.LinkedList.ListNode;
import com.java.models.LinkedList.ListStack;
import com.java.programs.LinkedList;

public class LinkedListTest {
	LinkedList obj = null;

	@Before
	public void initialize() {
		obj = new LinkedList();

	}

	@Test
	public void testReverseKGroup() {
		// LinkedListNode head = createLinkedList(new int[]{1,2,3});
		ListNode head = createLinkedList(new int[] { 1, 2, 3, 4 });
		ListNode result = obj.reverseKGroup(head, 2);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	@Test
	public void testFindMidElemOfLinkedList() {
		ArrayList<ListNode> linkedListInput = new ArrayList<ListNode>();
		ArrayList<ListNode> input = new ArrayList<ListNode>();
		input.add(null);
		input.add(createLinkedList(new int[] { 1 }));
		input.add(createLinkedList(new int[] { 1, 2 }));
		input.add(createLinkedList(new int[] { 1, 2, 3 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4 }));
		int[] expected_output = { -1, 1, -1, 2, -1 };
		for (int i = 0; i < linkedListInput.size(); i++) {
			ListNode output = obj.findMidElemOfLinkedList(linkedListInput
					.get(i));
			assertEquals(expected_output[i],
					output == null ? -1 : output.getValue());
		}
	}

	@Test
	public void testReverseIteratively() {
		ArrayList<ListNode> input = new ArrayList<ListNode>();
		input.add(null);
		input.add(createLinkedList(new int[] { 1 }));
		input.add(createLinkedList(new int[] { 1, 2 }));
		input.add(createLinkedList(new int[] { 1, 2, 3 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4 }));
		String[] expected = { "", "1", "21", "321", "4321" };

		for (int i = 0; i < input.size(); i++) {
			ListNode output = obj.reverseIteratively(input.get(i));
			String actual = stringifyList(output);
			assertEquals(expected[i], actual);
		}
	}


	@Test
	public void testSwapPairs() {
		ArrayList<ListNode> input = new ArrayList<ListNode>();
		input.add(null);
		input.add(createLinkedList(new int[] { 1 }));
		input.add(createLinkedList(new int[] { 1, 2 }));
		input.add(createLinkedList(new int[] { 1, 2, 3 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4 }));
		String[] expected = { "", "1", "21", "213", "2143" };

		for (int i = 0; i < input.size(); i++) {
			ListNode output = obj.swapPairs(input.get(i));
			String actual = stringifyList(output);
			assertEquals(expected[i], actual);
		}
	}

	@Test
	public void testFindKthNode() {
		ArrayList<ListNode> linkedListInput = new ArrayList<ListNode>();
		linkedListInput.add(new ListStack().createLinkedList(4));
		linkedListInput.add(new ListStack().createLinkedList(5));
		linkedListInput.add(null);
		int[] input2 = { 0, 1, 2, 3, 4, 5 };
		System.out.println("even length of list");
		for (int i : input2) {
			ListNode output = obj.findKthNode(linkedListInput.get(0), i);
			System.out.println(output == null ? null : output.getValue());
		}
		// odd length of list
		System.out.println("odd length of list");
		for (int i : input2) {
			ListNode output = obj.findKthNode(linkedListInput.get(1), i);
			System.out.println(output == null ? null : output.getValue());
		}
		System.out.println("null list");
		for (int i : input2) {
			ListNode output = obj.findKthNode(linkedListInput.get(2), i);
			System.out.println(output == null ? null : output.getValue());
		}
	}

	@Test
	public void testFindLoopInLinkedList() {
		ArrayList<ListNode> linkedListInput = new ArrayList<ListNode>();
		linkedListInput.add(null);
		linkedListInput.add(new ListStack().createLinkedList(1));
		linkedListInput.add(new ListStack().createLinkedList(2));
		linkedListInput.add(new ListStack().createLinkedList(3));
		linkedListInput.add(new ListStack().createLinkedList(4));
		linkedListInput.add(new ListStack().createLinkedList(9));
		linkedListInput.add(new ListStack().createLinkedList(10));

		int[] expected_output = { 0, -1, 4, -1, -1 };
		for (int i = 0; i < linkedListInput.size(); i++) {
			ListNode input = linkedListInput.get(i);
			ListStack.printStack(input);
			if (i != linkedListInput.size() - 1)
				createLoop(input, 1);
			ListNode output = obj.findLoopInLinkedList(input);
			System.out.println(output == null ? null : output.getValue());
			// assertEquals(expected_output[i],output==null?-1:output.getValue());
		}
	}

	@Test
	public void testReversePrintLinkedListRecursive() {
		ArrayList<ListNode> linkedListInput = new ArrayList<ListNode>();
		linkedListInput.add(null);
		linkedListInput.add(new ListStack().createLinkedList(1));
		linkedListInput.add(new ListStack().createLinkedList(2));
		linkedListInput.add(new ListStack().createLinkedList(3));
		linkedListInput.add(new ListStack().createLinkedList(4));
		linkedListInput.add(new ListStack().createLinkedList(9));
		linkedListInput.add(new ListStack().createLinkedList(10));
		for (int i = 0; i < linkedListInput.size(); i++) {
			obj.reversePrintLinkedListRecursive(linkedListInput.get(i));
			System.out.println();
			System.out.println("---");

		}
	}

	@Test
	public void testRemoveDuplicates() {
		ArrayList<ListNode> input = new ArrayList<ListNode>();
		input.add(null);
		input.add(createLinkedList(new int[] { 1 }));
		input.add(createLinkedList(new int[] { 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 1, 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 1, 2, 3, 4, 5, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 1, 2, 3, 4, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 1, 1, 2, 3, 4, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 2, 2, 2, 3, 4, 5, 5 }));
		String expected[] = { "", "1", "1", "1", "1", "1", "12345", "12345",
				"12345", "12345", "12345" };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			ListNode output = obj.removeDuplicates(input.get(i));
			String actual = stringifyList(output);
			assertEquals(expected[i], actual);
		}
	}

	@Test
	public void testRemoveDuplicatesFromSortedList() {
		ArrayList<ListNode> input = new ArrayList<ListNode>();
		input.add(null);
		input.add(createLinkedList(new int[] { 1 }));
		input.add(createLinkedList(new int[] { 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 1, 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 1, 2, 3, 4, 5, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 1, 2, 3, 4, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 1, 1, 2, 3, 4, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 2, 2, 2, 3, 4, 5, 5 }));
		String expected[] = { "", "1", "1", "1", "1", "1", "12345", "12345",
				"12345", "12345", "12345" };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			ListNode output = obj.removeDuplicatesFromSortedList(input.get(i));
			String actual = stringifyList(output);
			assertEquals(expected[i], actual);
		}
	}

	@Test
	public void testReturnUniqueElementsFromSortedList() {
		ArrayList<ListNode> input = new ArrayList<ListNode>();
		input.add(null);
		input.add(createLinkedList(new int[] { 1 }));
		input.add(createLinkedList(new int[] { 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 1, 2 }));
		input.add(createLinkedList(new int[] { 1, 1, 1, 2 }));
		input.add(createLinkedList(new int[] { 1, 1, 1, 2, 2, 2, 2, 3 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 1, 2, 3, 4, 5, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 1, 2, 3, 4, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 1, 1, 2, 3, 4, 5, 5 }));
		input.add(createLinkedList(new int[] { 1, 2, 2, 2, 3, 4, 5, 5 }));
		String expected[] = { "", "1", "", "2", "2", "3", "1234", "234", "234",
				"234", "134" };
		for (int i = 0; i < input.size(); i++) {
			System.out.println("case: " + i);
			ListNode output = obj.returnUniqueElementsFromSortedList(input
					.get(i));
			String actual = stringifyList(output);
			assertEquals(expected[i], actual);
		}
	}

	@Test
	public void testPrintDuplicates() {
		ArrayList<ListNode> linkedListInput = new ArrayList<ListNode>();
		linkedListInput.add(null);
		linkedListInput.add(new ListStack().createLinkedList(1));
		linkedListInput.add(new ListStack().createLinkedList(2));
		linkedListInput.add(new ListStack().createLinkedList(3));
		linkedListInput.add(new ListStack().createLinkedList(4));
		linkedListInput.add(new ListStack().createLinkedList(9));
		linkedListInput.add(new ListStack().createLinkedList(10));

		for (int i = 0; i < linkedListInput.size(); i++) {
			ListNode input = linkedListInput.get(i);

			if (i != linkedListInput.size() - 1)
				createDuplicateEntries(input);
			ListStack.printStack(input);
			obj.printDuplicates(input);
			System.out.println();
			System.out.println("---");
		}
	}

	@Test
	public void testPartition() {
		ListNode head = createLinkedList(new int[] { 1, 4, 3, 2, 5, 2 });
		ListNode result = obj.partition(head, 3);
		stringifyList(result);
	}

	@Test
	public void testInsertionSort() {
		ListNode head = createLinkedList(new int[] { 1, 4, 3, 2, 5, 2 });
		obj.insertionSortList(head);
		System.out.println(stringifyList(head));
	}
	
	@Test
	public void testReverseBetween() {
		ListNode head = createLinkedList(new int[] { 1, 2, 3, 4, 5, 6 });
		ListNode result = obj.reverseBetween(head, 2, 2);
		stringifyList(result);
	}

	@Test
	public void testMergeTwoSortedLists() {
		ListNode head = createLinkedList(new int[] { 1, 3, 4, 6 });
		ListNode head2 = createLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8,
				9, 10 });
		ListNode result = obj.mergeTwoSortedLists(head, head2);
		String expected = "112334456678910";
		String actual = stringifyList(result);
		assertEquals(expected, actual);
	}

	@Test
	public void testIsPalindromeIterative() {
		List<ListNode> input = new ArrayList<ListNode>();
		input.add(null);
		input.add(createLinkedList(new int[] { 1 }));
		input.add(createLinkedList(new int[] { 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 3, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 3, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2 }));
		input.add(createLinkedList(new int[] { 1, 2, 2 }));
		input.add(createLinkedList(new int[] { 1, 2, 2, 3 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 2, 4 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 3, 2, 5 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 3, 2, 5 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 4, 3, 2, 5 }));
		boolean[] expected = { true, true, true, true, true, true, true, true,
				true, false, false, false, false, false, false, false };
		for (int i = 0; i < input.size(); i++) {
			assertEquals(expected[i], obj.isPalindromeIterative(input.get(i)));
		}

	}
	@Test
	public void testIsPalindromeRecursive() {
		List<ListNode> input = new ArrayList<ListNode>();
		input.add(null);
		input.add(createLinkedList(new int[] { 1 }));
		input.add(createLinkedList(new int[] { 1, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 3, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 3, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }));
		input.add(createLinkedList(new int[] { 1, 2 }));
		input.add(createLinkedList(new int[] { 1, 2, 2 }));
		input.add(createLinkedList(new int[] { 1, 2, 2, 3 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 2, 4 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 3, 2, 5 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 3, 2, 5 }));
		input.add(createLinkedList(new int[] { 1, 2, 3, 4, 4, 3, 2, 5 }));
		boolean[] expected = { true, true, true, true, true, true, true, true,
				true, false, false, false, false, false, false, false };
		for (int i = 0; i < input.size(); i++) {
			System.out.println(i);
			assertEquals(expected[i], obj.isPalindromeRecursive(input.get(i)));
		}

	}
	@Test
	public void testAddNumbers() {
		List<ListNode[]> input = new ArrayList<ListNode[]>();
		input.add(new ListNode[] { createLinkedList(new int[] { 1, 2, 3, 4 }),
				createLinkedList(new int[] { 9, 9, 9, 9 }) });
		input.add(new ListNode[] { createLinkedList(new int[] {}),
				createLinkedList(new int[] { 9, 9, 9, 9 }) });
		input.add(new ListNode[] { createLinkedList(new int[] { 9, 9, 9, 9 }),
				createLinkedList(new int[] {}) });
		input.add(new ListNode[] { createLinkedList(new int[] { 9, 9, 9, 9 }),
				createLinkedList(new int[] { 1 }) });
		input.add(new ListNode[] { null,
				createLinkedList(new int[] { 9, 9, 9, 9 }) });
		input.add(new ListNode[] { createLinkedList(new int[] { 1 }), null });
		input.add(new ListNode[] { null, null });
		String expected[] = { "02341", "9999", "9999", "00001", "9999", "1", "" };
		for (int i = 0; i < input.size(); i++) {
			ListNode result = obj.addNumbers(input.get(i)[0], input.get(i)[1]);
			String actual = stringifyList(result);
			assertEquals(expected[i], actual);
		}

	}

	private ListNode createLinkedList(int[] a) {
		ListNode head = new ListNode(1);
		ListNode runner = head;
		for (int i : a) {
			runner.next = new ListNode(i);
			runner = runner.next;
		}
		return head.next;
	}

	private void createLoop(ListNode head, int atPosition) {
		if (head == null)
			return;
		ListNode tail = findTail(head);
		if (tail != null) {
			int i;
			for (i = 0; head != null && head.next != null && i < atPosition; i++)
				head = head.next;
			if (i == atPosition)
				tail.next = head;
		}

	}

	private ListNode findTail(ListNode head) {
		if (head == null || head.next == null)
			return head;
		while (head.next != null)
			head = head.next;
		return head;
	}

	private void createDuplicateEntries(ListNode head) {
		while (head != null) {
			head.val = 1;
			head = head.next;
		}

	}

	private String stringifyList(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val);
			// System.out.println(head.val);
			head = head.next;
		}
		return sb.toString();
	}

}
