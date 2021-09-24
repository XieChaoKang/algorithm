package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * 广度优先算法：
 * 借助辅助参数 标识当前遍历的层次
 * 返回值result的外层list的index就是层次 因此当result的长度等于当前层次时，则代表该层次没有遍历过，需要new一个对象add进去
 * 同时，因为层次即是外层index 所以 result.get(level).add(node.val) 将当前节点添加进返回值中
 * 然后递归深度遍历左右子树
 */
public class 树的层次遍历 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return result;
        }
        return helper(root, 0);
    }

    public List<List<Integer>> helper(TreeNode node, int level){
        // 当result的长度等于当前层次时，则代表该层次没有遍历过，需要new一个对象add进去
        if (result.size() == level){
            result.add(new ArrayList<Integer>());
        }
        // 将当前节点添加进返回值中
        result.get(level).add(node.val);
        // 递归深度遍历左右子树
        if (node.left != null){
            helper(node.left, level + 1);
        }
        if (node.right != null){
            helper(node.right, level+1);
        }
        return result;
    }
}
