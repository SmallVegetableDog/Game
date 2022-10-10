package 动态规划;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 */
public class Num53 {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int dp0 = 0;

        //dp[n]以nums[n]结尾的最大和连续子数组
        for (int num : nums) {
            dp0 = Math.max(num, num + dp0);
            res = Math.max(dp0, res);
        }
        return res;
    }
}
