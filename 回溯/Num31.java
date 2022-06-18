package 回溯;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class Num31 {

    public static void main(String[] args) {
        Num31 num31 = new Num31();
        num31.nextPermutation(new int[]{1, 2, 3});
        System.out.println();
    }

    boolean next;

    boolean end;

    Set<Integer> visit;


    public void nextPermutation(int[] nums) {
        visit = new LinkedHashSet<>(nums.length);
        int[] backNums = nums.clone();
        Arrays.sort(nums);
        backTrack(nums, backNums);
        Iterator<Integer> iterator = visit.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            nums[i] = iterator.next();
        }
    }

    private void backTrack(int[] nums, int[] backNums) {
        if (visit.size() == nums.length) {
            if (next) {
                end = true;
                return;
            }
            next = true;
            Iterator<Integer> iterator = visit.iterator();
            int j = 0;
            while (iterator.hasNext()) {
                if (backNums[j++] != iterator.next()) {
                    next = false;
                }
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit.contains(nums[i])) {
                continue;
            }
            visit.add(nums[i]);
            backTrack(nums, backNums);
            if (end) {
                return;
            }
            visit.remove(nums[i]);

        }
    }
}
