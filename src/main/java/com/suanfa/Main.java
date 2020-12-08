package com.suanfa;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        
        LinkNode root = new LinkNode(null, null, 1);
        LinkNode root2 = new LinkNode(null, null, 2);
        LinkNode root3 = new LinkNode(null, null, 3);
        LinkNode root4 = new LinkNode(null, null, 4);
        LinkNode root5 = new LinkNode(null, null, 5);
        root.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;
        
        LinkNode newRoot = reverseLinkNode(root);
        
        while (newRoot != null) {
            System.out.print(newRoot.data + "->");
            newRoot = newRoot.next;
        }
        
    }
    
    private static LinkNode reverseLinkNode(LinkNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        
        LinkNode dummy = new LinkNode(null, null, -1);
        
        while (root != null) {
            if (dummy.next == null) {
                LinkNode rootNext = root.next;
                dummy.next = root;
                root.next = null;
                root = rootNext;
            } else {
                LinkNode next = dummy.next;
                LinkNode rootNext = root.next;
                root.next = next;
                dummy.next = root;
                root = rootNext;
            }
        }
        
        return dummy.next;
    }
    
    static class LinkNode {
        
        private LinkNode pre;
        private LinkNode next;
        private Object data;
        
        LinkNode (LinkNode pre, LinkNode next, Object data) {
            this.pre = pre;
            this.next = next;
            this.data = data;
        }
    }
}