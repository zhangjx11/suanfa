package com.suanfa;

import com.suanfa.model.ListNode;

/**
 * 反转链表
 */
public class RevertList {

    public ListNode reverseList(ListNode head) {
        ListNode temp; // 保存cur的下一个节点
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            temp = cur.next;  // 保存一下 cur的下一个节点，因为接下来要改变cur->next
            cur.next = pre; // 翻转操作
            // 更新pre 和 cur指针
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode pre,ListNode cur){
        if(cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        // 可以和双指针法的代码进行对比，如下递归的写法，其实就是做了这两步
        // pre = cur;
        // cur = temp;
        return reverseList2(cur,temp);
    }
}
