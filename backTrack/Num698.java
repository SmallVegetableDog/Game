package backTrack;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 * <p>
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 */
public class Num698 {
    HashMap<String, Boolean> flag = new HashMap();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        int target = sum / k;
        if (target * k != sum) {
            return false;
        }

        boolean[] used = new boolean[nums.length];

        return backTrack(nums, k, 0, 0, target, used);
    }

    /**
     * 以子集的视角考虑，每个数字要么进入第k个子集要么不进入
     *
     * @param nums   数字数组
     * @param k      第k个子集
     * @param index  数字数组的索引下标，代表当前这个子集遍历到nums数字的位置
     * @param sum    第k个子集的和
     * @param target 目标和
     * @param used   标识数字数组有哪些数字已经使用过
     * @return 结果
     */
    private boolean backTrack(int[] nums, int k, int index, int sum, int target, boolean[] used) {
        if (k == 0) {
            return true;
        }
        if (sum == target) {
            boolean res = backTrack(nums, k - 1, 0, 0, target, used);
            flag.put(Arrays.toString(used), res);
            return res;
        }
        if (flag.containsKey(Arrays.toString(used))) {
            if (!flag.get(Arrays.toString(used))) {
                return false;
            }
        }
        for (; index < nums.length; index++) {
            if (used[index]) {
                continue;
            }
            if (nums[index] + sum > target) {
                continue;
            }
            used[index] = true;
            if (backTrack(nums, k, index + 1, sum + nums[index], target, used)) {
                return true;
            }
            used[index] = false;
        }
        return false;
    }
}
