package 树;

public class 路径总和 {

    /**
     * 当当前节点为叶子节点时，值 和 sum相等 则代表有root节点到叶子节点的路径和为 sum
     * 分别递归 左右子树 同时 sum需要 - 当前节点的值 因为sum是这条路径的和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        //叶子节点 判断当前节点的值和sum是否相等
        if (root.left == null && root.right == null){
            return root.val == targetSum;
        }
        //递归左右子树
        return hasPathSum(root.left, targetSum - root.val) || (hasPathSum(root.right, targetSum - root.val));
    }
}
