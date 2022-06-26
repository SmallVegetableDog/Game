package 树;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
public class Num98 {

    public boolean isValidBST(TreeNode root) {
        long[] val = doValidBST(root);
        return val[0] == 1;
    }

    //后序遍历太复杂了
    //前序遍历 todo
    private long[] doValidBST(TreeNode root) {
        // base case
        if (root == null) {
            //是否二叉搜索数，最小值，最大值
            return new long[]{1, Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] left = doValidBST(root.left);
        long[] right = doValidBST(root.right);
        long max = left[2];
        long min = right[1];
        int isValid = 0;
        if (left[0] == 1 && right[0] == 1) {
            if (root.val > max && root.val < min) {
                isValid = 1;
            }
        }
        min = Math.min(root.val, left[1]);
        max = Math.max(root.val, right[2]);
        return new long[]{isValid, min, max};
    }
}
