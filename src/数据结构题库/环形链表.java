package 数据结构题库;

import java.util.HashSet;
import java.util.Set;

/**
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环
 */

public class 环形链表 {

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>(16);
        while (head != null){
            if (!nodes.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    ListNode head;
    public void addNode(ListNode node){
        ListNode temp = head;
        if(head == null){
            head = node;
        }else {
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

}
