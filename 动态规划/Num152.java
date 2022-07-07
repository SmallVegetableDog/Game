package 动态规划;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 */
public class Num152 {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[][] res = new int[length][2];
        res[0][0] = nums[0];
        res[0][1] = nums[0];
        int o = nums[0];
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            int min = res[i - 1][0] * num;
            int max = res[i - 1][1] * num;
            res[i][0] = min(num, min, max);
            res[i][1] = max(num, min, max);
            o = Math.max(o, res[i][1]);
        }
        return o;
    }

    int max(int a, int b, int c) {
        return Math.max(a, (Math.max(b, c)));
    }

    int min(int a, int b, int c) {
        return Math.min(a, (Math.min(b, c)));
    }
}
