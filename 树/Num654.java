package 树;

import java.util.TreeSet;

/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 */
public class Num654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return doConstruct(nums, 0, nums.length - 1);
    }

    private TreeNode doConstruct(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(nums[i]);
        }
        int maxValIndex = i, maxVal = nums[i];
        int k;
        for (k = i; k <= j; k++) {
            if (nums[k] > maxVal) {
                maxVal = nums[k];
                maxValIndex = k;
            }
        }
        TreeNode leftTree = doConstruct(nums, i, maxValIndex - 1);
        TreeNode rightTree = doConstruct(nums, maxValIndex + 1, j);
        TreeNode root = new TreeNode(nums[maxValIndex]);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
