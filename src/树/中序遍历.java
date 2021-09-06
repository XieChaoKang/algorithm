package 树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 中序遍历 {
    public static void main(String[] args) {
        int i = 80;
        String s = String.valueOf(i < 100 ? 90 : 100);
        String t = String.valueOf(i < 100 ? 90 : 100.0);
        System.out.println("两者是否相等:" +s.equals(t));
    }
}

class Solution {

    //递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode node, List<Integer> list) {
        if (node == null){
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    //迭代
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
