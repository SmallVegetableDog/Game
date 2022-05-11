package skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 链接：https://leetcode.cn/problems/3sum
 */
public class Num15 {

    public static void main(String[] args) {
        Num15 num15 = new Num15();
        List<List<Integer>> lists = num15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums, 3, 0, 0);
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
