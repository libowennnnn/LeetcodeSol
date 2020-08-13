package com.libowennnnn.leetcode;

//25
public class ReverseNodesInKgroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        for (int i = 0;i < k; i++){
            if(tmp == null) return head;
            else tmp = tmp.next;
        }
        ListNode pre = reverseKGroup(tmp,k);
        ListNode cur = head;
        for (int i = 0; i < k; i++){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp; }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
