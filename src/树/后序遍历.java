package 树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 后序遍历 {

    //递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }

    //迭代
    public List<Integer> postorderTraversa1l(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        TreeNode temp = null;
        while (!nodeDeque.isEmpty() || root != null){
            while (root != null){
                nodeDeque.push(root);
                root = root.left;
            }
            root = nodeDeque.pop();
            if (root.right == null || root.right == temp){
                result.add(root.val);
                temp = root;
                root = null;
            }else {
                nodeDeque.push(root);
                root = root.right;
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
