package 数据结构题库;

public class 移除链表元素 {

    /**
     * 迭代
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode temp = result;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        for (int i = 2; i < 6; i++) {
            ListNode temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new ListNode(i);
        }
        for (int i = 2; i < 3; i++) {
            ListNode temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new ListNode(i);
        }
        ListNode t1 = head;
        while (t1.next != null){
            System.out.println(t1.val);
            t1 = t1.next;
        }
        ListNode a = removeElements(head, 1);
        while (a.next != null){
            System.out.println(a.val);
            a = a.next;
        }
    }
}


