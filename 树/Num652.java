package 树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 652. 寻找重复的子树
 * 中等
 * 相关标签
 * 相关企业
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 * <p>
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 * <p>
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 */
public class Num652 {

    List<TreeNode> res = new ArrayList<>();

    HashSet<String> memo = new HashSet<>();

    HashSet<String> resMemo = new HashSet<>();


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String val = left + "," + right + "," + root.val;
        if (memo.contains(val) && !resMemo.contains(val)) {
            res.add(root);
            resMemo.add(val);
        }
        memo.add(val);
        return val;
    }
}
