package matches.no342;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 6390. 滑动子数组的美丽值 显示英文描述
 * 通过的用户数543
 * 尝试过的用户数1092
 * 用户总通过次数554
 * 用户总提交次数1505
 * 题目难度Medium
 * 给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。
 * <p>
 * 一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。
 * <p>
 * 请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。
 * <p>
 * 子数组指的是数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-1,-3,-2,3], k = 3, x = 2
 * 输出：[-1,-2,-2]
 * 解释：总共有 3 个 k = 3 的子数组。
 * 第一个子数组是 [1, -1, -3] ，第二小的数是负数 -1 。
 * 第二个子数组是 [-1, -3, -2] ，第二小的数是负数 -2 。
 * 第三个子数组是 [-3, -2, 3] ，第二小的数是负数 -2 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,-2,-3,-4,-5], k = 2, x = 2
 * 输出：[-1,-2,-3,-4]
 * 解释：总共有 4 个 k = 2 的子数组。
 * [-1, -2] 中第二小的数是负数 -1 。
 * [-2, -3] 中第二小的数是负数 -2 。
 * [-3, -4] 中第二小的数是负数 -3 。
 * [-4, -5] 中第二小的数是负数 -4 。
 * 示例 3：
 * <p>
 * 输入：nums = [-3,1,2,-3,0,-3], k = 2, x = 1
 * 输出：[-3,0,-3,-3,-3]
 * 解释：总共有 5 个 k = 2 的子数组。
 * [-3, 1] 中最小的数是负数 -3 。
 * [1, 2] 中最小的数不是负数，所以美丽值为 0 。
 * [2, -3] 中最小的数是负数 -3 。
 * [-3, 0] 中最小的数是负数 -3 。
 * [0, -3] 中最小的数是负数 -3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= k <= n
 * 1 <= x <= k
 * -50 <= nums[i] <= 50
 */
public class Num6390 {

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int BIAS = 50;
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int[] cnt = new int[BIAS * 2 + 1];

        //先预填充k-1个数，因为nums[i]可能为负数，所以得加上BIAS
        for (int i = 0; i < k - 1; i++) {
            cnt[nums[i] + BIAS]++;
        }

        //开始滑动窗口
        for (int i = k - 1; i < len; i++) {
            cnt[nums[i] + BIAS]++;
            //开始在滑动区间内获取第x小的数，由于第x小的数不是负数即返回0，所以只需要遍历cnt中[0，50)这个区间，因为这个区间其实是统计的负数的数量；
            int xx = x;
            for (int j = 0; j < BIAS; j++) {
                xx = xx - cnt[j];
                if (xx <= 0) {
                    res[i - k + 1] = j - BIAS;
                    break;
                }
            }
            cnt[nums[i - k + 1] + BIAS]--;
        }
        return res;
    }
}