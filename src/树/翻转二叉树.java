package 树;

/**
 * 交换当前节点的左右节点 递归交换左子树的左右节点 递归交换右子树的左右节点
 */
public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
    }
}
