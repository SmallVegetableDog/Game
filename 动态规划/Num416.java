package 动态规划;

import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 */
public class Num416 {

    public static void main(String[] args) {
        Num416 num416 = new Num416();
        System.out.println(num416.canPartition(new int[]{2, 6}));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        //dp[i][j] == 前i个数字能否凑成和为j
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        //base case 和为0的话不用凑也满足，为true
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    if (j == target && dp[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
