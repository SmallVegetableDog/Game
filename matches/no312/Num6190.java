package matches.no312;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 6190. 找到所有好下标 显示英文描述
 * 通过的用户数2057
 * 尝试过的用户数3652
 * 用户总通过次数2091
 * 用户总提交次数9911
 * 题目难度Medium
 * 给你一个大小为 n 下标从 0 开始的整数数组 nums 和一个正整数 k 。
 *
 * 对于 k <= i < n - k 之间的一个下标 i ，如果它满足以下条件，我们就称它为一个 好 下标：
 *
 * 下标 i 之前 的 k 个元素是 非递增的 。
 * 下标 i 之后 的 k 个元素是 非递减的 。
 * 按 升序 返回所有好下标。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,1,1,1,3,4,1], k = 2
 * 输出：[2,3]
 * 解释：数组中有两个好下标：
 * - 下标 2 。子数组 [2,1] 是非递增的，子数组 [1,3] 是非递减的。
 * - 下标 3 。子数组 [1,1] 是非递增的，子数组 [3,4] 是非递减的。
 * 注意，下标 4 不是好下标，因为 [4,1] 不是非递减的。
 * 示例 2：
 *
 * 输入：nums = [2,1,1,2], k = 2
 * 输出：[]
 * 解释：数组中没有好下标。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 3 <= n <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= n / 2
 */
public class Num6190 {
    public List<Integer> goodIndices(int[] nums, int k) {
        int len = nums.length;
        int[] prevFeiDiZeng = new int[len];
        int[] backFeiDiJian = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.size() >= k) {
                prevFeiDiZeng[i] = 1;
            }
            int num = nums[i];
            if (!stack.isEmpty() && stack.peek() < num) {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            stack.add(num);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            if (stack.size() >= k) {
                backFeiDiJian[i] = 1;
            }
            int num = nums[i];
            if (!stack.isEmpty() && stack.peek() < num) {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            stack.add(num);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (prevFeiDiZeng[i] == 1 && backFeiDiJian[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }
}
