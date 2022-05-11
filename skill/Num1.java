package skill;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * 链接：https://leetcode.cn/problems/two-sum
 */
public class Num1 {

    //排序+二分查找
//    public int[] twoSum(int[] nums, int target) {
//        int l = 0;
//        int h = nums.length - 1;
//        int[] clone = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            clone[i] = nums[i];
//        }
//
//        Arrays.sort(nums);
//        while (l <= h) {
//            int sum = nums[l] + nums[h];
//            if (sum == target) {
//                int res1 = -1, res2 = -1;
//                for (int i = 0; i < clone.length; i++) {
//                    if (clone[i] == nums[l] && res1 == -1) {
//                        res1 = i;
//                        continue;
//                    }
//                    if (clone[i] == nums[h] && res2 == -1) {
//                        res2 = i;
//                    }
//                }
//                return new int[]{res1, res2};
//            } else if (sum < target) {
//                l++;
//            } else {
//                h--;
//            }
//        }
//        return null;
//    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
