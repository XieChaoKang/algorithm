/**
 * 删除链表倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */

public class 删除链表倒数第N个结点 {

    static ListNode del(ListNode head, int n){
        ListNode d = new ListNode(0,head);
        ListNode first = d;
        ListNode second = d;

        for (int i = 0; i < n+1; i++) {
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return d.next;
    }

    public static void main(String[] args) {


    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
