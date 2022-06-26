package 树.动态规划;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 19
 */
public class Num96 {


    public static void main(String[] args) {
        Num96 num96 = new Num96();
        System.out.println(num96.numTrees(19));
    }

    int[] memo;

    public int numTrees(int n) {
        memo = new int[n + 1];
        return doNumTrees(1, n);
    }

    /**
     * 给定一个有序序列 1 \cdots n1⋯n，为了构建出一棵二叉搜索树，我们可以遍历每个数字 ii，将该数字作为树根，将 1 \cdots (i-1)1⋯(i−1) 序列作为左子树，将 (i+1) \cdots n(i+1)⋯n 序列作为右子树。接着我们可以按照同样的方式递归构建左子树和右子树。
     *
     * 在上述构建的过程中，由于根的值不同，因此我们能保证每棵二叉搜索树是唯一的。
     *
     * 由此可见，原问题可以分解成规模较小的两个子问题，且子问题的解可以复用。
     *
     * @param left
     * @param right
     * @return
     */
    private int doNumTrees(int left, int right) {
        if (right < left) {
            return 1;
        }
        if (memo[right-left+1] != 0) {
            return memo[right-left+1];

        }
        int res = 0;
        for (int num = left; num <= right; num++) {
            int numLeft = doNumTrees(left, num - 1);
            int numRight = doNumTrees(num + 1, right);
            res = res + (numLeft * numRight);
        }
        memo[right-left+1] = res;
        return res;
    }
}
