import java.util.ArrayList;
import java.util.List;

public class 两两交换相邻的节点 {

    public static Node swapPairs(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        Node temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{1,2,3};
        Node l3 = new Node();
        for (int i : l1) {
            l3.addNode(new Node(i));
        }
        Node res = swapPairs(l3.head);
        res.printNode();
    }
}
