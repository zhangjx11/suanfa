package com.suanfa.model;

/**
 * @author zhangjingxiong
 */
public class ListNode {

    //节点上存储的元素
    public int val;

    // 指向下一个节点的指针
    public ListNode pre;

    // 指向下一个节点的指针
    public ListNode next;


    //节点的构造函数
    public ListNode() {}

    //节点的构造函数
    public ListNode(int val) {
        this.val = val;
    }
}
