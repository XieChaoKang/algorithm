package 树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 验证二叉搜索树 {

    /**
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 暴力破解
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return  true;
        }
        boolean flag = true;
        if (root.left != null){
            flag = root.val > root.left.val;
        }
        if (root.right != null){
            flag = root.val < root.right.val;
        }
        isValidBST(root.left);
        isValidBST(root.right);
        return flag;
    }

    /**
     * 中序遍历 当后一个值比前一个值小的时候 这棵树就不是二叉搜索树
     */
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        double temp = -Double.MAX_EXPONENT;
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (root.val <= temp){
                return false;
            }
            temp = root.val;
            root = root.right;
        }
        return true;
    }
}
