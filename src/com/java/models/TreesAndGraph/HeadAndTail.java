package com.java.models.TreesAndGraph;

import com.java.models.ITemplate;

public class HeadAndTail implements ITemplate{
	public TreeNode head;
	public TreeNode tail;

	public HeadAndTail(TreeNode head, TreeNode tail) {
		this.head = head;
		this.tail = tail;
	}


}