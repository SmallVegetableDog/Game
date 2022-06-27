package 树;

/**
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
public class Num124 {

    public static void main(String[] args) {
        Num124 num124 = new Num124();
        TreeNode treeNode = new TreeNode(-3);
//        treeNode.left = new TreeNode(-2);
//        treeNode.right = new TreeNode(3);

        System.out.println(num124.maxPathSum(treeNode));
    }

    public int maxPathSum(TreeNode root) {
        return doMaxPathSum(root)[1];
    }

    //int[]{包含该root节点的最大值，这棵树的最大值}
    private int[] doMaxPathSum(TreeNode root) {
        if (root == null) {
            return new int[]{-10000, -10000};
        }
        int[] left = doMaxPathSum(root.left);
        int[] right = doMaxPathSum(root.right);
        int containRootVal = root.val;
        containRootVal = Math.max(containRootVal, root.val + left[0]);
        containRootVal = Math.max(containRootVal, root.val + right[0]);
        int maxVal = root.val;
        maxVal = Math.max(maxVal, left[1]);
        maxVal = Math.max(maxVal, right[1]);
        int l0 = left[0] == -10000 ? 0 : left[0];
        int r0 = right[0] == -10000 ? 0 : right[0];
        maxVal = Math.max(maxVal, root.val + l0);
        maxVal = Math.max(maxVal, root.val + r0);
        maxVal = Math.max(maxVal, root.val + l0 + r0);
        return new int[]{containRootVal, maxVal};
    }
}
