package 杂项;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/
 */

public class 合并k个升序链表 {

    static Node mergeKLists(Node[] lists) {
        if (lists.length == 0){
            return null;
        }
        Node res = lists[0];
        int i = lists.length - 1;
        int j = 1;
        while (i != 0){
            res = 合并两个链表.merge(res.head,lists[j].head);
            j = j + 1;
            i = i - 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{1,2,3};
        int[] l2 = new int[]{4,5};
        int[] l5 = new int[]{2,6};
        Node l3 = new Node(),l4 = new Node(),l6 = new Node();
        for (int i : l1) {
            l3.addNode(new Node(i));
        }
        for (int i : l2) {
            l4.addNode(new Node(i));
        }
        for (int i : l5) {
            l6.addNode(new Node(i));
        }
        Node[] list = new Node[]{l3,l4,l6};
        Node res = mergeKLists(list);
        assert res != null;
        res.head.printNode();
    }
}
