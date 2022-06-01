package tree;

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 */
public class Num965 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //简单题，递归遍历即可
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (val == left.val && val == right.val) {
                return isUnivalTree(left) && isUnivalTree(right);
            }
        } else if (left != null) {
            if (left.val == val) {
                return isUnivalTree(left);
            }
        } else {
            if (right.val == val) {
                return isUnivalTree(right);
            }
        }
        return false;
    }
}
