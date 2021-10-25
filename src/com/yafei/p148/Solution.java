package com.yafei.p148;

/**
 * @author lyf
 * @date 2021/10/18
 */

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode sortList(ListNode head) {
		if (null == head) {
			return null;
		}
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		return sort(head, tail);
	}

	public ListNode sort(ListNode left, ListNode right) {
		if (Objects.equals(left, right)) {
			ListNode node = new ListNode(left.val);
			node.next = null;
			return node;
		}
		ListNode slow = left;
		ListNode fast = left;
		while (fast != null && fast.next != null && fast.next.next != null && !right.equals(fast) && !right.equals(fast.next)) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow;

		ListNode leftHead = sort(left, mid);
		ListNode rightHead = sort(mid.next, right);
		ListNode re = null;
		ListNode temp = null;
		while (leftHead != null && rightHead != null) {
			ListNode next;
			if (leftHead.val < rightHead.val) {
				next = leftHead;
				leftHead = leftHead.next;
			} else {
				next = rightHead;
				rightHead = rightHead.next;
			}
			if (null == temp) {
				re = next;
				temp = next;
			} else {
				temp.next = next;
				temp = temp.next;
			}
		}
		ListNode tempNode = null == leftHead ? rightHead : leftHead;
		if (null != tempNode) {
			if (re == null) {
				re = tempNode;
			} else {
				temp.next = tempNode;
			}
		}
		return re;
	}

	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(8);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(6);
		ListNode listNode4 = new ListNode(3);
		ListNode listNode5 = new ListNode(2);
		ListNode listNode6 = new ListNode(9);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = null;

		ListNode listNode = new Solution().sortList(listNode1);
		while (null != listNode) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
