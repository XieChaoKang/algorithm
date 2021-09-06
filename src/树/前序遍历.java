package 树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 前序遍历 {

    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    //迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        TreeNode temp =root;
        while (!nodeDeque.isEmpty() || temp != null){
            while (temp != null){
                result.add(temp.val);
                nodeDeque.push(temp);
                temp = temp.left;
            }
            temp = nodeDeque.pop();
            temp = temp.right;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
