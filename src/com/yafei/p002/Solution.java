package com.yafei.p002;

/**
 * @Author lyf
 * @Date 2021/8/16
 */

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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode tempNode = new ListNode();
		ListNode head = tempNode;
		ListNode t1 = l1;
		ListNode t2 = l2;
		int high = 0;
		while (t1!= null || t2!= null || high != 0) {
			int temp = (t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0)  + high;
			tempNode.next = new ListNode();
			tempNode.next.val = temp % 10;
			tempNode = tempNode.next;
			high = temp / 10;
			t1 = t1 == null ? null : t1.next;
			t2 = t2 == null ? null : t2.next;
		}
		return head.next;
	}
}
