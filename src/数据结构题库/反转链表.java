package 数据结构题库;

import java.util.ArrayList;
import java.util.List;

public class 反转链表 {

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    //暴力解法
    public ListNode reverseList1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(0);
        List<Integer> list = new ArrayList<>(10);
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode temp = result;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new ListNode(list.get(i));
        }
        return result.next;
    }

    public static void main(String[] args) {

    }
}
