package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 */
public class Num90 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        LinkedList<Integer> subRes = new LinkedList<>();
        backTrack(subRes, nums, 0);
        return res;

    }

    private void backTrack(LinkedList<Integer> subRes, int[] nums, int start) {
        res.add(new LinkedList<>(subRes));

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            subRes.add(nums[i]);
            backTrack(subRes, nums, i + 1);
            subRes.removeLast();
        }
    }

    public static void main(String[] args) {
        Num90 num90 = new Num90();
        int[] ints = {1, 2, 2};
        List<List<Integer>> lists = num90.subsetsWithDup(ints);
        System.out.println(lists);
    }
}
