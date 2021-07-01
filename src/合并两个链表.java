/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */

public class 合并两个链表 {

    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{1,2,3};
        int[] l2 = new int[]{1,4,5};
        Node l3 = new Node(),l4 = new Node();
        for (int i : l1) {
            l3.addNode(new Node(i));
        }
        for (int i : l2) {
            l4.addNode(new Node(i));
        }
        Node res = mergeTwoLists(l3,l4);
        res.printNode();
    }
}

class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }

    private Node head;

    public void addNode(Node node){
        Node temp = head;
        if(head == null){
            head = node;
        }else {
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void printNode(){
        System.out.println(this.val);
        if (this.next != null){
            this.next.printNode();
        }
    }

}
