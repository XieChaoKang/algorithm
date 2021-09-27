package 树;

public class 二叉搜索树的插入 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (true){
            if (temp.val > val){
                if (temp.left == null){
                    temp.left = new TreeNode(val);
                    break;
                }else {
                    temp = temp.left;
                }
            }else {
                if (temp.right == null){
                    temp.right = new TreeNode(val);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }
}
