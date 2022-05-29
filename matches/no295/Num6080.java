package matches.no295;

import java.util.Stack;

/**
 * 6080. 使数组按非递减顺序排列 显示英文描述
 * 通过的用户数191
 * 尝试过的用户数3166
 * 用户总通过次数212
 * 用户总提交次数8423
 * 题目难度Medium
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < i < nums.length 。
 * <p>
 * 重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,3,4,4,7,3,6,11,8,5,11]
 * 输出：3
 * 解释：执行下述几个步骤：
 * - 步骤 1 ：[5,3,4,4,7,3,6,11,8,5,11] 变为 [5,4,4,7,6,11,11]
 * - 步骤 2 ：[5,4,4,7,6,11,11] 变为 [5,4,7,11,11]
 * - 步骤 3 ：[5,4,7,11,11] 变为 [5,7,11,11]
 * [5,7,11,11] 是一个非递减数组，因此，返回 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,7,7,13]
 * 输出：0
 * 解释：nums 已经是一个非递减数组，因此，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class Num6080 {

    public static void main(String[] args) {
        Num6080 num6080 = new Num6080();
        System.out.println(num6080.totalSteps(new int[]{10, 1, 2, 3, 4, 5, 6, 1, 2, 3}));
    }

    //单调递减栈
    public int totalSteps(int[] nums) {
        int res = 0;
        Stack<int[]> stack = new Stack<>();
        for (int num : nums) {
            int count = 0;
            //设 nums[i]nums[i] 被 nums[j](j < i)nums[j](j<i) 消除。
            // 那么，位于 jj 和 ii 之间的元素一定被首先消除，使得 nums[j]nums[j] 和 nums[i]nums[i] 相邻，
            // 然后再是 nums[j]nums[j] 消除 nums[i]nums[i]。设 f[i]f[i] 为 nums[i]nums[i] 被消除所需的轮数，
            // 那么 f[i] = {max(f[j+1]... f[i-1]) + 1}
            while (!stack.isEmpty() && stack.peek()[0] <= num) {
                int[] pop = stack.pop();
                count = Math.max(count, pop[1]);
            }
            //栈不为空，说明num元素前面还有一个比num大的数字，可以消灭掉num，因此操作数+1
            if (!stack.isEmpty()) {
                count++;
            }
            res = Math.max(res, count);
            stack.add(new int[]{num, count});
        }
        return res;
    }
}
