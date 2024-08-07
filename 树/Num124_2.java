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
public class Num124_2 {

    public static void main(String[] args) {
        Num124_2 num124 = new Num124_2();
        TreeNode treeNode = new TreeNode(-3);
//        treeNode.left = new TreeNode(-2);
//        treeNode.right = new TreeNode(3);

        System.out.println(num124.maxPathSum(treeNode));
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    //返回这棵树的最大路径和
    private int traverse(TreeNode root) {
        if (root == null) {
            return -10001;
        }
        int sum1 = traverse(root.left);
        int sum2 = traverse(root.right);
        int max = this.max(sum1, sum2, root.val, sum1 + root.val, sum2 + root.val, sum1 + sum2 + root.val);
        maxSum = this.max(maxSum, max);
        return this.max(sum1 + root.val, sum2 + root.val, root.val);
    }

    int max(int... num) {
        if (num.length == 0) {
            return 0;
        }
        int max = num[0];
        for (int n : num) {
            max = Math.max(n, max);
        }
        return max;
    }
}
