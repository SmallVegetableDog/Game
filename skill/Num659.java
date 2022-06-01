package skill;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * 示例 2：
 * <p>
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 示例 3：
 * <p>
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10000
 */
public class Num659 {

    public static void main(String[] args) {
        Num659 num659 = new Num659();
        System.out.println(num659.isPossible(new int[]{1, 2, 3, 5, 5, 6, 7}));
    }

    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            boolean flag = false;
            Iterator<int[]> iterator = queue.iterator();
            while (iterator.hasNext()) {
                int[] ints = iterator.next();
                if (ints[1] == num - 1) {
                    ints[0]++;
                    ints[1] = num;
                    flag = true;
                    iterator.remove();
                    queue.offer(ints);
                    break;
                }
            }
            if (!flag) {
                queue.offer(new int[]{1, num});
            }
        }
        int[] poll = queue.poll();
        if (poll[0] >= 3) {
            return true;
        }
        return false;
    }
}
