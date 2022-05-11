package skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * <p>
 * 链接：https://leetcode.cn/problems/4sum
 */
public class Num18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    private List<List<Integer>> nSum(int[] nums, int index, int start, int target) {
        if (index > nums.length - start) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        if (index == 2) {
            return getTwoSum(nums, target, start);
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> subRes = nSum(nums, index - 1, i + 1, target - nums[i]);
                if (subRes.size() > 0) {
                    for (List<Integer> val : subRes) {
                        val.add(0, nums[i]);
                    }
                    res.addAll(subRes);
                }
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }
        return res;
    }

    private List<List<Integer>> getTwoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start;
        int h = nums.length - 1;
        while (l < h) {
            int sum = nums[l] + nums[h];
            if (sum == target) {
                ArrayList<Integer> subRes = new ArrayList<>();
                subRes.add(nums[l]);
                subRes.add(nums[h]);
                res.add(subRes);
                l++;
                h--;
                while (l <= h && nums[l] == nums[l - 1]) {
                    l++;
                }
            } else if (sum < target) {
                l++;
            } else {
                h--;
            }
        }
        return res;
    }
}
