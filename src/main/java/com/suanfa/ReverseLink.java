package com.suanfa;

import com.suanfa.model.ListNode;

public class ReverseLink {
 
	public static void main(String[] args) {
		ListNode head = createLink();
		printLink(head);
		head = reverse1(head);
		printLink(head);
		
		head = reverse2(createLink(), 2);
		printLink(head);
	}
 
	/**
	 * 链表翻转。给出一个链表和一个数k 比如链表1→2→3→4→5→6 若k=2，则翻转后2→1→4→3→6→5 若k=3,翻转后3→2→1→6→5→4
	 * 若k=4，翻转后4→3→2→1→5→6
	 * 
	 * @param head
	 * @param offset
	 * @return
	 */
	private static ListNode reverse2(ListNode head, int offset) {
		if (head == null) {
			return null;
		}
		ListNode pre = null;//部分反转的链表
		ListNode newN = null;//新的链表
		ListNode tail = null;//记录下一部分的真实引用
		//TODO 需要计算划分为几部分,现在是写死的
		for (int j = 0; j < 3; j++) {
			//tmp起始为0,目的是尾部的临时链表
			ListNode tmp = head;
			for (int i = 0; i < offset; i++) {
				ListNode next = head.next;
				head.next = pre;
				pre = head;
				head = next;
			}
			//记录第一部分反转的引用
			if (j == 0) {
				newN = pre;
			}
			//tmp起始为下一部分的引用,没有则为null
			tmp.next = head;
			if (tail != null) {
				tail.next = pre;//设置下一个部分的起始引用指向当前部分的反转引用
			}
			//记录下一个部分的起始引用
			tail = tmp;
		}
		return newN;
	}
 
	/**
	 * 单链表反转
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode reverse1(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		head.next = null;
		return pre;
	}
 
	private static void printLink(ListNode head) {
		ListNode on = head;
		while (on != null) {
			System.out.print(on.val + "\t");
			on = on.next;
		}
		System.out.println("\n");
	}
 
	private static ListNode createLink() {
		ListNode head = new ListNode(0);
		ListNode next;
		ListNode cur = null;
		for (int i = 1; i < 6; i++) {
			next = new ListNode(i);
			if (i == 1) {
				head.next = next;
			} else {
				cur.next = next;
			}
			cur = next;
		}
		return head;
	}
 
}
