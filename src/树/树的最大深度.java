package 树;

import java.util.Deque;
import java.util.LinkedList;

public class 树的最大深度 {

    //递归
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth1(TreeNode root){
        if (root == null){
            return 0;
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.offer(root);
        int res = 0;
        while (!nodeDeque.isEmpty()){
            int size = nodeDeque.size();
            while (size > 0){
                TreeNode pop = nodeDeque.poll();
                if (pop.left != null){
                    nodeDeque.offer(pop.left);
                }
                if (pop.right != null){
                    nodeDeque.offer(pop.right);
                }
                size--;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}


