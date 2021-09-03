package 数据结构题库;

public class 删除链表重复元素 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val){
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
