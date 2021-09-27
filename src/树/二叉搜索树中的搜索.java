package 树;

public class 二叉搜索树中的搜索 {

    /**
     * root为 null 或者val相等的时候 返回 root
     * root.val > val 时 搜索 root 的左子树 否则搜索其右子树
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val){
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
