package 单调队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class Num239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //单调递减队列，保证队列头是最大的数
            while (!queue.isEmpty()) {
                if (queue.getLast() < nums[i]) {
                    queue.removeLast();
                } else {
                    break;
                }
            }
            queue.add(nums[i]);
            //进行滑动窗口填充值
            if (i >= k - 1) {
                res[i + 1 - k] = queue.peek();
                //若相等，说明滑动窗口第一个值就是队首的值，下一次窗口活动时，该值就会被移走，所以需要出队
                if (queue.peek() == nums[i + 1 - k]) {
                    queue.poll();
                }
            }
        }
        return res;
    }
}
