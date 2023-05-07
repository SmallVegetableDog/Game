package 双指针;

import java.util.Arrays;

/**
 * 1679. K 和数对的最大数目
 * 提示
 * 中等
 * 41
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * <p>
 * 返回你可以对数组执行的最大操作数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 */
public class Num1679 {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, h = nums.length - 1;
        int res = 0;
        while (l < h) {
            int sum = nums[l] + nums[h];
            if (sum == k) {
                res++;
                l++;
                h--;
            } else if (sum > k) {
                h--;
            } else {
                l++;
            }
        }
        return res;
    }
}
